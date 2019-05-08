package spg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import java.lang.String;

public class FlightOperation {
    private static FlightOperation instance = new FlightOperation();

    public static FlightOperation getInstance() {
        return instance;
    }

    public FlightOperation() {
    }

    public boolean saveFlight(Flight fli) {   //向数据库中加入数据
        boolean result = false;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();  //建立数据库连接
            String sqlInset = "insert into flight.tb_flight(flightNum, airways, place," +
                    " tim, resTicket, status, price, isStop) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInset);   //会抛出异常
            stmt.setString(1, fli.getFlightNum());
            stmt.setString(2, fli.getAirways());
            stmt.setString(3, StringUtils.join(fli.getPlace(), ","));
            stmt.setString(4, StringUtils.join(fli.getTime(), ","));
            stmt.setString(5, StringUtils.join(fli.getResTicket(), ","));
            stmt.setString(6, fli.getStatus());
            stmt.setString(7, StringUtils.join(fli.getPrice(), ","));
            stmt.setBoolean(8, fli.getIsStop());
            int i = stmt.executeUpdate();            //执行插入数据操作，返回影响的行数
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally { //finally的用处是不管程序是否出现异常，都要执行finally语句，所以在此处关闭连接
            try {
                conn.close(); //打开一个Connection连接后，最后一定要调用它的close（）方法关闭连接，以释放系统资源及数据库资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<Flight> selectFlight() {       //从数据库中查询所需数据
        List<Flight> fliList = new ArrayList<Flight>();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Flight.tb_flight");//执行SQL并返回结果集
            while (rs.next()) {
                Flight fli = new Flight();
                /*fli.(rs.getInt("empId"));
                fli.setEmpName(rs.getString("empName"));
                fli.setEmpAge(rs.getInt("empAge"));
                fli.setEmpSex(rs.getString("empSex"));*/
                fliList.add(fli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return fliList;                                             //返回结果
    }

    public boolean deleteFlightById(String flightNum) {//取消航班
        boolean result = false;
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            String sql = "delete from Flight.tb_flight where flightNum = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, flightNum);
            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }
}
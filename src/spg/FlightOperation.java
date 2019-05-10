package spg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import java.lang.String;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlightOperation implements Tool {
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

    public Flight selectFlight(String flightNum) {       //通过航班号从数据库中查询所需数据
        Flight fli = new Flight();
        Connection conn = null;
        try {
            conn = DatabaseConnection.getCon();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Flight.tb_flight where flightNum = ?");//执行SQL并返回结果集
            while (rs.next()) {
                String[] tim = rs.getString("tim").split(",");
                Timestamp[] time = new Timestamp[4];
                for (int i = 0; i < 4; i++)
                    time[i] = Timestamp.valueOf(tim[i]);
                String[] resTic = rs.getString("resTicket").split(",");
                int[] resTicket = new int[2];
                for (int i = 0; i < 2; i++)
                    resTicket[i] = Integer.parseInt(resTic[i]);
                String[] pri = rs.getString("price").split(",");
                int[] price = new int[2];
                for (int i = 0; i < 2; i++)
                    price[i] = Integer.parseInt(pri[i]);
                String[] wayb = rs.getString("waybill").split(",");
                int[] waybill = new int[MAXCAPACITY];
                for (int i = 0; i < MAXCAPACITY; i++)
                    waybill[i] = Integer.parseInt(wayb[i]);
                String[] appo = rs.getString("appoint").split(",");
                Queue[] appoint = new Queue[MAXCAPACITY / 2];
                for (int i = 0; i < MAXCAPACITY / 2; i++)
                    //appoint
                fli.setFlightNum(rs.getString("flightNum"));
                fli.setAirways(rs.getString("airways"));
                fli.setPlace(rs.getString("place").split(","));
                fli.setTime(time);
                fli.setResTicket(resTicket);
                fli.setStatus(rs.getString("status"));
                fli.setPrice(price);
                fli.setIsStop(rs.getBoolean("isStop"));
                fli.setWaybill(waybill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();                                         //关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fli;                                            //返回结果
    }

    public boolean deleteFlight(String flightNum) {//取消航班
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
                e.printStackTrace();
            }
        }
        return result;
    }
}
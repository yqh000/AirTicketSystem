package spg;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection conn = null;

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //加载数据库连接驱动
            String user = "root";
            String psw = "spgzho520";
            String url = "jdbc:mysql://127.0.0.1:3306/Flight?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convert_To_Null&useSSL=false";
            conn = DriverManager.getConnection(url, user, psw);  //获取连接
        } catch (Exception e) {
            System.out.println("连接数据库失败");
            e.printStackTrace();
        }
        return conn;
    }
}
package database;

import java.sql.*;

public class Connect {
    public static final String URL = "jdbc:mysql://localhost:3306/textStore?useSSL=false";
    public static final String USER = "mysql";
    public static final String PASSWORD = "mysql";
    private static Connection con = null;
    public void connect() {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return con;
    }
}
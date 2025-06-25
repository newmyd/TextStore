package database;

import java.sql.*;

public class Database {
    private static Connect con = new Connect();
    public void set(String fileName, String password) throws SQLException {
        con.connect();
        String str = "INSERT INTO file (fileName, password) VALUES (?, ?)";
        PreparedStatement sql = con.getConnection().prepareStatement(str); //预编译SQL，减少sql执行
        sql.setString(1, fileName);
        sql.setString(2, password);
        sql.execute();
    }
    public PairString get(int fileId) throws SQLException {
        con.connect();
        PairString ans = new PairString();
        ans.init();
        String str = "SELECT * FROM file where fileId = ?";
        PreparedStatement sql = con.getConnection().prepareStatement(str);
        sql.setInt(1, fileId);
        ResultSet res = sql.executeQuery();
        while (res.next()) {
            ans.fileName = res.getString("fileName");
            ans.password = res.getString("password");
        }
        return ans;
    }
    public int getFileId() throws SQLException {
        con.connect();
        int ans = 0;
        String str = "SELECT max(fileId) FROM file";
        PreparedStatement sql = con.getConnection().prepareStatement(str);
        ResultSet res = sql.executeQuery();
        while (res.next())
            ans = res.getInt("max(fileId)");
        return ans;
    }
}
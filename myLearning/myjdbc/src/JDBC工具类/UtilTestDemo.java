package JDBC工具类;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilTestDemo {
    public static void main(String[] args)  {
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from category");
            while (rs.next()) {
                System.out.println(rs.getObject("cid") + "" + rs.getObject("cname"));
            }
        } // 获取连接，使用工具类，封装了多个JDBC方法
        catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn, st, rs);   // 释放连接，使用工具类，也封装了多个JDBC方法
        }
    }





}

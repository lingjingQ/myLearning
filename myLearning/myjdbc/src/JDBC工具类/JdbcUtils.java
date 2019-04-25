package JDBC工具类;

import java.sql.*;

public class JdbcUtils {
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/day04";
    private static String username = "root";
    private static String password = "123456";
    static {
        try {
            Class.forName(DriverName);
        } catch (ClassNotFoundException e) {
//            System.out.println("驱动加载失败，请检查驱动包");
            throw new RuntimeException("驱动加载失败，请检查驱动包");
        }
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        1.加载驱动
//        Class.forName(DriverName);
        // 获取数据库连接
        Connection conn = DriverManager.getConnection(url,username,password);
        return conn;
    }
    public static void closeAll(Connection conn, Statement st, ResultSet rs) {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

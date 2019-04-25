package GJDBCUtils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class GJDBCUtils {
    private static String DriverName =null;
    private static String url =null;
    private static String username = null;
    private static String password = null;
    static {
        try {
            // 0 . 获取配置文件
            Properties ps = new Properties();
            ps.load(new FileInputStream("GJDBC_configure.properties"));
            DriverName = ps.getProperty("DriverName");
            url = ps.getProperty("url");
            username = ps.getProperty("username");
            password = ps.getProperty("password");
            Class.forName(DriverName);
        } catch (Exception e) {
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

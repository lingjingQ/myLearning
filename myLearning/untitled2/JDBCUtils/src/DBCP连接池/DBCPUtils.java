package DBCP连接池;



import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCPUtils {
    // 所有的连接池必须实现javax.sql.DataSource接口
    // 哪一个类实现了这个接口？ ---------- BasicDataSource

    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/day04";
    private static String username = "root";
    private static String password = "123456";

    private static BasicDataSource ds = new BasicDataSource();//连接池的实现类,创建一个连接池对象

    static {
        ds.setDriverClassName(DriverName);
    }

    public static Connection getConnection(){
        // 返回一个对象，从连接池中获取
        try {

            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return null;
        }
    }
}

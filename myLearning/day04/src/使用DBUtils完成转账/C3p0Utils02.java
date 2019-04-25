package 使用DBUtils完成转账;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3p0Utils02 {

    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        // 不用自己获取，而是从连接池获取。因为连接池从DriverManager获取过了。
        // 遵循DataSource接口
        // 在C3p0连接池中，哪个接口遵循了DataSource接口？
        // ComboPooledDataSource ，小型合并的连接池，该类实现了DataSource接口-------多态接受，实现接口中的方法
        return ds.getConnection();
    }
    public static void closeAll(Connection conn, Statement st, ResultSet rs) throws SQLException {
        if(conn != null){
            conn.close();
        }
        if( st != null){
            st.close();
        }
        if( rs != null){
            rs.close();
        }
    }
}

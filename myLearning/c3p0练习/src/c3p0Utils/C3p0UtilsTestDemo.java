package c3p0Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3p0UtilsTestDemo {
    public static void main(String[] args) throws SQLException {
//        insert();
//        delete();
        query();
    }
    public static void insert() throws SQLException {
        Connection conn = C3p0Utils02.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate("insert into users values ('shengxueqing','nanjing')");
        C3p0Utils02.closeAll(conn,st,null);
    }
    public static void delete () throws SQLException {
        Connection conn = C3p0Utils02.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate("delete from users where username = 'shengxueqing'");
        C3p0Utils02.closeAll(conn,st,null);
    }
    public static void query() throws SQLException {
        Connection conn = C3p0Utils02.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        while(rs.next()){
            System.out.println(rs.getObject("username") + "\t" + rs.getObject("password"));
        }
        C3p0Utils02.closeAll(conn,st,rs);
    }
}

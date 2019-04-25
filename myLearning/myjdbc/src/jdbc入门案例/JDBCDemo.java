package jdbc入门案例;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
//        java.sql.Driver driver = new com.mysql.jdbc.Driver();
////        DriverManager.registerDriver(driver);
        Class.forName("com.mysql.jdbc.Driver"); // 有了驱动，这些类已经加载到了内存中

        String url = "jdbc:mysql://localhost:3306/day04?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement st = conn.createStatement();
        System.out.println("插入前：");
        ResultSet rs = st.executeQuery("select * from category");
        while(rs.next()){
            System.out.println(rs.getObject("cid") + " " + rs.getObject("cname"));
        }
        System.out.println("插入后：");
        int rows = st.executeUpdate("insert into category values (4, 'drink')");
         rs = st.executeQuery("select * from category");
        while(rs.next()){
            System.out.println(rs.getObject("cid") + " " + rs.getObject("cname"));
        }
        rs.close();
        System.out.println(rows);
        st.close();
        conn.close();
    }
}

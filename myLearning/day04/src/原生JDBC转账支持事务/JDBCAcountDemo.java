package 原生JDBC转账支持事务;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  jack 转出  update acount set money = money-1000 where name = 'jack'
 *  tom 转入
 */
public class JDBCAcountDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/day06";
        String username = "root";
        String password = "123456";
        Connection connection = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);  // 关掉就相当于开启事务
            st = connection.createStatement();
            int rows1 = st.executeUpdate("update account set money = money-1000 where name = 'Jack'");
            System.out.println(1/0);
            int rows2 = st.executeUpdate("update account set money = money+1000 where name = 'Tom'");
            connection.commit();
            if (rows1 > 0 && rows2 > 0) {
                System.out.println("转账成功！");
            } else {
                System.out.println("转账失败");
            }
        }catch (Exception e){
            System.out.println("转账出现问题，回滚事务");
            connection.rollback();
        }finally {
            st.close();
            connection.close();
        }
    }
}

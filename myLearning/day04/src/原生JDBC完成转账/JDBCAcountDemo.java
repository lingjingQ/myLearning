package 原生JDBC完成转账;

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
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/day06";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement st = connection.createStatement();
        int rows1 = st.executeUpdate("update account set money = money-1000 where name = 'Jack'");
        int rows2 = st.executeUpdate("update account set money = money+1000 where name = 'Tom'");
        if(rows1>0 && rows2>0){
            System.out.println("转账成功！");
        }else {
            System.out.println("转账失败");
        }
        st.close();
        connection.close();
    }
}

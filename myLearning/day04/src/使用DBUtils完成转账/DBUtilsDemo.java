package 使用DBUtils完成转账;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilsDemo {
    public static void main(String[] args) throws SQLException {
        //1  创建QueryRunner 对象
        QueryRunner qr = new QueryRunner();
        // 2. 执行语句，但是没有获取连接池，所以接下需要自己手动创建一个连接池。
        // 这跟原生开发很像，区别在于不需要创建语句对象，不需要释放资源。也就是说QueryRunner对象自动创建语句对象，自动释放资源，但是不再自动拿连接对象了，因为我们没有给他连接池
        Connection connection = null;
        try {
            connection = C3p0Utils02.getConnection();
            connection.setAutoCommit(false); // 提示mysql不要自动提交，让我手动提交！！！！！！
            int row1 = qr.update(connection,"update account set money = money + ? where name = ?",1000, "Jack" );
//            System.out.println(1/0);
            int row2 = qr.update(connection,"update account set money = money - ? where name = ?",1000, "Tom" );
            if(row1 > 0 && row2>0) {
                System.out.println("转账成功");
            }
            connection.commit(); //手动提交！！！！！！！！！
        }catch (Exception e){
            connection.rollback();
            System.out.println("转账有错，已经回滚");
        }finally {
            connection.close();
        }
    }
}
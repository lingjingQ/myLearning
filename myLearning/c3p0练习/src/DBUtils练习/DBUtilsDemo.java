package DBUtils练习;

import c3p0Utils.C3p0Utils02;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class DBUtilsDemo {
    public static void main(String[] args) throws SQLException {
//        insert();
//        delete();
        update();

    }
    public static void insert() throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource()); // 有了连接池，就创建了这个对象，自动去连接池拿东西
        Object[] obj = {987,"pixie"};
        int rows = qr.update("insert into category(cid, cname) values (?, ?)",obj ); // 直接执行sql语句，把获取连接也封装起来了，
                                                                                        // 并且把执行之后释放资源的部分也封装了
        System.out.println(rows);
    }
    public static void delete() throws SQLException {
        new QueryRunner(C3p0Utils02.getDataSource()).update("delete from category where cname = ?" , "pixie");
    }
    public static void update() throws SQLException {
        new QueryRunner(C3p0Utils02.getDataSource()).update("update category set cname = ? where cname=?" , "hahahahha","lushi");
    }
    public static void query(){

    }
}

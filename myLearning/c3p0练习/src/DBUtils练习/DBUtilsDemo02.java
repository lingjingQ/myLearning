package DBUtils练习;

import DBUtils练习.domain.Category;
import c3p0Utils.C3p0Utils02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBUtilsDemo02 {
    public static void main(String[] args) throws SQLException {
        demo08();
    }
    public static void demo01() throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        String sql = "select * from category";
//        Object[] objects = {"jiadian"};

        List<Object[]> list = qr.query(sql,new ArrayListHandler());
        for(Object[] object:list){
            System.out.println(object[0] + "\t" + object[1]);
        }
    }
    public static void demo03() throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        String sql = "select * from category";

        Category c = qr.query(sql,new BeanHandler<Category>(Category.class));
        System.out.println(c);
    }

    public static void demo04() throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        String sql = "select * from category";

        List<Category> c = qr.query(sql,new BeanListHandler<Category>(Category.class));
        for(Category category : c){
            System.out.println(category);
        }
    }
    public static void demo06() throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        String sql = "select * from category";

        List<Map<String, Object>> maps = qr.query(sql,new MapListHandler());
        System.out.println(maps);
    }

    public static void demo08() throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        String sql = "select count(*) from category";

        long count = qr.query(sql,new ScalarHandler<Long>());
        System.out.println(count);
    }
}

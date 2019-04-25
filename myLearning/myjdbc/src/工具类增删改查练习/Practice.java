package 工具类增删改查练习;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practice {
    public static void main(String[] args) {
          insert();
//        delete();
//        update();
//        query();
    }
    public static void insert(){
        // 获取连接
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            int rows = st.executeUpdate("insert into users values ('liujin','18225236'),('liujingtao','18225237'),('liusong','18225248')");
            System.out.println("成功插入" + rows + "行！");
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,st, rs);
        }
    }
    public static void delete(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            int rows = st.executeUpdate("delete from category where cname='food'");
            System.out.println("成功删除" + rows + "行");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,st,rs);
        }
    }
    public static void update(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            int rows = st.executeUpdate("update category set cname = 'lushi' where  cid = 2");
            System.out.println("成功修改" + rows + "行");
        }catch (Exception e){

        }finally {
            JdbcUtils.closeAll(conn,st,rs);
        }
    }
    public static void query(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from category ");
            while(rs.next()){
                System.out.println(rs.getObject("cid") + "\t" + rs.getObject("cname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,st,rs);
        }
    }
}

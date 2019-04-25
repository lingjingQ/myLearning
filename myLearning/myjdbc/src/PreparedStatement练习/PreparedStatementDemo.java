package PreparedStatement练习;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo {
    public static void main(String[] args) {
//        insert();
//        delete();
        update();
        query();
    }
    public static void insert(){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into users values (?,?)";
            pst = conn.prepareStatement(sql);
            pst.setObject(1,"liubin");
            pst.setObject(2,"18225227");
            int rows = pst.executeUpdate();
            System.out.println("成功插入" + rows + "行");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,pst,rs);
        }
    }
    public static void delete(){
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "delete from users where username = ? ";
            pst = conn.prepareStatement(sql);
            pst.setObject(1,"liubin");
            int rows = pst.executeUpdate();
            System.out.println("成功删除" + rows + "行");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,pst,null);
        }
    }
    public static void update(){
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update users set password = ? where username = ?";
            pst = conn.prepareStatement(sql);
            pst.setObject(1,"555500000055");
            pst.setObject(2,"liujingtao");
            int rows = pst.executeUpdate();
            System.out.println("成功修改了" + rows + "行");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,pst,null);
        }
    }
    public static void query(){

    }
}

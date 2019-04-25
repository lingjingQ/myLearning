package SQL注入演示;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlzhuruDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
//            st = conn.createStatement();

            String sql = "select * from users where username= ? and password=?";
            st = conn.prepareStatement(sql);//先确定原本语法结构
            st.setObject(1,username);
            st.setObject(2,password);//用st对象将变量放入sql语句中，这会构造一个不会被sql注入的sql语句
            System.out.println(st.getMetaData());
            rs = st.executeQuery();
            if(rs.next()){
                System.out.println("登录成功！");
            }else {
                System.out.println("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(conn,st,rs);
        }
    }
}

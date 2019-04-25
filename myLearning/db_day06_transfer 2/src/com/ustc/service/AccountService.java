package com.ustc.service;

import com.ustc.dao.AccountDao;
import com.ustc.utils.C3p0Utils02;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    // 只有一个业务，对用户来说
    public void transfer(String fromName, String toName, double money) {
        // 不检查数据对错，直接调用dao的方法。
        AccountDao dao = new AccountDao();
        Connection connection = null;
        try {
            connection = dao.getConnection();
            /**
             * 创建connection本该是dao层的活，如果放在Dao层的话，
             *      要先创建一个Dao对象
             *      调用该对象的方法创建一个连接，
             *      然后在使用dao方法的时候在将connection传回。
             */


            dao.commit(connection);
            dao.fromAccount(connection,"jack",1000);
            System.out.println(1/0);
            dao.toAccount(connection,"Tom",1000);
            connection.commit();
            System.out.println("转账成功");
        }catch (Exception e){
            try {
                System.out.println("转账失败");
                connection.rollback();
                System.out.println("已经回滚");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

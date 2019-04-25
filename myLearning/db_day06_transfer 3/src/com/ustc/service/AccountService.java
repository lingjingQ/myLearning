package com.ustc.service;

import com.ustc.dao.AccountDao;
import com.ustc.utils.C3p0Utils02;
import com.ustc.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    // 只有一个业务，对用户来说
    public void transfer(String fromName, String toName, double money) {
        // 不检查数据对错，直接调用dao的方法。
        AccountDao dao = new AccountDao();
        try {
            ConnectionManager.start();
            dao.fromAccount("jack",1000);
            System.out.println(1/0);
            dao.toAccount("Tom",1000);
            ConnectionManager.commit();
            System.out.println("转账成功");
        }catch (Exception e){
            try {
                System.out.println("转账失败");
                ConnectionManager.rollback();
                System.out.println("已经回滚");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                ConnectionManager.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

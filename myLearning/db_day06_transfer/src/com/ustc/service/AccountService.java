package com.ustc.service;

import com.ustc.dao.AccountDao;

import java.sql.SQLException;

public class AccountService {
    // 只有一个业务，对用户来说
    public void transfer(String fromName, String toName, double money) {
        // 不检查数据对错，直接调用dao的方法。
        AccountDao dao = new AccountDao();
        try {
            dao.fromAccount("jack",1000);
            dao.toAccount("Tom",1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

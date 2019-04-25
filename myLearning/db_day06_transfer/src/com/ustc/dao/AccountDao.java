package com.ustc.dao;

import com.ustc.utils.C3p0Utils02;
import org.apache.commons.dbutils.QueryRunner;

import java.awt.desktop.QuitEvent;
import java.sql.SQLException;

public class AccountDao {

    public void fromAccount(String fromName,double money) throws SQLException {// 使劲抛出异常， 在service成使劲try
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        qr.update("update account set money = money - ? where name = ?", money,fromName);
    }

    public void toAccount(String toName, double money) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        qr.update("update account set money = money - ? where name = ?",money,toName);
    }

}

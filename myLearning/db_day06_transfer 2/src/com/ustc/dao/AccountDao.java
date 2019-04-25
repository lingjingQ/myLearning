package com.ustc.dao;

import com.ustc.utils.C3p0Utils02;
import org.apache.commons.dbutils.QueryRunner;

import java.awt.desktop.QuitEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountDao {
    public Connection getConnection() throws SQLException {
        return C3p0Utils02.getConnection();
    }
    public void commit(Connection connection) throws SQLException {
        connection.commit();
    }
    public void fromAccount(Connection connection, String fromName, double money) throws SQLException {// 使劲抛出异常， 在service成使劲try
        QueryRunner qr = new QueryRunner();
        qr.update(connection,"update account set money = money - ? where name = ?", 1000,"jack");
    }

    public void toAccount(Connection connection,String toName, double money) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        qr.update(connection,"update account set money = money + ? where name = ?",1000,"Tom");
    }

}

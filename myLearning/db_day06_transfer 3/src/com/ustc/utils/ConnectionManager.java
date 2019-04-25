package com.ustc.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接管理类：
 *      提交事务
 *      获取连接
 *      开启事务
 *      回滚事务
 */
public class ConnectionManager {
    // 定义一个ThreadLocal 对象 ，其实就是一个map，保存当前线程的连接
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    // 获取连接
    public static Connection getConnection() throws SQLException {
        Connection connection = tl.get(); // 先从本地变量里取
        if(connection == null){ //如果没有，说明是业务层调用的，第一次调用，那么就要创造一个
            connection = C3p0Utils02.getConnection();
            tl.set(connection);

        }
        return  connection;
    }

    // 开启事务
    public static void start() throws SQLException {
        ConnectionManager.getConnection().setAutoCommit(false);
    }
    // 提交事务
    public static void commit() throws SQLException {
        ConnectionManager.getConnection().commit();
    }
    // 回滚事务
    public static void rollback() throws SQLException {
        ConnectionManager.getConnection().rollback();
    }
    // 关闭连接
    public static void close() throws SQLException {
        ConnectionManager.getConnection().close();
    }
}

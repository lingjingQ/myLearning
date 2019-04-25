package com.ustc.dao;

import com.ustc.domain.Product;
import com.ustc.utils.C3p0Utils02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @date 2019/3/31 9:58
 */
public class ProductDao {

    public void addProduct(Product p) throws SQLException {
        // 插入商品
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        Object[] objects = {p.getName(),p.getPrice(),"1","c002"};
        int rows = qr.update("insert into products(pname,price,flag,category_id) values (?, ?,?,?)",objects);
    }

    public Product findById(int pid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3p0Utils02.getDataSource());
        Product product = qr.query("select * from products where pid = ?",new BeanHandler<Product>(Product.class),pid);
        // Product.class 参数，表示把查询出来的东西封装到这个类中去
        // <Product>
        // 为什么写Product时字段一定要和数据库字段保持一致？就是因为我传递这个类给BeanHandler了，这个类把查询到的记录封装到这个类中，如果不一致，BeanHandler不知道怎么封装
        return product;
    }
}

package com.ustc.service;

import com.ustc.dao.ProductDao;
import com.ustc.domain.Product;

import java.sql.SQLException;

/**
 * @date 2019/3/31 9:54
 */
public class ProductService {

    public void addProduct(Product p) {
        ProductDao productDao = new ProductDao();
        try {
            productDao.addProduct(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product findById(int pid) {
        ProductDao productDao = new ProductDao();
        Product p = null;
        try {
            p = productDao.findById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}

package com.bksoftwarevn.itstudent.view;

import com.bksoftwarevn.itstudent.controller.CategoryController;
import com.bksoftwarevn.itstudent.dao.CategoryDao;
import com.bksoftwarevn.itstudent.dao.ProductDao;
import com.bksoftwarevn.itstudent.dao_impl.CategoryDaoImpl;
import com.bksoftwarevn.itstudent.dao_impl.ProductDaoImpl;
import com.bksoftwarevn.itstudent.model.Category;
import com.bksoftwarevn.itstudent.model.MyConnection;
import com.bksoftwarevn.itstudent.model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        CategoryController categoryController = new CategoryController();
        ProductDao productDao = new ProductDaoImpl();
        try {
            myConnection.connectDB();
            List<Product> list = productDao.search("", null, "2020-05-01", null, -1, -1,-1, -1);
            for (Product p: list) {
                System.out.println(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

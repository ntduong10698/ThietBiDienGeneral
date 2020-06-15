package com.bksoftwarevn.itstudent.view;

import com.bksoftwarevn.itstudent.dao.CategoryDao;
import com.bksoftwarevn.itstudent.dao_impl.CategoryDaoImpl;
import com.bksoftwarevn.itstudent.model.Category;
import com.bksoftwarevn.itstudent.model.MyConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        CategoryDao categoryDao = new CategoryDaoImpl();
        try {
            myConnection.connectDB();
            Category category = new Category();
            category.setName("Iphone12");
            category.setDeleted(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

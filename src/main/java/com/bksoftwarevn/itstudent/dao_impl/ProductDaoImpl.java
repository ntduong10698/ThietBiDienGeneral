package com.bksoftwarevn.itstudent.dao_impl;

import com.bksoftwarevn.itstudent.dao.CategoryDao;
import com.bksoftwarevn.itstudent.dao.ProductDao;
import com.bksoftwarevn.itstudent.model.MyConnection;
import com.bksoftwarevn.itstudent.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    MyConnection myConnection = new MyConnection();

    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Product> sortByCreateDate() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product where deleted = false order by create_date DESC"; //DESC: giảm dần ASC: tân
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first()) {
            do {
                Product product = getObject(resultSet);
                if(product != null) products.add(product);
            } while(resultSet.next());
        }
    }

    @Override
    public List<Product> findByCategory(int idCategory) throws Exception {
//        List<Product> products = new ArrayList<>();
//        if(categoryDao.findById(idCategory) == null) {
//            return products;
//        }
//        String sql = "select * from product where deleted = false and category_id = ?";
//        PreparedStatement preparedStatement = myConnection.prepare(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if(resultSet.first()) {
//            do {
//                Product product = getObject(resultSet);
//                if(product != null) products.add(product);
//            } while(resultSet.next());
//        }
//        return products;
        List<Product> products = new ArrayList<>();
        String sql = "select p.* from product as p, category as c " +
                "where c.deleted = false and c.id = ? and p.category_id = category.id";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, idCategory);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first()) {
            do {
                Product product = getObject(resultSet);
                if(product != null) products.add(product);
            } while(resultSet.next());
        }
        return products;
    }

    @Override
    public Product getObject(ResultSet resultSet) throws SQLException {
        Product product = null;
        product = new Product(resultSet.getInt("id"), resultSet.getString("name"),
        resultSet.getDouble("price"), resultSet.getDate("create_date"),
        resultSet.getBoolean("deleted"), resultSet.getString("image"),
                resultSet.getString("introduction"),
                resultSet.getString("specification"),
        resultSet.getBoolean("sold_out"), resultSet.getInt("guarantee"),
        resultSet.getInt("category_id"), resultSet.getInt("bouth"),
        resultSet.getInt(" promotiton"));
        return product;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        return null;
    }

    @Override
    public Product findById(int id) throws SQLException {
        return null;
    }

    @Override
    public Product insert(Product product) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Product category) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}

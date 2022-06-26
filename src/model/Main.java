package model;

import db.ProductDB;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        ProductDB pdb = new ProductDB();
        ResultSet resultSet = pdb.getAll();
        List<Products> products = new ArrayList<>();
        while(resultSet.next()){
            products.add(new Products(
                    resultSet.getInt("id"),
                    resultSet.getString("products"),
                    resultSet.getDouble("quantity"),
                    resultSet.getInt("unit"),
                    resultSet.getDouble("price_per_unit")
            ));
        }
        System.out.println(products);
    }
}

package db;

import model.Products;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB extends TableDB {
    public ProductDB() throws IOException, ClassNotFoundException {}

    public Products get(int id) throws SQLException {
        tryExec("SELECT * FROM products WHERE id =" + id);
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        return new Products(
                resultSet.getInt("id"),
                resultSet.getString("products"),
                resultSet.getDouble("quantity"),
                resultSet.getInt("unit"),
                resultSet.getDouble("price_per_unit")
        );
    }

    public List<Products> getAll() throws SQLException {
        tryExec("SELECT * FROM products");
        ResultSet resultSet = statement.getResultSet();
        List<Products> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(new Products(
                    resultSet.getInt("id"),
                    resultSet.getString("products"),
                    resultSet.getDouble("quantity"),
                    resultSet.getInt("unit"),
                    resultSet.getDouble("price_per_unit")
            ));
        }
        return products;
    }

    public double getTotalPrice(int id) throws SQLException {
        tryExec("SELECT (quantity*price_per_unit) as total FROM products WHERE id =" + id);
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        return resultSet.getDouble("total");
    }

    public void updateProductName(int id, String products) throws SQLException {
        tryExec("UPDATE products SET products = '" + products + "' WHERE id =" + id);
    }

    public void updateQuantity(int id, double quantity) throws SQLException {
        tryExec("UPDATE products SET quantity = '" + quantity + "' WHERE id =" + id);
    }

    public void updatePrice(int id, double price) throws SQLException {
        tryExec("UPDATE products SET price_per_unit = '" + price + "' WHERE id =" + id);
    }

    public void updateUnit(int pid, int uid) throws SQLException {
        tryExec("UPDATE products SET unit = '" + uid + "' WHERE id =" + pid);
    }

    public void deleteProduct(int id) throws SQLException {
        tryExec("DELETE FROM products WHERE id = " + id);
    }

    public void insert(Products products) throws SQLException {
        tryExec("INSERT INTO products (products, price_per_unit, unit, quantity) " +
                              "VALUES ('" + products.getProducts() + "', " + products.getPricePerUnit() +
                              ", "+products.getUnit()+", "+products.getQuantity()+");");
    }
}

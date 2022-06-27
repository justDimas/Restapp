package db;

import model.Products;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB extends TableDB {
    public ProductDB() throws IOException, SQLException {
    }

    public Products get(int id) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM products WHERE id =" + id);
        statement.execute();
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
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM products");
        statement.execute();
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
        PreparedStatement statement = getConnection().prepareStatement("SELECT (quantity*price_per_unit) as total " +
                "FROM products WHERE id =" + id);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        return resultSet.getDouble("total");
    }

    public void updateProductName(int id, String products) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("UPDATE products " +
                "SET products = '" + products +
                "' WHERE id =" + id);
        statement.execute();
    }

    public void updateQuantity(int id, double quantity) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("UPDATE products " +
                "SET quantity = '" + quantity +
                "' WHERE id =" + id);
        statement.execute();
    }

    public void updatePrice(int id, double price) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("UPDATE products " +
                "SET price_per_unit = '" + price +
                "' WHERE id =" + id);
        statement.execute();
    }

    public void updateUnit(int pid, int uid) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT unit FROM unit_of_measurement");
        statement.execute();
        ResultSet units = statement.getResultSet();

        while (units.next()) {
            if (units.getInt("unit") == uid) {
                statement = getConnection().prepareStatement("UPDATE products " +
                        "SET unit = '" + uid +
                        "' WHERE id =" + pid);
                statement.execute();
                return;
            }
        }
    }
}

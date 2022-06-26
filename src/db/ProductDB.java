package db;

import model.Products;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDB extends TableDB{
    Products products;
    public ProductDB() throws IOException, SQLException {

    }

    public ResultSet getAll() throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select * from products");
        statement.execute();
        return statement.getResultSet();
    }
}

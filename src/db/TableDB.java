package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TableDB {
    private Config cfg;
    private Connection connection;

    public TableDB() throws IOException, SQLException {
        cfg = new Config();
        connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword());
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }
}

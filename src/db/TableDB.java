package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableDB {
    private Config cfg;
    protected Connection connection;
    protected PreparedStatement statement;

    public TableDB() throws IOException, ClassNotFoundException {
        cfg = new Config();
    }

    protected void tryExec(String sqlExpr) throws SQLException {
        connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword());
        statement = connection.prepareStatement(sqlExpr);
        statement.execute();
        connection.close();
    }
}

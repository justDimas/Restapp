package db;

import model.Unit;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitDB extends TableDB{
    public UnitDB() throws IOException, ClassNotFoundException { }

    public Unit get(int id) throws SQLException {
        tryExec("SELECT * FROM unit_of_measurement WHERE id =" + id);
        ResultSet resultSet = statement.getResultSet();
        resultSet.next();
        return new Unit(
                resultSet.getInt("id"),
                resultSet.getString("unit")
        );
    }

    public List<Unit> getAll() throws SQLException {
        tryExec("SELECT * FROM unit_of_measurement");
        ResultSet resultSet = statement.getResultSet();
        List<Unit> unit = new ArrayList<>();
        while (resultSet.next()) {
            unit.add(new Unit(
                    resultSet.getInt("id"),
                    resultSet.getString("unit")
            ));
        }
        return unit;
    }

    public void updateUnit(int uid, String unit) throws SQLException {
        tryExec("UPDATE unit_of_measurement SET unit = '" + unit + "' WHERE id =" + uid);
    }

    public void deleteUnit(int id) throws SQLException {
        tryExec("DELETE FROM unit_of_measurement WHERE id = " + id);
    }

    public void insert(String unit) throws SQLException {
        tryExec("INSERT INTO unit_of_measurement (unit) VALUES ('" + unit + "');");
    }
}

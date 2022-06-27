package model;

import db.ProductDB;
import db.UnitDB;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ProductDB pdb = new ProductDB();
        UnitDB udb = new UnitDB();

        udb.close();
        pdb.close();
    }
}

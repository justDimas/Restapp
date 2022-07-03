package model;

import db.ProductDB;
import db.UnitDB;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductDB pdb = new ProductDB();
        UnitDB udb = new UnitDB();
/*
        udb.insert("kg");
        udb.insert("litr");
        udb.insert("piece");
        udb.insert("metr3");
        System.out.println( udb.get(33) );
        System.out.println( udb.getAll() );
        udb.updateUnit(34, "litre");
        System.out.println(udb.getAll());
        udb.deleteUnit(36);
        System.out.println(udb.getAll());
*/
/*
        pdb.insert(new Products("Salad", 15.5, 33, 7.89));
        pdb.insert(new Products("Chips", 17.8, 33, 26.6));
        pdb.insert(new Products("CocaCola", 10.5, 34, 1.5));
        pdb.insert(new Products("Co2 baloon", 97.9, 34, 0.9 ));
        pdb.insert(new Products("Paper package M", 180, 35, 0.08));
        pdb.insert(new Products("Paper package L", 140, 35, 0.09));
        pdb.insert(new Products("Paper package S", 210, 35, 0.07));
        pdb.insert(new Products("Paper package with handles", 80, 35, 0.12));
        System.out.println( pdb.get(6) );
        System.out.println( pdb.getAll() );
        pdb.updateProductName(7, "Coca Cola");
        pdb.deleteProduct(9);
        System.out.println(pdb.getTotalPrice(5));
        pdb.updateUnit(8, 33);
        pdb.updatePrice(5, 7.72);
        pdb.updateQuantity(5, 17.8);
        System.out.println( pdb.getAll());
        pdb.updateUnit(8, 34);
*/

    }
}

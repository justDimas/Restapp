package model;

public class Unit {
    private int id;

    private String  unit;
    public Unit(int id, String unit) {
        this.id = id;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

}

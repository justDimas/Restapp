package model;

public class Products {
    private int id;
    private String products;
    private double quantity;
    private int unit;
    private double pricePerUnit;

    public Products(int id, String products, double quantity, int unit, double pricePerUnit) {
        this.id = id;
        this.products = products;
        this.quantity = quantity;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
    }

    public int getId() {
        return id;
    }

    public String getProducts() {
        return products;
    }

    public double getQuantity() {
        return quantity;
    }

    public int getUnit() {
        return unit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", products='" + products + '\'' +
                ", quantity=" + quantity +
                ", unit=" + unit +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}

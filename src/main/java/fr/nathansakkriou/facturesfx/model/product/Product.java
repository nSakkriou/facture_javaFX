package fr.nathansakkriou.facturesfx.model.product;

public class Product {
    private String description;
    private double unitPrice;

    public Product(String description, double unitPrice) {
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}


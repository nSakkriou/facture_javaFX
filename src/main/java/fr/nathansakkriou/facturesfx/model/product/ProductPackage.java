package fr.nathansakkriou.facturesfx.model.product;

public class ProductPackage {

    private Product product;
    private final double TVA = 20;
    private int quantity;


    public ProductPackage(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double totalHT(){
        return this.product.getUnitPrice() * this.quantity;
    }

    public double totalTTC(){
        return (this.product.getUnitPrice() +((this.product.getUnitPrice() * this.TVA) / 100)) * this.quantity;
    }

    public double totalTVA(){
        return ((this.product.getUnitPrice() * this.TVA) / 100) * this.quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTVA() {
        return TVA;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

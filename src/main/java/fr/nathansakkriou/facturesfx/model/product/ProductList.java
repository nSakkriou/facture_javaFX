package fr.nathansakkriou.facturesfx.model.product;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private List<ProductPackage> productPackageList;
    private String show;

    public ProductList(List<ProductPackage> productPackageList) {
        this.productPackageList = productPackageList;
    }

    public int addProductPackage(ProductPackage pp){
        int id = this.productPackageList.size();
        this.productPackageList.add(pp);
        return id;
    }

    public ProductPackage findProductPackageWithId(int id){
        try{
            return this.productPackageList.get(id);
        }
        catch (Exception e){
            return null;
        }
    }

    public double totalHT(){
        double total = 0;
        for(ProductPackage productPackage : this.productPackageList){
            total += productPackage.totalHT();
        }

        return total;
    }
    public double totalTVA(){
        double total = 0;
        for(ProductPackage productPackage : this.productPackageList){
            total += productPackage.totalTVA();
        }

        return total;
    }

    public double totalTTC(){
        double total = 0;
        for(ProductPackage productPackage : this.productPackageList){
            total += productPackage.totalTTC();
        }

        return total;
    }

    public List<ProductPackage> getProductPackageList() {
        return productPackageList;
    }

    public void setProductPackageList(List<ProductPackage> productPackageList) {
        this.productPackageList = productPackageList;
    }

    public String toString(){
        this.show = "";

        this.productPackageList.forEach(p -> {
            String produitStr = p.getProduct().getDescription() + " - " + p.getProduct().getUnitPrice() + " - " + p.getTVA() + " - " + p.getQuantity() + " - " + p.totalHT() + " - " + p.totalTTC();
            this.show += produitStr + "\n";
        });

        return this.show;
    }
}

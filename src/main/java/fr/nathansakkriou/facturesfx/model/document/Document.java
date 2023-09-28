package fr.nathansakkriou.facturesfx.model.document;

import fr.nathansakkriou.facturesfx.model.entity.Entity;
import fr.nathansakkriou.facturesfx.model.product.ProductList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Document {

    private String date;
    private Entity seller;
    private Entity buyer;
    private ProductList productList;
    private String documentName;
    private DocumentType documentType;

    private long idDocument;
    public Document(Entity seller, Entity buyer, ProductList productList, DocumentType documentType) {
        this.seller = seller;
        this.buyer = buyer;
        this.productList = productList;
        this.documentType = documentType;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        this.date = dtf.format(now);
    }

    public long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(long idDocument) {
        this.idDocument = idDocument;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Entity getSeller() {
        return seller;
    }

    public void setSeller(Entity seller) {
        this.seller = seller;
    }

    public Entity getBuyer() {
        return buyer;
    }

    public void setBuyer(Entity buyer) {
        this.buyer = buyer;
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public void save2File(){
        String text =
                "" + this.idDocument + " - " + this.date + "\n" +
                "Vendeur --------" + "\n" +
                this.seller.toString() + "\n" +
                "Client ----------" + "\n" +
                this.buyer.toString() + "\n" +
                "Produit --------- " + "\n" +
                this. productList.toString();

        System.out.println(text);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.documentName));
            writer.write(text);

            writer.close();
        }
        catch (IOException e) {
            System.out.println("Erreur ecriture");
            throw new RuntimeException(e);
        }
    }
}

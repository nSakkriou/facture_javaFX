package fr.nathansakkriou.facturesfx.model.document;

import fr.nathansakkriou.facturesfx.model.entity.Entity;
import fr.nathansakkriou.facturesfx.model.product.ProductList;

public class Facture extends Document{

    static long factureID = 0;

    public Facture(Entity seller, Entity buyer, ProductList productList) {
        super(seller, buyer, productList, DocumentType.FACTURE);

        this.setIdDocument(Facture.factureID);
        Facture.factureID += 1;

        setDocumentName("facture-" + this.getIdDocument() + "-"+ this.getDate() + "-" + this.getBuyer().getName());
    }
}

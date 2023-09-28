package fr.nathansakkriou.facturesfx.model.document;

import fr.nathansakkriou.facturesfx.model.entity.Entity;
import fr.nathansakkriou.facturesfx.model.product.ProductList;

public class Devis extends Document{
    static long devisID = 0;

    public Devis(Entity seller, Entity buyer, ProductList productList) {
        super(seller, buyer, productList, DocumentType.FACTURE);

        this.setIdDocument(Devis.devisID);
        Devis.devisID += 1;

        setDocumentName("devis-" + "-" + this.getIdDocument() + "-" + this.getDate() + "-" + this.getBuyer().getName());
    }
}

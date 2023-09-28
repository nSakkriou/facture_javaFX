package fr.nathansakkriou.facturesfx.controller;

import fr.nathansakkriou.facturesfx.model.document.Devis;
import fr.nathansakkriou.facturesfx.model.document.Document;
import fr.nathansakkriou.facturesfx.model.document.Facture;
import fr.nathansakkriou.facturesfx.model.entity.Compagny;
import fr.nathansakkriou.facturesfx.model.entity.CompagnyBuilder;
import fr.nathansakkriou.facturesfx.model.product.Product;
import fr.nathansakkriou.facturesfx.model.product.ProductList;
import fr.nathansakkriou.facturesfx.model.product.ProductPackage;
import fr.nathansakkriou.facturesfx.view.CreateFactureDevisView;
import fr.nathansakkriou.facturesfx.view.ViewUtils;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.FlowPane;

import java.util.List;
import java.util.Optional;

public class CreateFactureDevisController {

    private CreateFactureDevisView view;
    public CreateFactureDevisController(CreateFactureDevisView view){
        this.view = view;
    }

    public void addProduit(){
        TextInputDialog textInputDialogName = new TextInputDialog();
        textInputDialogName.setTitle("Produit");
        textInputDialogName.setHeaderText("Entrez le nom du produit");
        textInputDialogName.setContentText("nom produit");

        TextInputDialog textInputDialogPU = new TextInputDialog();
        textInputDialogPU.setTitle("Produit");
        textInputDialogPU.setHeaderText("Entrez le PU du produit");
        textInputDialogPU.setContentText("PU produit");

        TextInputDialog textInputDialogQuantity = new TextInputDialog();
        textInputDialogQuantity.setTitle("Produit");
        textInputDialogQuantity.setHeaderText("Entrez la quantité du produit");
        textInputDialogQuantity.setContentText("Quantité produit");

        Optional<String> result = textInputDialogName.showAndWait();
        result.ifPresent(n -> {
            this.view.name = n;
        });

        Optional<String> resultPU = textInputDialogPU.showAndWait();
        resultPU.ifPresent(n -> {
            this.view.price = Double.parseDouble(n);
        });

        Optional<String> resultQ = textInputDialogQuantity.showAndWait();
        resultQ.ifPresent(n -> {
            this.view.quantity = Integer.parseInt(n);
        });


        Product produit = new Product(this.view.name, this.view.price);
        ProductPackage productPackage = new ProductPackage(produit, this.view.quantity);

        this.view.productPackageList.add(productPackage);

        FlowPane pane = new FlowPane();
        pane.getChildren().add(ViewUtils.newLabel(produit.getDescription()));
        pane.getChildren().add(ViewUtils.newLabel(produit.getUnitPrice() + "€"));
        pane.getChildren().add(ViewUtils.newLabel(productPackage.getQuantity()+ ""));

        this.view.vbox.getChildren().add(pane);
    }

    public Compagny makeBuyerCompagny(List<TextField> textFieldList){
        Compagny c = new CompagnyBuilder()
                .name(textFieldList.get(0).getText())
                .address(textFieldList.get(1).getText())
                .postalCode(textFieldList.get(2).getText())
                .city(textFieldList.get(3).getText())
                .phoneNumber(textFieldList.get(4).getText())
                .siret(textFieldList.get(5).getText())
                .build();
        return c;
    }

    public void saveDocument(){
        Compagny buyer = this.makeBuyerCompagny(this.view.textFieldList);
        ProductList productList = new ProductList(this.view.productPackageList);

        Document doc;
        if(this.view.checkBoxList.get(0).isSelected()){
            doc = new Facture(this.view.compagny, buyer, productList);
        }
        else{
            doc = new Devis(this.view.compagny, buyer, productList);
        }

        doc.save2File();
    }
}

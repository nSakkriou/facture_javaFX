package fr.nathansakkriou.facturesfx.view;

import fr.nathansakkriou.facturesfx.controller.CreateFactureDevisController;
import fr.nathansakkriou.facturesfx.controller.HomeController;
import fr.nathansakkriou.facturesfx.model.document.Devis;
import fr.nathansakkriou.facturesfx.model.document.Document;
import fr.nathansakkriou.facturesfx.model.document.Facture;
import fr.nathansakkriou.facturesfx.model.entity.Compagny;
import fr.nathansakkriou.facturesfx.model.entity.CompagnyBuilder;
import fr.nathansakkriou.facturesfx.model.entity.Entity;
import fr.nathansakkriou.facturesfx.model.product.Product;
import fr.nathansakkriou.facturesfx.model.product.ProductList;
import fr.nathansakkriou.facturesfx.model.product.ProductPackage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class CreateFactureDevisView implements View{

    private CreateFactureDevisController createFactureDevisController;
    public Compagny compagny;
    private Stage stage;
    public List<ProductPackage> productPackageList;

    public String name;
    public double price;
    public int quantity;
    public VBox vbox;
    public List<TextField> textFieldList;

    public List<CheckBox> checkBoxList;

    public CreateFactureDevisView(Stage stage, Compagny compagny){
        this.compagny = compagny;
        this.stage = stage;
        this.createFactureDevisController = new CreateFactureDevisController(this);
        this.productPackageList = new ArrayList<>();
        this.textFieldList = new ArrayList<>();
    }

    public Scene generate(){
        this.vbox = new VBox();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(this.vbox);

        Scene scene = new Scene(borderPane);

        CheckBox devisCheckBox = ViewUtils.newCheckBox("Devis");
        CheckBox factureCheckBox = ViewUtils.newCheckBox("Facture");

        this.checkBoxList = new ArrayList<>();
        this.checkBoxList.add(factureCheckBox);
        this.checkBoxList.add(devisCheckBox);

        vbox.getChildren().add(devisCheckBox);
        vbox.getChildren().add(factureCheckBox);

        vbox.getChildren().add(ViewUtils.newLabel("Nom du client"));

        List<String> inputCompagny = Arrays.asList(
                "Nom de l'entreprise",
                "Adresse",
                "Code postale",
                "Ville",
                "N° Téléphone",
                "N° Siret"
        );

        for(String input : inputCompagny){
            Label l = ViewUtils.newLabel(input);
            TextField t = ViewUtils.newTextField();

            FlowPane pane = new FlowPane();
            pane.getChildren().add(l);
            pane.getChildren().add(t);

            this.textFieldList.add(t);

            vbox.getChildren().add(pane);
        }

        vbox.getChildren().add(ViewUtils.newLabel("Produit"));

        Button btnProduit = ViewUtils.newButton("Nouveau produit");
        btnProduit.setOnAction(event -> {
           this.createFactureDevisController.addProduit();

        });
        vbox.getChildren().add(btnProduit);

        Button btnValide = ViewUtils.newButton("Valide");
        btnValide.setOnAction(event -> {
            this.createFactureDevisController.saveDocument();

        });
        vbox.getChildren().add(btnValide);



        return scene;
    }
}

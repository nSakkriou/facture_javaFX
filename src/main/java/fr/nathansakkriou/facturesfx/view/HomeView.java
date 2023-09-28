package fr.nathansakkriou.facturesfx.view;

import fr.nathansakkriou.facturesfx.controller.CreateFactureDevisController;
import fr.nathansakkriou.facturesfx.controller.HomeController;
import fr.nathansakkriou.facturesfx.model.entity.Compagny;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeView implements View{
    private List<TextField> textFieldList;
    private HomeController homeController;
    private Compagny compagny;
    private Stage stage;

    public HomeView(Stage stage){
        this.textFieldList = new ArrayList<>();
        this.homeController = new HomeController();
        this.stage = stage;
    }

    public Scene generate(){

        VBox vbox = new VBox();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vbox);

        Scene scene = new Scene(borderPane);

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

        Button btn = ViewUtils.newButton("Valider");
        btn.setOnAction(event -> {
            this.compagny = homeController.validCreateForm(this.textFieldList);

            CreateFactureDevisView view = new CreateFactureDevisView(this.stage, this.compagny);
            stage.setScene(view.generate());
        });
        vbox.getChildren().add(btn);

        return scene;
    }

    public Compagny getCompagny() {
        return compagny;
    }
}

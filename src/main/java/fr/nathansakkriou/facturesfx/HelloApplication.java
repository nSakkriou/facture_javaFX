package fr.nathansakkriou.facturesfx;

import fr.nathansakkriou.facturesfx.view.HomeView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Facture APP");
        stage.setHeight(800);
        stage.setWidth(800);
        HomeView homeView = new HomeView(stage);
        stage.setScene(homeView.generate());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
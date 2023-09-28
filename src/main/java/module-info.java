module fr.nathansakkriou.facturesfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.nathansakkriou.facturesfx to javafx.fxml;
    exports fr.nathansakkriou.facturesfx;
    exports fr.nathansakkriou.facturesfx.controller;
    opens fr.nathansakkriou.facturesfx.controller to javafx.fxml;
}
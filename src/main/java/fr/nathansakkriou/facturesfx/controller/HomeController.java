package fr.nathansakkriou.facturesfx.controller;

import fr.nathansakkriou.facturesfx.model.entity.Compagny;
import fr.nathansakkriou.facturesfx.model.entity.CompagnyBuilder;
import javafx.scene.control.TextField;

import java.util.List;

public class HomeController {

    public Compagny validCreateForm(List<TextField> textFieldList) {
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
}
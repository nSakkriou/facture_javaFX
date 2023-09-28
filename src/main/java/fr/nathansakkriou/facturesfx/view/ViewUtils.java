package fr.nathansakkriou.facturesfx.view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewUtils {

    public static Label newLabel(String text){
        return new Label(text);
    }

    public static TextField newTextField(){
        return new TextField();
    }

    public static Button newButton(String text){
        return new Button(text);
    }
    public static CheckBox newCheckBox(String text) {return new CheckBox(text);}
}

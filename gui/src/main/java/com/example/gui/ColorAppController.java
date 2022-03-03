package com.example.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ColorAppController {
    @FXML
    private Label welcomeText;

    @FXML
    private HBox hb = new HBox();

    @FXML
    private Label redLabel;

    @FXML
    private Slider redSlider = new Slider(0, 255, 213);

    @FXML
    private TextField redInput = new TextField();

    @FXML
    private void initialize() {
        redLabel.setText("Red");
        redInput.setText(Integer.toString((int) redSlider.getValue()));

        redSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> redInput.setText(Integer.toString((int) redSlider.getValue())));
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSliderChanged() {
        int slidervalue = (int) redSlider.getValue();
        redInput.setText(Integer.toString(slidervalue));
    }


}
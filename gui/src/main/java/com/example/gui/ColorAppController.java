package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import todd.color.model.Color;

public class ColorAppController {

    private Color currentColor;

    @FXML
    private Label redLabel;
    @FXML
    private Label greenLabel;
    @FXML
    private Label blueLabel;
    @FXML
    private Label hexLabel;

    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;

    @FXML
    private TextField redInput;
    @FXML
    private TextField greenInput;
    @FXML
    private TextField blueInput;
    @FXML
    private TextField hexInput;

    @FXML
    private Rectangle colorShape;

    @FXML
    private void initialize() {
        // Labels
        redLabel.setText("Red");
        greenLabel.setText("Green");
        blueLabel.setText("Blue");
        hexLabel.setText("Hex");

        // Input
        redInput.setText(Integer.toString((int) redSlider.getValue()));
        greenInput.setText(Integer.toString((int) greenSlider.getValue()));
        blueInput.setText(Integer.toString((int) blueSlider.getValue()));
        hexInput.setText("#TODO");

        // RED slider/input binding
        redSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> redInput.setText(
                        Integer.toString((int) redSlider.getValue())));
        redInput.textProperty().addListener(
                (observableText, oldText, newText) -> redSlider.setValue(
                        Double.parseDouble(redInput.textProperty().getValue())));

        // GREEN slider/input binding
        greenSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> greenInput.setText(
                        Integer.toString((int) greenSlider.getValue())));
        greenInput.textProperty().addListener(
                (observableText, oldText, newText) -> greenSlider.setValue(
                        Double.parseDouble(greenInput.textProperty().getValue())));

        // BLUE slider/input binding
        blueSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> blueInput.setText(
                        Integer.toString((int) blueSlider.getValue())));
        blueInput.textProperty().addListener(
                (observableText, oldText, newText) -> blueSlider.setValue(
                        (newText.equals(""))
                            ? 0
                            : Double.parseDouble(blueInput.textProperty().getValue())));

        // HEX input binding TODO with library
//        hexInput.textProperty().addListener(
//
//        )

    }

    // TODO : if no text in input when focus is out, set to 0
}
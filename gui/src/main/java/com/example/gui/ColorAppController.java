package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class ColorAppController {

    @FXML
    private Label redLabel;
    @FXML
    private Label greenLabel;
    @FXML
    private Label blueLabel;
    @FXML
    private Label hexLabel;

    @FXML
    private Slider redSlider = new Slider(0, 255, 213);

    @FXML
    private Slider greenSlider = new Slider(0, 255, 141);

    @FXML
    private Slider blueSlider = new Slider(0, 255, 53);

    @FXML
    private TextField redInput = new TextField();

    @FXML
    private TextField greenInput = new TextField();

    @FXML
    private TextField blueInput = new TextField();

    @FXML
    private TextField hexInput = new TextField();

    // TODO color square
    @FXML
    private Rectangle colorShape = new Rectangle();

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
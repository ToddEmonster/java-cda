package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import todd.color.model.Color;

public class ColorAppController {

    private Color currentColor;
    private int red;
    private int green;
    private int blue;

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

        // Init values
        currentColor = new Color("#D58D35");
        red = currentColor.getRed();
        green = currentColor.getGreen();
        blue = currentColor.getBlue();

        redInput.setText(Integer.toString(red));
        greenInput.setText(Integer.toString(green));
        blueInput.setText(Integer.toString(blue));
        hexInput.setText(currentColor.getHexValue());

        redSlider.setValue(red);
        greenSlider.setValue(green);
        blueSlider.setValue(blue);

        // Alternatively :
        // colorShape.setFill(javafx.scene.paint.Color.web(currentColor.getHexValue());
        colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));

        // TODO : if no text in input when focus is out, set to 0

        // RED slider/input binding
        redSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    red = (int) redSlider.getValue();
                    currentColor.setRed(red);
                    redInput.setText(Integer.toString(red));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                    hexInput.setText(currentColor.getHexValue());
                });
        redInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    red = Integer.parseInt(redInput.textProperty().getValue());
                    currentColor.setRed(red);
                    redSlider.setValue(red);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                    hexInput.setText(currentColor.getHexValue());
                });

        // GREEN slider/input binding
        greenSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    green = (int) greenSlider.getValue();
                    currentColor.setGreen(green);
                    greenInput.setText(Integer.toString(green));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                    hexInput.setText(currentColor.getHexValue());
                });
        greenInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    green = Integer.parseInt(greenInput.textProperty().getValue());
                    currentColor.setGreen(green);
                    greenSlider.setValue(green);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                    hexInput.setText(currentColor.getHexValue());
                });

        // BLUE slider/input binding
        blueSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    blue = (int) blueSlider.getValue();
                    currentColor.setBlue(blue);
                    blueInput.setText(Integer.toString(blue));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                    hexInput.setText(currentColor.getHexValue());
                });
        blueInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    blue = Integer.parseInt(blueInput.textProperty().getValue());
                    currentColor.setBlue(blue);
                    blueSlider.setValue(blue);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                    hexInput.setText(currentColor.getHexValue());
                });

        // HEX input binding
        hexInput.textProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    currentColor.setHexValue(hexInput.textProperty().getValue());
                    redInput.setText(String.valueOf(currentColor.getRed()));
                    greenInput.setText(String.valueOf(currentColor.getGreen()));
                    blueInput.setText(String.valueOf(currentColor.getBlue()));
                    colorShape.setFill(javafx.scene.paint.Color.web(hexInput.textProperty().getValue()));
                });

        // TODO : try catch pour prévoir les cas des valeurs incorrectes
    }


}
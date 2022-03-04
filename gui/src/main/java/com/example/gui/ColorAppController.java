package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import todd.color.model.Color;

enum RGBColor { RED, GREEN, BLUE }

public class ColorAppController {

    private Color currentColor;

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
        int initRed = currentColor.getRed();
        int initGreen = currentColor.getGreen();
        int initBlue = currentColor.getBlue();

        redInput.setText(Integer.toString(initRed));
        greenInput.setText(Integer.toString(initGreen));
        blueInput.setText(Integer.toString(initBlue));
        hexInput.setText(currentColor.getHexValue());

        redSlider.setValue(initRed);
        greenSlider.setValue(initGreen);
        blueSlider.setValue(initBlue);

        colorShape.setFill(javafx.scene.paint.Color.web(currentColor.getHexValue()));

        // TODO : if no text in input when focus is out, set to 0

        // RED slider/input binding
        redSliderUpdate();
        redInputUpdate();

        // GREEN slider/input binding
        greenSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    int green = (int) greenSlider.getValue();
                    currentColor.setGreen(green);
                    greenInput.setText(Integer.toString(green));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(
                            currentColor.getRed(),
                            green,
                            currentColor.getBlue()));
                    hexInput.setText(currentColor.getHexValue());
                });
        greenInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    int green = Integer.parseInt(greenInput.textProperty().getValue());
                    currentColor.setGreen(green);
                    greenSlider.setValue(green);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(
                            currentColor.getRed(),
                            green,
                            currentColor.getBlue()));
                    hexInput.setText(currentColor.getHexValue());
                });

        // BLUE slider/input binding
        blueSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    int blue = (int) blueSlider.getValue();
                    currentColor.setBlue(blue);
                    blueInput.setText(Integer.toString(blue));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(
                            currentColor.getRed(),
                            currentColor.getGreen(),
                            blue));
                    hexInput.setText(currentColor.getHexValue());
                });
        blueInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    int blue = Integer.parseInt(blueInput.textProperty().getValue());
                    currentColor.setBlue(blue);
                    blueSlider.setValue(blue);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(
                            currentColor.getRed(),
                            currentColor.getGreen(),
                            blue));
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

    private void redSliderUpdate() {
        redSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    int red = (int) redSlider.getValue();
                    currentColor.setRed(red);
                    redInput.setText(Integer.toString(red));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(
                            red,
                            currentColor.getGreen(),
                            currentColor.getBlue()));
                    hexInput.setText(currentColor.getHexValue());
                });
    }

    private void redInputUpdate() {
        redInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    int red = Integer.parseInt(redInput.textProperty().getValue());
                    currentColor.setRed(red);
                    redSlider.setValue(red);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(
                            red,
                            currentColor.getGreen(),
                            currentColor.getBlue()));
                    hexInput.setText(currentColor.getHexValue());
                });
    }
}
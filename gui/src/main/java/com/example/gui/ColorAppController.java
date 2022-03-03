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
        // Styling
        redInput.setPrefWidth(40);
        greenInput.setPrefWidth(40);
        blueInput.setPrefWidth(40);

        redSlider.setPrefWidth(200);
        greenSlider.setPrefWidth(200);
        blueSlider.setPrefWidth(200);

        redLabel.setText("Red");
        greenLabel.setText("Green");
        blueLabel.setText("Blue");
        hexLabel.setText("Hex");

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
                });
        redInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    red = Integer.parseInt(redInput.textProperty().getValue());
                    currentColor.setRed(red);
                    redSlider.setValue(red);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                });

        // GREEN slider/input binding
        greenSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    green = (int) greenSlider.getValue();
                    currentColor.setRed(green);
                    greenInput.setText(Integer.toString(green));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                });
        greenInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    green = Integer.parseInt(greenInput.textProperty().getValue());
                    currentColor.setRed(green);
                    greenSlider.setValue(green);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                });

        // BLUE slider/input binding
        blueSlider.valueProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    blue = (int) blueSlider.getValue();
                    currentColor.setRed(blue);
                    blueInput.setText(Integer.toString(blue));
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
                });
        blueInput.textProperty().addListener(
                (observableText, oldText, newText) -> {
                    blue = Integer.parseInt(blueInput.textProperty().getValue());
                    currentColor.setRed(blue);
                    blueSlider.setValue(blue);
                    colorShape.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
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

    }


}
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
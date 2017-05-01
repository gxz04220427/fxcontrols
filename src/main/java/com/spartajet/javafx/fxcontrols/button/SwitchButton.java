package com.spartajet.javafx.fxcontrols.button;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


/**
 * The type Switch button.
 */
public class SwitchButton extends HBox {
    /**
     * The Label.
     */
    private final Label label = new Label();
    /**
     * The Button.
     */
    private final Button button = new Button();

    /**
     * The Switched on.
     */
    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(false);

    /**
     * Switch on property simple boolean property.
     *
     * @return the simple boolean property
     */
    public SimpleBooleanProperty switchOnProperty() {
        return switchedOn;
    }

    /**
     * Init.
     */
    private void init() {

        label.setText("D");

        getChildren().addAll(label, button);
        button.setOnAction((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        label.setOnMouseClicked((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        setStyle();
        bindProperties();
    }

    /**
     * Sets style.
     */
    private void setStyle() {
        //Default Width
        setWidth(80);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-text-fill: #ffffff");
        label.setFont(new Font("Arial Bold", 13));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #17bdfd; -fx-text-fill:#ffffff; -fx-background-radius: 4.0");
    }

    /**
     * Bind properties.
     */
    private void bindProperties() {
        label.prefWidthProperty().bind(widthProperty().divide(2));
        label.prefHeightProperty().bind(heightProperty());
        button.prefWidthProperty().bind(widthProperty().divide(2));
    }

    /**
     * Instantiates a new Switch button.
     */
    public SwitchButton() {
        init();
        switchedOn.addListener((a, b, c) -> {
            if (c) {
                label.setText("R");
                setStyle("-fx-background-color: #17bdfd;");
                label.toFront();
            } else {
                label.setText("D");
                setStyle("-fx-background-color: #17bdfd;");
                button.toFront();
            }
        });
    }
}

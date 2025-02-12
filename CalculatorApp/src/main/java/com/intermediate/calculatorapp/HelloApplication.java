package com.intermediate.calculatorapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private final Calculator calculator = new Calculator();
    private String operator;
    private final TextField firstNumber = new TextField();
    private final TextField secondNumber = new TextField();
    private final TextArea screenView = new TextArea();
    private String errorMessage;
    @Override
    public void start(Stage stage) throws IOException {
        // Screen View
        screenView.setFont(Font.font("Helvetica", FontWeight.SEMI_BOLD, 32));
        screenView.setPrefHeight(200);
        screenView.setPrefWidth(600);
        screenView.setFocusTraversable(false);
        screenView.setEditable(false);

        // This first number
        Label firstNumberLabel = new Label("First Number");
        firstNumberLabel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
        firstNumber.setMinWidth(200);
        // This is second number
        Label secondNumberLabel = new Label("Second Number");
        secondNumberLabel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
        secondNumber.setMinWidth(200);

        Label errors = new Label(errorMessage);
        errors.setFont(Font.font("Helvetica", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        errors.setTextFill(Color.RED);
        // Operator buttons
        Button addition = new Button("Sum");
        Button multiply = new Button("Multiply");
        Button divide = new Button("Divide");
        Button subtract = new Button("Subtract");
        Button modulo = new Button("Modulo");

        // Setup Actions for the Buttons
        addition.setOnAction(event -> operator = "sum");
        multiply.setOnAction(event -> operator = "multiply");
        divide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                operator = "divide";
            }
        });

        subtract.setOnAction(actionEvent -> operator = "subtract");
        modulo.setOnAction(actionEvent -> operator = "modulo");

        addition.setPrefWidth(80);
        addition.setPrefHeight(40);
        multiply.setPrefWidth(80);
        multiply.setPrefHeight(40);
        divide.setPrefWidth(80);
        divide.setPrefHeight(40);
        subtract.setPrefWidth(80);
        subtract.setPrefHeight(40);
        modulo.setPrefWidth(80);
        modulo.setPrefHeight(40);

        VBox operators = new VBox();
        operators.setPadding(new Insets(5, 10, 10, 0));
        operators.setSpacing(10);
        operators.getChildren().addAll(multiply, divide, addition, subtract, modulo);

        VBox fieldInformation = new VBox();
        fieldInformation.setPadding(new Insets(5, 20, 10, 20));
        VBox.setVgrow(fieldInformation, Priority.ALWAYS);
        fieldInformation.setSpacing(10);
        fieldInformation.getChildren().addAll(firstNumberLabel, firstNumber, secondNumberLabel, secondNumber, errors);

        HBox calculateResult = new HBox();
        calculateResult.setPadding(new Insets(0, 10, 10, 0));
        calculateResult.setAlignment(Pos.BOTTOM_RIGHT);

        Button calculate = new Button("Evaluate");
        calculate.setOnAction(new CalculateHandler());
        calculate.setPrefWidth(80);
        calculate.setPrefHeight(40);
        calculateResult.getChildren().add(calculate);

        // Create a root element
        BorderPane root = new BorderPane();
        root.setTop(screenView);
        root.setCenter(fieldInformation);
        root.setRight(operators);
        root.setBottom(calculateResult);

        Scene scene = new Scene(root, 680, 440);
        stage.setTitle("Calculator");
        stage.setMinWidth(540);
        stage.setMinHeight(440);
        stage.setScene(scene);
        stage.show();
    }

    private class CalculateHandler implements EventHandler<ActionEvent> {
        // Used to calculate the whole operation
        @Override
        public void handle(ActionEvent event) {
            try {
                // Clear the screen before writing new operation
                if (screenView.getText() != null) screenView.setText("");
                // New operation
                double first = Double.parseDouble(firstNumber.getText()),
                second = Double.parseDouble(secondNumber.getText()),
                result = calculator.calculation(operator, first, second);
                screenView.appendText(String.valueOf(result));
                // To reset the view after the calculation
                resetValues(firstNumber, secondNumber);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                errorMessage = ex.getMessage();
            }
        }

        private void resetValues(TextField firstNumber, TextField secondNumber) {
            if (firstNumber.getText() != null || secondNumber.getText() != null) {
                firstNumber.setText("");
                secondNumber.setText("");
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.javafx_practical;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class lab35 extends Application {

    private TextField op1Field = new TextField();
    private TextField op2Field = new TextField();
    private Label resultLabel = new Label("Result: ");

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        op1Field.setPromptText("Enter first number");
        op2Field.setPromptText("Enter second number");

        grid.add(new Label("Operand 1:"), 0, 0);
        grid.add(op1Field, 1, 0);
        grid.add(new Label("Operand 2:"), 0, 1);
        grid.add(op2Field, 1, 1);

        // Radio buttons for operations
        ToggleGroup operations = new ToggleGroup();

        RadioButton add = new RadioButton("Add");
        RadioButton sub = new RadioButton("Subtract");
        RadioButton mul = new RadioButton("Multiply");
        RadioButton div = new RadioButton("Divide");

        add.setToggleGroup(operations);
        sub.setToggleGroup(operations);
        mul.setToggleGroup(operations);
        div.setToggleGroup(operations);

        grid.add(add, 0, 2);
        grid.add(sub, 1, 2);
        grid.add(mul, 0, 3);
        grid.add(div, 1, 3);

        // Buttons
        Button calcButton = new Button("Calculate");
        Button clearButton = new Button("Clear");

        grid.add(calcButton, 0, 4);
        grid.add(clearButton, 1, 4);
        grid.add(resultLabel, 0, 5, 2, 1);

        // Button actions
        calcButton.setOnAction(e -> calculate(operations));
        clearButton.setOnAction(e -> clearAll(operations));

        stage.setTitle("Simple Calculator");
        Scene scene = new Scene(grid, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void calculate(ToggleGroup operations) {
        try {
            double op1 = Double.parseDouble(op1Field.getText());
            double op2 = Double.parseDouble(op2Field.getText());
            double result = 0;

            RadioButton selected = (RadioButton) operations.getSelectedToggle();
            if (selected == null) {
                resultLabel.setText("Result: Select an operation");
                return;
            }

            switch (selected.getText()) {
                case "Add": result = op1 + op2; break;
                case "Subtract": result = op1 - op2; break;
                case "Multiply": result = op1 * op2; break;
                case "Divide":
                    if (op2 != 0) result = op1 / op2;
                    else {
                        resultLabel.setText("Result: Error (Division by zero)");
                        return;
                    }
                    break;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Result: Invalid Input");
        }
    }

    private void clearAll(ToggleGroup operations) {
        op1Field.clear();
        op2Field.clear();
        resultLabel.setText("Result: ");
        operations.getSelectedToggle().setSelected(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


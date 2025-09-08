package com.example.javafx_practical;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab33 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Simple Login Form");

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();

        Button loginBtn = new Button("Login");

        Label message = new Label();

        loginBtn.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                message.setText("Please enter both username and password!");
            } else {
                message.setText("Login successful!");
            }
        });

        VBox vbox = new VBox(10, userLabel, userField, passLabel, passField, loginBtn, message);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

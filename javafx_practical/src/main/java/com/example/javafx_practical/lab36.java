package com.example.javafx_practical;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class lab36 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("File Chooser Demo");

        TextField pathField = new TextField();
        pathField.setPrefWidth(300);
        pathField.setEditable(false);

        Button chooseButton = new Button("Choose File");

        chooseButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                pathField.setText(selectedFile.getAbsolutePath());
            }
        });

        HBox hbox = new HBox(10, pathField, chooseButton);
        hbox.setPadding(new Insets(10));

        Scene scene = new Scene(hbox, 450, 70);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


package com.example.javafx_practical;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class lab34 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("FlowPane + BorderPane Example");

        //Menu Bar at Top
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        fileMenu.getItems().addAll(
                new MenuItem("New"),
                new MenuItem("Open"),
                new MenuItem("Exit")
        );

        Menu editMenu = new Menu("Edit");
        editMenu.getItems().addAll(
                new MenuItem("Cut"),
                new MenuItem("Copy"),
                new MenuItem("Paste")
        );

        menuBar.getMenus().addAll(fileMenu, editMenu);

        //FlowPane at Center with Buttons
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);

        for (int i = 1; i <= 6; i++) {
            flowPane.getChildren().add(new Button("Button " + i));
        }

        //BorderPane Layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(flowPane);

        Scene scene = new Scene(borderPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


package com.example.demo;

import game.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import input.GuiInputSource;
import java.io.PrintStream;

public class HelloApplication extends Application {

    private Game game;
    private GuiInputSource guiInputSource = new GuiInputSource();

    @Override
    public void start(Stage primaryStage) {
        game = new Game(guiInputSource);

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> new Thread(() -> game.start()).start());

        Button stopButton = new Button("Stop Game");
        stopButton.setOnAction(e -> game.stop());

        VBox layout = new VBox(10);  // 10 pixels of spacing between child nodes
        layout.getChildren().addAll(startButton, stopButton);

        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);  // make it read-only
        layout.getChildren().add(outputArea);

        TextField inputField = new TextField();
        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            guiInputSource.setInput(inputField.getText());
            inputField.clear();
        });
        layout.getChildren().addAll(inputField, sendButton);

        PrintStream printStream = new PrintStream(new CustomOutputStream(outputArea));
        System.setOut(printStream);
        System.setErr(printStream);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
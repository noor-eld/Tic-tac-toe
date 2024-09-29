package com.example.tictactoes;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage stage) {
        tictactoe game = new tictactoe();
        game.start(stage);
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}

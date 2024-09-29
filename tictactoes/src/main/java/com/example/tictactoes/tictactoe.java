package com.example.tictactoes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class tictactoe extends Application implements EventHandler<ActionEvent> {

    private Button[] buttons = new Button[9];
    private GridPane buttonPanel = new GridPane();
    private Label textfield = new Label();
    Random random = new Random();
    boolean player1_turn;

    @Override
    public void start(Stage stage) {
        // Set up the textfield
        textfield.setFont(new Font("Arial", 60));
        textfield.setText("Tic-Tac-Toe");
        textfield.setTextFill(Color.WHITE);
        textfield.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        textfield.setPadding(new Insets(20));
        textfield.setAlignment(Pos.CENTER);

        // Set up the GridPane
        buttonPanel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        // Configure GridPane to fill available space
        for (int i = 0; i < 3; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setPercentWidth(100.0 / 3);
            buttonPanel.getColumnConstraints().add(colConstraints);

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / 3);
            buttonPanel.getRowConstraints().add(rowConstraints);
        }

        // Add buttons to the GridPane
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            buttons[i].setStyle("-fx-background-color: #FFFFFF; -fx-border-color: transparent;");
            buttons[i].setFont(new Font("Arial", 70));
            buttonPanel.add(buttons[i], i % 3, i / 3);
            buttons[i].setFocusTraversable(false);
            buttons[i].setOnAction(this);
        }

        // Set alignment and padding for the GridPane
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setHgap(5);
        buttonPanel.setVgap(5);
        buttonPanel.setPadding(new Insets(10));

        // Create an HBox for the title
        HBox header = new HBox(textfield);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10));
        header.setFillHeight(true);

        // Create a BorderPane to organize the layout
        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(buttonPanel);

        turn();


        // Create and set the scene
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.setOnCloseRequest(event -> System.exit(0));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setTextFill(Color.RED); // Set text color to red
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setTextFill(Color.BLUE); // Set text color to blue
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }


    public void turn() {
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        //check x win
        if(
                (buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")){

            xWins(0,1,2);
        }
        if(
                (buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")){

            xWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")){

            xWins(6,7,8);
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")){

            xWins(0,3,6);
        }
        if(
                (buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")){

            xWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")){

            xWins(2,5,8);
        }
        if(
                (buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")){

            xWins(0,4,8);
        }
        if(
                (buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")){

            xWins(2,4,6);
        }
        if(
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")){

            xWins(0,1,2);
        }
        if(
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")){

            xWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")){

            xWins(6,7,8);
        }
        if(
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")){

            xWins(0,3,6);
        }
        if(
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")){

            xWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")){

            xWins(2,5,8);
        }
        if(
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")){

            xWins(0,4,8);
        }
        if(
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")){

            xWins(2,4,6);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")){

            oWins(0,1,2);
        }
        if(
                (buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")){

            oWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")){

            oWins(6,7,8);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")){

            oWins(0,3,6);
        }
        if(
                (buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")){

            oWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")){

            oWins(2,5,8);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")){

            oWins(0,4,8);
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")){

            oWins(2,4,6);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")){

            oWins(0,1,2);
        }
        if(
                (buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")){

            oWins(3,4,5);
        }
        if(
                (buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")){

            oWins(6,7,8);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")){

            oWins(0,3,6);
        }
        if(
                (buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")){

            oWins(1,4,7);
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")){

            oWins(2,5,8);
        }
        if(
                (buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")){

            oWins(0,4,8);
        }
        if(
                (buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")){

            oWins(2,4,6);
        }
        // check draw
        int i = 0;
        while (buttons[i].getText() != "") {
            if (i == buttons.length - 1) {
                draw();
                break;
            }
            i++;
        }
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        buttons[b].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        buttons[c].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

        for(int i = 0; i < 9; i++){
            buttons[i].setDisable(true);
        }
        textfield.setText("X Wins!");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        buttons[b].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        buttons[c].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

        for(int i = 0; i < 9; i++){
            buttons[i].setDisable(true);
        }
        textfield.setText("O Wins!");
    }
    public void draw() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setDisable(true);
        }
        textfield.setText("Draw");
    }
}


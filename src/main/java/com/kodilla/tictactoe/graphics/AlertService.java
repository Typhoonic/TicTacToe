package com.kodilla.tictactoe.graphics;

import com.kodilla.tictactoe.TicTacToe;
import com.kodilla.tictactoe.repository.Ranking;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertService {

    private final Ranking ranking = new Ranking();
    private final TicTacToe ticTacToe = new TicTacToe();

    public void playerWin(Stage primaryStage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You Win! Want you play again? Your ranking: " + ranking.showRanking(), ButtonType.YES, ButtonType.NO);
        makeAlert(alert, primaryStage);
    }

    public void cpuWin(Stage primaryStage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You loose! Want you play again? Your ranking: " + ranking.showRanking(), ButtonType.YES, ButtonType.NO);
        makeAlert(alert, primaryStage);
    }

    public void draw(Stage primaryStage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "DRAW! Want you play again? Your ranking: " + ranking.showRanking(), ButtonType.YES, ButtonType.NO);
        makeAlert(alert, primaryStage);
    }

    public void makeAlert(Alert alert, Stage primaryStage){

        alert.setHeight(200);
        alert.setWidth(200);
        alert.initOwner(primaryStage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            try {
               ticTacToe.start(primaryStage);
            }catch (Exception e){
                System.out.println("Error:" + e);
            }
        }

        if(alert.getResult() == ButtonType.NO){
            System.exit(0);
        }

    }
}


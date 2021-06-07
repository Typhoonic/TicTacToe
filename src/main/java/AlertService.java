
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertService {

    Ranking ranking = new Ranking();
    TicTacToe tic = new TicTacToe();


    public void playerWin(Stage primaryStage){

        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "You Win! Want you play again?\nYour ranking: " + ranking.showRanking(), ButtonType.YES, ButtonType.NO);
        alert.initOwner(primaryStage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            try {
                tic.start(primaryStage);
            }catch (Exception e){
                System.out.println("Error:" + e);
            }
        }

        if(alert.getResult() == ButtonType.NO){
            System.exit(0);
        }
    }

    public void cpuWin(Stage primaryStage){

        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "You loose! Want you play again?\nYour ranking: " + ranking.showRanking(), ButtonType.YES, ButtonType.NO);
        alert.initOwner(primaryStage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            try {
                tic.start(primaryStage);
            }catch (Exception e){
                System.out.println("Error:" + e);
            }
        }

        if (alert.getResult() == ButtonType.NO){
            System.exit(0);
        }
    }

    public void draw(Stage primaryStage){

        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "DRAW! Want you play again?\nYour ranking: " + ranking.showRanking(), ButtonType.YES, ButtonType.NO);
        alert.initOwner(primaryStage);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            try {
                tic.start(primaryStage);
            }catch (Exception e){
                System.out.println("Error:" + e);
            }
        }

        if (alert.getResult() == ButtonType.NO){
            System.exit(0);
        }
    }

}

import javafx.stage.Stage;

public class Checker {

    private int tmp = 0;
    private final AlertService alert = new AlertService();
    private final Ranking ranking = new Ranking();
    private final MyButton[][] handle;
    private final Stage primaryStage;

    public Checker(MyButton[][] handle, Stage primaryStage) {
        this.handle = handle;
        this.primaryStage = primaryStage;
    }

    public boolean check(){

        if(columnWin())
            return true;
        else if(rowWin())
            return true;
        else if(diagonallyWin())
            return true;
        else return Draw();

    }

    public boolean columnWin(){

        if ("X".equals(handle[0][0].getText()) && "X".equals(handle[1][0].getText()) && "X".equals(handle[2][0].getText()) || "X".equals(handle[0][1].getText()) && "X".equals(handle[1][1].getText()) && "X".equals(handle[2][1].getText()) || "X".equals(handle[0][2].getText()) && "X".equals(handle[1][2].getText()) && "X".equals(handle[2][2].getText())) {
            ranking.saveRanking(1,1,0);
            alert.playerWin(primaryStage);
            tmp = 0;
            return true;
        } else if ("O".equals(handle[0][0].getText()) && "O".equals(handle[1][0].getText()) && "O".equals(handle[2][0].getText()) || "O".equals(handle[0][1].getText()) && "O".equals(handle[1][1].getText()) && "O".equals(handle[2][1].getText()) || "O".equals(handle[0][2].getText()) && "O".equals(handle[1][2].getText()) && "O".equals(handle[2][2].getText())) {
            ranking.saveRanking(0,1,0);
            alert.cpuWin(primaryStage);
            tmp = 0;
            return true;
        }
        return false;
    }

    public boolean rowWin(){

        if ("X".equals(handle[0][0].getText()) && "X".equals(handle[0][1].getText()) && "X".equals(handle[0][2].getText()) || "X".equals(handle[1][0].getText()) && "X".equals(handle[1][1].getText()) && "X".equals(handle[1][2].getText()) || "X".equals(handle[2][0].getText()) && "X".equals(handle[2][1].getText()) && "X".equals(handle[2][2].getText())) {
            ranking.saveRanking(1,1,0);
            alert.playerWin(primaryStage);
            tmp = 0;
            return true;
        } else if ("O".equals(handle[0][0].getText()) && "O".equals(handle[0][1].getText()) && "O".equals(handle[0][2].getText()) || "O".equals(handle[1][0].getText()) && "O".equals(handle[1][1].getText()) && "O".equals(handle[1][2].getText()) || "O".equals(handle[2][0].getText()) && "O".equals(handle[2][1].getText()) && "O".equals(handle[2][2].getText())) {
            ranking.saveRanking(0,1,0);
            alert.cpuWin(primaryStage);
            tmp = 0;
            return true;
        }
        return false;
    }

    public boolean diagonallyWin(){

        if ("X".equals(handle[0][0].getText()) && "X".equals(handle[1][1].getText()) && "X".equals(handle[2][2].getText()) || "X".equals(handle[0][2].getText()) && "X".equals(handle[1][1].getText()) && "X".equals(handle[2][0].getText())) {
            ranking.saveRanking(1,1,0);
            alert.playerWin(primaryStage);
            tmp = 0;
            return true;
        } else if ("O".equals(handle[0][0].getText()) && "O".equals(handle[1][1].getText()) && "O".equals(handle[2][2].getText()) || "O".equals(handle[0][2].getText()) && "O".equals(handle[1][1].getText()) && "O".equals(handle[2][0].getText())) {
            ranking.saveRanking(0,1,0);
            alert.cpuWin(primaryStage);
            tmp = 0;
            return true;
        }

        return false;

    }

    public boolean Draw(){

        tmp++;
        if(tmp == 9) {
            ranking.saveRanking(0,1,1);
            alert.draw(primaryStage);
            tmp = 0;
            return true;
        }
        return false;
    }

}


import javafx.scene.control.Label;
import java.io.*;

public class Ranking {

    private int win = 0;
    private int matches = 0;
    private int draw = 0;

    public void saveRanking(int win, int matches, int draw) {

        loadRanking();
        Label label = new Label();
        label.setText("Win: " + win + "Matches: " + matches + "Draw: " + draw);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ranking.txt", false))) {
            bw.write( "|" + (this.win + win)  + "|" + (this.matches + matches) + "|" + (this.draw + draw) + "|");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRanking(){

        File file = new File("ranking.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            String[] split = line.split("\\|", 0);
            this.win = Integer.parseInt(split[1]);
            this.matches = Integer.parseInt(split[2]);
            this.draw = Integer.parseInt(split[3]);

        }catch(IOException e ) {
            e.printStackTrace();
        }
    }

    public String showRanking(){
        String line = "";
        File file = new File("ranking.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();

        }catch(IOException e ) {
            e.printStackTrace();
        }
        return line;
    }

}

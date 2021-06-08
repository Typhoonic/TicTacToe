import java.util.Random;

public class Easy implements Computer{

    private final Random random = new Random();

    @Override
    public void makeMove(MyButton[][] graphButtons) {

        for(;;){

            int x = random.nextInt(3);
            int y = random.nextInt(3);

            if("X".equals(graphButtons[x][y].getText()) || "O".equals(graphButtons[x][y].getText()))
                continue;

            graphButtons[x][y].setText("O");
            break;

        }

    }
}

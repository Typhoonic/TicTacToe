import java.util.Random;

public class Easy implements Computer{

        private final Random random = new Random();

        @Override
        public void makeMove(MyButton[][] graphButtons) {

            for(;;){

                int x = random.nextInt(3);
                int y = random.nextInt(3);

                if(graphButtons[x][y].getText().equals("X") || graphButtons[x][y].getText().equals("O"))
                    continue;

                graphButtons[x][y].setText("O");
                break;

            }

        }
}

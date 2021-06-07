import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final Image imageback = new Image("file:src/main/resources/Background.png");
    MyButton[][] graphButtons = new MyButton[3][3];
    Stage primaryStage;
    Checker checker;
    Easy cpu = new Easy();

    @Override
    public void start(Stage primaryStage) throws Exception {


        checker = new Checker(graphButtons,primaryStage);
        BorderPane root = new BorderPane();
        this.primaryStage = primaryStage;

        //MenuImplementation
        Menu menu = new Menu("Menu");
        MenuItem menuItem1 = new MenuItem("Restart");
        MenuItem menuItem2 = new MenuItem("Exit");
        menu.getItems().addAll(menuItem1,menuItem2);

        menuItem1.setOnAction(event->{
            try {
                start(primaryStage);
            }catch (java.lang.Exception e){
                System.out.println("Error:" + e);
            }
        });

        menuItem2.setOnAction(event -> System.exit(0));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        BackgroundSize backgroundSize = new BackgroundSize(150,150, true, true,true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);

        //SetGap
        grid.setHgap(20);
        grid.setVgap(20);

        for(int i = 0; i < graphButtons.length; i++){
            for(int j = 0; j < graphButtons[i].length; j++){
                graphButtons[i][j] = new MyButton(i, j);
                graphButtons[i][j].setOnMouseClicked(this::handleEvent);
            }
        }

        //SetButtonsOnGrips
        grid.add(graphButtons[0][0],1,0);
        grid.add(graphButtons[1][0], 1, 1);
        grid.add(graphButtons[2][0], 1, 2);
        grid.add(graphButtons[0][1],2,0);
        grid.add(graphButtons[1][1], 2, 1);
        grid.add(graphButtons[2][1], 2, 2);
        grid.add(graphButtons[0][2],3,0);
        grid.add(graphButtons[1][2], 3, 1);
        grid.add(graphButtons[2][2], 3, 2);

        root.setTop(menuBar);
        root.setCenter(grid);

        Scene scene = new Scene(root, imageback.getWidth(),imageback.getHeight());

        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }


    public void handleEvent(MouseEvent mouseEvent){

        MyButton sourceButton = (MyButton)mouseEvent.getSource();
        int x = sourceButton.getX();
        int y = sourceButton.getY();

        if (!graphButtons[x][y].getText().contains("O"))
            graphButtons[x][y].setText("X");

        boolean isTrue = checker.check();
        if(!isTrue)
            cpu.makeMove(graphButtons);
        checker.check();

    }
}

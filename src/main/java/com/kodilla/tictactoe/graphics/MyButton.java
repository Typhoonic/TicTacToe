package com.kodilla.tictactoe.graphics;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyButton extends Button {

    private final int x;
    private final int y;

    public MyButton(int x, int y){

        this.x = x;
        this.y = y;
        this.setStyle("-fx-background-color: transparent;");
        this.setPrefSize(170,150);
        this.setFont(new Font(50));
        this.setTextFill(Color.WHITE);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

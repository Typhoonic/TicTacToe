package com.kodilla.tictactoe.condition;

import com.kodilla.tictactoe.graphics.AlertService;
import com.kodilla.tictactoe.graphics.MyButton;
import com.kodilla.tictactoe.repository.Ranking;
import javafx.stage.Stage;

public class Checker {

    private int hit = 0;
    private final AlertService alert = new AlertService();
    private final Ranking ranking = new Ranking();
    private final MyButton[][] handle;
    private final Stage primaryStage;

    public Checker(MyButton[][] handle, Stage primaryStage) {
        this.handle = handle;
        this.primaryStage = primaryStage;
    }

    public boolean isGameOver() {

        if (columnLoose() || rowLoose() || diagonallyLoose()) {
            endGame(0, 1, 0);
            return true;
        } else if (columnWin() || rowWin() || diagonallyWin()) {
            endGame(1, 1, 0);
            return true;
        } else if (draw()) {
            endGame(0, 1, 1);
            return true;
        }
        return false;
    }

    public void endGame(int x, int y, int z) {
        ranking.saveRanking(x, y, z);
        if (x == 1 && y == 1 && z == 0)
            alert.playerWin(primaryStage);
        if (x == 0 && y == 1 && z == 0)
            alert.cpuWin(primaryStage);
        if (x == 0 && y == 1 && z == 1)
            alert.draw(primaryStage);
    }

    public boolean columnWin() {

        for (int i = 0; i < handle.length; i++) {
            hit = 0;
            for (int j = 0; j < handle[i].length; j++) {
                if ("X".equals(handle[j][i].getText())) {
                    hit++;
                    if (hit == handle.length) {
                        hit = 0;
                        return true;
                    }
                }
            }
        }
        hit = 0;
        return false;
    }

    public boolean columnLoose() {

        for (int i = 0; i < handle.length; i++) {
            hit = 0;
            for (int j = 0; j < handle[i].length; j++) {
                if ("O".equals(handle[j][i].getText())) {
                    hit++;
                    if (hit == handle.length) {
                        hit = 0;
                        return true;
                    }
                }
            }
        }
        hit = 0;
        return false;
    }

    public boolean rowWin() {

        for (int i = 0; i < handle.length; i++) {
            hit = 0;
            for (int j = 0; j < handle[i].length; j++) {
                if ("X".equals(handle[i][j].getText())) {
                    hit++;
                    if (hit == handle.length) {
                        hit = 0;
                        return true;
                    }
                }
            }
        }
        hit = 0;
        return false;
    }

    public boolean rowLoose() {

        for (int i = 0; i < handle.length; i++) {
            hit = 0;
            for (int j = 0; j < handle[i].length; j++) {
                if ("O".equals(handle[i][j].getText())) {
                    hit++;
                    if (hit == handle.length) {
                        hit = 0;
                        return true;
                    }
                }
            }
        }
        hit = 0;
        return false;
    }

    public boolean diagonallyWin() {

        int k = 2;

        for (int i = 0; i < handle.length; i++) {
            if ("X".equals(handle[i][i].getText())) {
                hit++;
                if (hit == handle.length) {
                    hit = 0;
                    return true;
                }
            }
        }

        hit = 0;

        for (int j = 0; j < handle.length; j++) {
            if ("X".equals(handle[j][k].getText())) {
                hit++;
                if (hit == handle.length) {
                    hit = 0;
                    return true;
                }
            }
            k--;
        }
        hit = 0;
        return false;
    }

    public boolean diagonallyLoose() {

        int k = 2;

        for (int i = 0; i < handle.length; i++) {
            if ("O".equals(handle[i][i].getText())) {
                hit++;
                if (hit == handle.length) {
                    hit = 0;
                    return true;
                }
            }
        }

        hit = 0;

        for (int j = 0; j < handle.length; j++) {
            if ("O".equals(handle[j][k].getText())) {
                hit++;
                if (hit == handle.length) {
                    hit = 0;
                    return true;
                }
            }
            k--;
        }
        hit = 0;
        return false;
    }

    public boolean draw () {

        for (int i = 0; i < handle.length; i++) {
            for (int j = 0; j < handle[i].length; j++) {
                if ("O".equals(handle[i][j].getText()) || "X".equals(handle[i][j].getText())) {
                    hit++;
                    if (hit == handle.length * handle.length) {
                        hit = 0;
                        return true;
                    }
                }
            }
        }
        hit = 0;
        return false;
    }
}


package tictactoe.model;

import tictactoe.view.XOButton;

public class Buttons {

    // first - 1, second - 2
    private int who;
    private boolean free;
    public int X, Y;


    // 1 - pvp, 2 - pvm
    public Buttons(int whichGame) {
        if (whichGame == 1)
            gamePvP();
        else
            gameWithAI();

        free = true;


    }

    public void setTest(int who, boolean free) {
        this.free = free;
        this.who = who;
    }

    public void gamePvP() {
        XOButton.PvP();
    }

    public void gameWithAI() {
        XOButton.AI();

    }


    public void endGame() {
        free = false;
    }

    public int getWho() {
        return who;
    }


    public void setWho(int who) {
        this.who = who;
    }

    public boolean isFree() {
        return isFree();
    }
}

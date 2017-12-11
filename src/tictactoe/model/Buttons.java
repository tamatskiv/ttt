package tictactoe.model;

import tictactoe.view.*;

import tictactoe.model.PvMGameProcess;
import tictactoe.model.PvPGameProcess;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {

    // first - 1, second - 2
    private int who;
    private boolean free;
    public int X, Y;

    XOButton butt = new XOButton();

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
        butt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (free) {
                    setWho(PvPGameProcess.turn());
                    free = false;
                    PvPGameProcess.isWinner(X, Y);
                }
            }
        });
    }

    public void gameWithAI() {
        butt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (PvMGameProcess.getTurn() == 0 && free) {
                    int which = PvMGameProcess.getTurn();
                    setWho(which == 0 ? 2 : 1);
                    PvMGameProcess.isWinner(X, Y);
                    PvMGameProcess.setComp(true);
                    PvMGameProcess.lvl();
                    PvMGameProcess.setComp(false);
                }
                if (PvMGameProcess.getTurn() == 1 && free) {
                    int which = PvMGameProcess.getTurn();
                    setWho(which == 0 ? 2 : 1);
                    PvMGameProcess.isWinner(X, Y);
                    PvMGameProcess.setComp(true);
                    PvMGameProcess.lvl();
                    PvMGameProcess.setComp(false);
                }
            }
        });
    }

    public void refresh() {
        who = 0;
        butt.setIcon(null);
        butt.setEnabled(true);
        free = true;
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
        return butt.isFree();
    }
}

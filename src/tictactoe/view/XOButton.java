package tictactoe.view;

import tictactoe.model.Buttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;

public class XOButton extends JButton {

    private int who;
    private boolean free;

    public void setWho(int who) {
        if (free) {
            free = false;
            this.who = who;
            if (who == 1)
                setIcon(GameField.getFieldSize() == 3 ? AllImages.x3
                        : (GameField.getFieldSize() == 5 ? AllImages.x5 : AllImages.x7));
            else
                setIcon(GameField.getFieldSize() == 3 ? AllImages.o3
                        : (GameField.getFieldSize() == 5 ? AllImages.o5 : AllImages.o7));
        }
    }


    public int getWho() {
        return who;
    }

    public boolean isFree() {
        return free;
    }

}
package tictactoe.view;

import tictactoe.model.*;

import java.awt.*;
import javax.swing.*;

public class GameField extends JPanel {

    private static int fieldSize;
    private static Buttons buttons[][];
    private static XOButton[][] button;


    XOButton butt = new XOButton();

    public GameField(int fieldSize, int whichGame) {
        this.fieldSize = fieldSize;

        setLayout(new GridLayout(fieldSize, fieldSize));
        setSize(400, 400);

        buttons = new Buttons[fieldSize][fieldSize];
        button = new XOButton[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                buttons[i][j] = new Buttons(whichGame);
                button[i][j] = new XOButton();
                buttons[i][j].X = i;
                buttons[i][j].Y = j;
                button[i][j].setBackground(new Color(127, 131, 135));
                button[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                add(button[i][j]);
            }
        }

        setVisible(true);
    }


    public static int getFieldSize() {
        return fieldSize;
    }

    public static Buttons[][] getButtons() {
        return buttons;
    }

}
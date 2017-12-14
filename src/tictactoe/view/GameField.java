package tictactoe.view;


import java.awt.*;
import javax.swing.*;

public class GameField extends JPanel {

    private static int fieldSize;
    private static XOButton buttons[][];

    public GameField(int fieldSize, int whichGame) {
        this.fieldSize = fieldSize;

        setLayout(new GridLayout(fieldSize, fieldSize));
        setSize(400, 400);

        buttons = new XOButton[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                buttons[i][j] = new XOButton(whichGame);
                buttons[i][j].X = i;
                buttons[i][j].Y = j;
                buttons[i][j].setBackground(new Color(127, 131, 135));
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    public static int getFieldSize() {
        return fieldSize;
    }

    public static XOButton[][] getButtons() {
        return buttons;
    }
}
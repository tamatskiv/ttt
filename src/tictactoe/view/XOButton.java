package tictactoe.view;

import tictactoe.model.PvMGameProcess;
import tictactoe.model.PvPGameProcess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class XOButton extends JButton {

    private int who;
    private boolean free;
    public int X, Y;

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


    public void AI() {

        addActionListener(new ActionListener() {

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
        }
    }
            public void PvP() {

                addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (free) {
                            setWho(PvPGameProcess.turn());
                            free = false;
                            PvPGameProcess.isWinner(X, Y);
                        }
                    }
                }
            }

                    public void refresh() {
                        who = 0;
                        setIcon(null);
                        setEnabled(true);
                        free = true;
                    }

                    public int getWho() {
                        return who;
                    }

                    public boolean isFree() {
                        return free;
                    }


            }
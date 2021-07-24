package TicTacToe.part2;

import TicTacToe.Player;
import TicTacToe.TTT_model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotGame extends javax.swing.JFrame{
    TTT_model tictac;
    JButton[][] buttons;
    JLabel winner;
    void botTurn(){
        int[] d = tictac.getMovesByBot();
        if(d[0] != -1 && d[1] != -1)
            buttons[d[0]][d[1]].setText(String.valueOf(tictac.getBoard()[d[0]][d[1]]));
        checkWin();
    }

     void validateMove(int i, int j){
        if(tictac.canInsertToCell(i,j)) {

            boolean a = checkWin();
            if(!a) tictac.updateBoard(i, j);
            buttons[i][j].setText(String.valueOf(tictac.getCellValue(i,j)));
            a = checkWin();
            if(!a) botTurn();
        }
         if(tictac.checkWin(tictac.getBoard()) == Player.Blank &&!tictac.canInsert()){
             winner.setText("Draw");
         }
    }

    private boolean checkWin() {
        if(tictac.checkWin(tictac.getBoard()) != Player.Blank){
            //check for row first
            if(tictac.getWinRow(tictac.getBoard()) != -1){
                //win by row
                int rw = tictac.getWinRow(tictac.getBoard());
                System.out.println(rw);
                for (int i = 0; i < 3; i++) {
                   buttons[rw][i].setBackground(c);
                }

            }

            if(tictac.getWinColumn(tictac.getBoard()) != -1){

                int cw = tictac.getWinColumn(tictac.getBoard());
                //win by column

                for (int i = 0; i < 3; i++) {
                    buttons[i][cw].setBackground(c);
                }
            }
            if(tictac.checkDiagonalForWin(tictac.getBoard()) != -1){
                //win by diagonal

                int dw = tictac.checkDiagonalForWin(tictac.getBoard());
                if(dw == 0){
                    for (int i = 0; i < 3; i++) {
                        buttons[i][i].setBackground(c);
                    }
                }else if(dw == 1){
                    buttons[1][1].setBackground(c);
                    buttons[0][2].setBackground(c);
                    buttons[2][0].setBackground(c);
                }
            }
            winner.setText("Won by: " + tictac.checkWin(tictac.getBoard()).asChar());
            // set setEnabled To false if someone won
            for (int e = 0; e < 3; e++) {
                for (int l = 0; l < 3; l++) {
                    buttons[e][l].setEnabled(false);
                }
            }
            return true;
        }
        return false;
    }
    Color c;
    BotGame(String pO) {
        c = Configuration.getInstance().color.getColor();
        tictac = new TTT_model(Player.O);
        initComponents(pO);

    }
    private void initComponents(String pO){
        buttons = new JButton[3][3];
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setBorder(Configuration.getInstance().board.getBorder());
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        validateMove(finalI,finalJ);
                    }
                });

                panel.add(buttons[i][j]);
            }
        }
        JPanel playerDetails = new JPanel();
        JLabel playerO = new JLabel("Player O: " + pO);
        playerO.setHorizontalAlignment(SwingConstants.LEFT);
        playerO.setFont(new Font("Sans Serif", Font.BOLD, 15));
        playerDetails.add(playerO);
        playerDetails.setLayout(new GridLayout(2,1));

        JPanel miscButtons = new JPanel();
        JButton restart = new JButton("Restart");
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GUI();
            }
        });

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BotGame(pO);
            }
        });

        miscButtons.add(back);
        miscButtons.add(restart);


        JPanel panel2= new JPanel();
        winner = new JLabel("");

        winner.setFont(new Font("Sans Serif", Font.BOLD, 20));

        setLayout(new GridBagLayout());
        panel2.add(winner);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        add(panel2,c);

        c.gridx = 0;
        c.gridy = 1;
        add(panel,c);

        c.gridx = 0;
        c.gridy = 2;
        add(playerDetails,c);

        c.gridx = 0;
        c.gridy = 3;
        add(miscButtons,c);
        setVisible(true);

        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

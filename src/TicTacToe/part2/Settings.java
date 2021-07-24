package TicTacToe.part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Settings extends javax.swing.JFrame{

public Settings(){
    initComponents();
}

void initComponents(){
    JLabel color = new JLabel("Win Color");
    JComboBox<String> colorsList = new JComboBox<String>(Configuration.getAllColors());

    JLabel b = new JLabel("Board Type");
    JComboBox<String> board = new JComboBox<String>(Configuration.getBoardTypes());
    JPanel jp =new JPanel();

    jp.add(color);
    jp.add(colorsList);

    JPanel jp2 = new JPanel();
    jp2.add(b);
    jp2.add(board);

    JButton ok = new JButton("Save");
    ok.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();

            new GUI();
        }
    });

    JPanel jp3 = new JPanel();
    jp3.add(ok);

    add(jp);
    add(jp2);
    add(jp3);
    board.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(board.getSelectedItem());
            switch ((String) Objects.requireNonNull(board.getSelectedItem())) {
                case "YellowRed" -> Configuration.getInstance().setBoard(BoardType.YellowRed);
                case "BlueGreen" -> Configuration.getInstance().setBoard(BoardType.BlueGreen);
                case "YellowGreen" -> Configuration.getInstance().setBoard(BoardType.YellowGreen);
            }
        }
    });
    colorsList.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch ((String) Objects.requireNonNull(colorsList.getSelectedItem())) {
                case "RED" -> Configuration.getInstance().setColor( WinColors.RED);
                case "YELLOW" -> Configuration.getInstance().setColor(WinColors.YELLOW);
                case "GREEN" -> Configuration.getInstance().setColor(WinColors.GREEN);
                case "BLUE" -> Configuration.getInstance().setColor(WinColors.BLUE);
            }
        }
    });
    setVisible(true);
    setSize(300,300);
    setTitle("Manish TICTAC");
    setLayout(new GridLayout(4,1));
}

}

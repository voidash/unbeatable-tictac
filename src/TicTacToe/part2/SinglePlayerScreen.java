package TicTacToe.part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SinglePlayerScreen extends javax.swing.JFrame{
    SinglePlayerScreen(){
        initComponents();
    }
    private void initComponents(){

        JPanel jp2 = new JPanel();
        JTextField pO = new JTextField(16);
        JLabel pOLabel = new JLabel("Player O name: ");
        jp2.add(pOLabel);
        jp2.add(pO);

        JButton start = new JButton("Start");
        JButton back = new JButton("Back");
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);

        start.setPreferredSize(new Dimension(200,40));
        back.setPreferredSize(new Dimension(200,40));

        JPanel panel = new JPanel();
        panel.add(start);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
                dispose();
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BotGame(pO.getText());
            }
        });
        setLayout(new GridLayout(2,1));
        add(jp2);
        add(panel);
        setVisible(true);
        setSize(540,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

package TicTacToe.part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame{

    public GUI(){
        initComponents();
    }

    public static void main(String[] args){
        new GUI();
    }
    private void initComponents(){


        JButton single = new JButton("Single Player");
        JButton multi = new JButton("Multi Player");
        JButton settings = new JButton("Settings");
        JButton about = new JButton("About");
        JButton exit = new JButton("Exit");
        single.setAlignmentX(Component.CENTER_ALIGNMENT);
        multi.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);
        about.setAlignmentX(Component.CENTER_ALIGNMENT);
        single.setAlignmentX(Component.CENTER_ALIGNMENT);

        single.setPreferredSize(new Dimension(200,40));
        multi.setPreferredSize(new Dimension(200,40));
        settings.setPreferredSize(new Dimension(200,40));
        about.setPreferredSize(new Dimension(200,40));
        exit.setPreferredSize(new Dimension(200,40));
        JPanel panel = new JPanel();
        panel.add(single);
        panel.add(multi);
        panel.add(settings);
        panel.add(about);
        panel.add(exit);

        single.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new SinglePlayerScreen();
               dispose();
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
            }
        });
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MultiplayerScreen();
                dispose();
            }
        });
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Settings();
            }
        });

        add(panel);
        setVisible(true);
        setSize(300,300);
        setTitle("TICTAC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}

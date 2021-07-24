package TicTacToe.part2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplayerScreen extends JFrame{
    MultiplayerScreen(){
        initComponents();
    }
    private void initComponents(){
        JPanel jp = new JPanel();
        JTextField pX = new JTextField(16);
        JLabel pXLabel = new JLabel("Player X name: ");
        jp.add(pXLabel);
        jp.add(pX);

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
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Game(pX.getText(),pO.getText());
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
                dispose();
            }
        });
        setLayout(new GridLayout(3,1));
        add(jp);
        add(jp2); add(panel);
        setVisible(true);
        setSize(550,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

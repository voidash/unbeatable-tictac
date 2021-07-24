package TicTacToe.part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends javax.swing.JFrame {
    About(){
        setLayout(new GridLayout(2,1));
        JLabel title = new JLabel("TIC TAC TOE");
        title.setFont(new Font("Sans Serif", Font.BOLD, 30));

        JLabel preparedBy = new JLabel("Prepared By Ashish Thapa");
        JLabel email = new JLabel("email: ashish.thapa477@gmail.com");
        JLabel studentId = new JLabel("github.com/voidash");

        JButton back = new JButton("ok");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();



        panel.add(title);
        panel.add(preparedBy);
        panel.add(email);
        panel.add(studentId);
        panel2.add(back);

        add(panel);
        add(panel2);
        setVisible(true);
        setSize(300,300);
    }
}

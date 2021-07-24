package TicTacToe.part2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public enum BoardType {

    YellowRed(BorderFactory.createBevelBorder(0, Color.yellow, Color.red)),
    BlueGreen(BorderFactory.createBevelBorder(0, Color.blue, Color.green)),
    YellowGreen(BorderFactory.createBevelBorder(0, Color.yellow, Color.green));

    final Border border;

    BoardType(Border b) {
        border = b;
    }

    Border getBorder() {
        return border;
    }
}

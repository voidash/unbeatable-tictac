package TicTacToe.part2;

import java.awt.*;

public enum WinColors {
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    YELLOW(Color.YELLOW);

    final Color c;

    WinColors(Color c) {
        this.c = c;
    }

    Color getColor() {
        return c;
    }
}

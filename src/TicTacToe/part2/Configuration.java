package TicTacToe.part2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Objects;

public class Configuration {

    public WinColors getColor() {
        return color;
    }

    public void setColor(WinColors color) {
        this.color = color;
    }

    public BoardType getBoard() {
        return board;
    }

    public void setBoard(BoardType board) {
        System.out.println("setting");
        this.board = board;
    }

    private Configuration() {
        this.color = WinColors.YELLOW;
        this.board = BoardType.YellowRed;
    }
    public static Configuration getInstance(){
        if(conf == null){
            conf = new Configuration();
        }
        return conf;
    }

    public static String[] getAllColors(){
        return new String[]{"YELLOW","GREEN","BLUE","RED"};
    }

    public static String[] getBoardTypes(){
        return new String[]{"YellowRed","BlueGreen","YellowGreen"};
    }
    WinColors color;
    BoardType board;
    static Configuration conf=null;
}

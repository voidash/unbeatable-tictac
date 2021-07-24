package TicTacToe;

public enum Player {
    //AI is always X , person is O
    X('X',+10),
    O('O',-10),
    Blank(' ',0);

    public char asChar() {
        return asChar;
    }
    public int score() {return score;}

    private final char asChar;
    private final int score;

    Player(char asChar,int score) {
        this.asChar = asChar;
        this.score = score;
    }

}

package TicTacToe;

import java.util.Arrays;

class Board {

    public char[][] board;

    Board(){
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    Board(char[][] b){
        board = b;
    }

    boolean updateCell(char data,int row, int column){
        if(row < 3 && row >= 0 && column < 3 && column >= 0)
            if(board[row][column] == ' ') {
                board[row][column] = data;
                return true;
            }
            else{
            System.out.println(row + " " + column + " already filled can't fill there");
            return false;
            }
        else{
            System.out.println("can't update cell because out of bounds");
            return false;
        }

    }

    public void printBoard() {
        //make i row and j columns
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static public boolean canInsert(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean canInsert(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }
    public char[][] getBoard() {
        return board.clone();
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char getCellValue(int r, int c){
        return board[r][c];
    }

    public boolean canInsertToCell(int r, int c) {
        return board[r][c] == Player.Blank.asChar();
    }
}

public class TTT_model {
    Board state;
    Player activePlayer; // turn

    public boolean canInsert(){
        return state.canInsert();
    }

    public char getActivePlayerAsChar(){
        return activePlayer.asChar();
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

//    public char[][] getBoard(){
//        return state.getBoard();
//    }


    public TTT_model(Player firstPlayerToMove){
        state = new Board();
        activePlayer = firstPlayerToMove;
    }

    public char getCellValue(int r, int j){
       return state.getCellValue(r,j);
    }
    public void printBoard(){
        state.printBoard();
    }

    public char[][] getBoard(){
        return state.getBoard();
    }
    public boolean canInsertToCell(int r, int c){
       return state.canInsertToCell(r,c);
    }

    public boolean updateBoard(int row, int column){

        boolean val = state.updateCell(activePlayer.asChar(),row,column);
        //change active player every time cell is updated
        if(val) {activePlayer = activePlayer == Player.X? Player.O : Player.X;}
        return val;
    }

     public Player nextTurn(Player active) {
        return (active == Player.X) ? Player.O : Player.X;
     }

    public int getWinRow(char[][] board){
        for(int i = 0; i <3; i++){
            int sum=0;
            sum = board[i][0]+board[i][1]+board[i][2];

            if(sum == ((int)Player.X.asChar() * 3)){
                return i;
            }
            else if(sum == ((int)Player.O.asChar() * 3)){
                return i;
            }
        }
        return -1;
    }

     Player checkRow(char[][] board){
       for(int i = 0; i <3; i++){
           int sum=0;
           sum = board[i][0]+board[i][1]+board[i][2];

           if(sum == ((int)Player.X.asChar() * 3)){
               return Player.X;
           }
           else if(sum == ((int)Player.O.asChar() * 3)){
               return Player.O;
           }
       }
       return Player.Blank;
    }

    public int getWinColumn(char[][] board) {
        for(int i = 0; i <3; i++){
            int sum=0;
            sum = board[0][i]+board[1][i]+board[2][i];

            if(sum == ((int)Player.X.asChar() * 3)){
                return i;
            }
            else if(sum == ((int)Player.O.asChar() * 3)){
                return i;
            }
        }
        return -1;
    }
    Player checkColumn(char[][] board) {
        for(int i = 0; i <3; i++){
                int sum=0;
                sum = board[0][i]+board[1][i]+board[2][i];

                if(sum == ((int)Player.X.asChar() * 3)){
                    return Player.X;
                }
                else if(sum == ((int)Player.O.asChar() * 3)){
                    return Player.O;
                }
            }
            return Player.Blank;
        }

    public int checkDiagonalForWin(char[][] board){
        int leftDiagonalSum  = board[0][0] + board[1][1] + board[2][2];

        if(leftDiagonalSum == ((int)Player.X.asChar() * 3)){
            return 0;
        }
        else if(leftDiagonalSum == ((int)Player.O.asChar() * 3)){
            return 0;
        }
        int rightDiagonalSum  = board[0][2] + board[1][1] + board[2][0];
        if(rightDiagonalSum == ((int)Player.X.asChar() * 3)) {
            return 1;
        }

        else if(rightDiagonalSum == ((int)Player.O.asChar() * 3)) {
            return 1;
        }

        return -1;
    }

    Player checkDiagonal(char[][] board){
        int leftDiagonalSum  = board[0][0] + board[1][1] + board[2][2];

        if(leftDiagonalSum == ((int)Player.X.asChar() * 3)){
            return Player.X;
        }
        else if(leftDiagonalSum == ((int)Player.O.asChar() * 3)){
            return Player.O;
        }
       int rightDiagonalSum  = board[0][2] + board[1][1] + board[2][0];
       if(rightDiagonalSum == ((int)Player.X.asChar() * 3)) {
                       return Player.X;
       }

      else if(rightDiagonalSum == ((int)Player.O.asChar() * 3)) {
                   return Player.O;
      }

    return Player.Blank;
    }

     public Player checkWin(char[][] board){
        //first check row, then check column, then check diagonal
        Player row = checkRow(board);
        Player column = checkColumn(board);
        Player diagonal = checkDiagonal(board);

        if(row != Player.Blank){
            return row;
        }else if(column != Player.Blank){
            return column;
        }else if(diagonal != Player.Blank){
            return diagonal;
        }
        return Player.Blank;
     }
    // Rule 1
    public boolean checkPositionValidity(int r, int c){
       return (r<3 && r>=0 && c<3 && c>=0);
    }

    public void multiplayer(){
        bestMove(activePlayer);
    }
    public int[] getMovesByBot(){
       return bestMove(activePlayer);
    }

    public void setBoard(char[][] b){
        state.setBoard(b);
    }
    int[] bestMove(Player turn){

        int bestScore = Integer.MIN_VALUE;
        int score = 0;
        int[]  move = {-1,-1};
        char [][] board = getBoard();

        if(board[1][1] == ' ') {
            updateBoard(1,1);
            return new int[]{1,1};
        }

        for(int i = 0; i<3;i++){
            for(int j = 0;j<3;j++){
                if(board[i][j] == ' ') {
                    board[i][j] = turn.asChar();
                    score = minimax(board, 0,nextTurn(activePlayer));
                    board[i][j] = ' ';
                    if(score > bestScore){
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                        //get the move here
                    }
                }
            }
        }
        if(move[0] != -1 && move[1] != -1)
            updateBoard(move[0],move[1]);
        return move;
    }

    int minimax(char[][] board, int depth, Player turn){
        // O is always AI
        boolean max = turn == Player.X;
        Player isWinner = checkWin(board);
        if(isWinner == Player.X || isWinner == Player.O || depth == 6 || !Board.canInsert(board)) {
            return isWinner.score();
        }
            int bestScore = max ? Integer.MIN_VALUE:Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                   if(board[i][j] == ' ') {
                        board[i][j] = turn.asChar();
                        int score = minimax(board,depth+1,nextTurn(turn));
                        board[i][j] = ' ';
                        if(max) bestScore = Math.max(score,bestScore);
                        else bestScore = Math.min(score,bestScore);
                   }
                }
            }

            return bestScore;
            }

        }

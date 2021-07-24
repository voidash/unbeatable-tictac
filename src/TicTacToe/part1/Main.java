package TicTacToe.part1;
import TicTacToe.Player;
import TicTacToe.TTT_model;
import java.util.Scanner;


 class CLI {
    boolean check(TTT_model t){
        if(!t.canInsert()){
            System.out.println("Draw. Nobody won the match");
            return true;
        }
        boolean checker =  t.checkWin(t.getBoard()) == Player.Blank;
        if(!checker){
            System.out.println(t.nextTurn(t.getActivePlayer())+ " won the game");
        }
        return !checker;
    }
    int[] performInput(TTT_model t){
        System.out.println("board State");
        t.printBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Player " + t.getActivePlayerAsChar() + " enter position row,column example: 1,1 >> ");
        String pos = sc.nextLine();
        try {
            String[] d = pos.split(",");
            return new int[]{Integer.parseInt(d[0]), Integer.parseInt(d[1])};
        }catch(Exception e){
            System.out.println("Not a correct input format, should be in format row,column. example 1,2");
            return performInput(t);
        }
    }

      public void WithBot(boolean startFirst){
    // X is always AI
        if(startFirst){
            System.out.println("Player O will start First ");
        }else{
            System.out.println("Bot X will start First");
        }

       Player firstPlayer = startFirst ? Player.O:Player.X;
       TTT_model t = new TTT_model(firstPlayer);

          boolean updated = false;
          while(true){
           if(!startFirst){
               if(updated)
                   t.multiplayer();
               if(check(t))  break;
           }
           int r,c;
           int[] inp = performInput(t);
           r = inp[0];
           c = inp[1];
           if(t.checkPositionValidity(r-1,c-1)){
               r = r-1;
               c = c-1;
               updated = t.updateBoard(r,c);
               if(check(t))  break;
               if(startFirst) {
                   if(updated)
                       t.multiplayer();
                   if(check(t))  break;
               }

           }

       }
       t.printBoard();
    }

     public void singlePlayer(Player first){
        TTT_model t = new TTT_model(first);
        while(true){
            int r,c;
            int[] inp = performInput(t);
            r = inp[0];
            c = inp[1];
            if(t.checkPositionValidity(r-1,c-1)){
                r = r-1;
                c = c-1;
                t.updateBoard(r,c);
                if(check(t))  break;
            }

        }
        t.printBoard();
    }

}

public class Main{
     public static void main(String[] args){
         CLI c = new CLI();

         System.out.println("Welcome To TIC TAC TOE Game");
         System.out.println("  _______ _____ _____ _______       _____ _______ ____  ______ \n"+
                 " |__   __|_   _/ ____|__   __|/\\   / ____|__   __/ __ \\|  ____|\n"
                 + "    | |    | || |       | |  /  \\ | |       | | | |  | | |__   \n"
                 + "    | |    | || |       | | / /\\ \\| |       | | | |  | |  __|  \n"
                 + "    | |   _| || |____   | |/ ____ \\ |____   | | | |__| | |____ \n"
                 + "    |_|  |_____\\_____|  |_/_/    \\_\\_____|  |_|  \\____/|______|\n");
         for(;;) {
             System.out.println("1. Play with Bot");
             System.out.println("2. Play with friend");
             System.out.println("3. Exit");

             Scanner scan = new Scanner(System.in);
             int inp;
             try {
                 inp = scan.nextInt();
                 switch (inp) {
                     case 1 -> c.WithBot(true);
                     case 2 -> c.singlePlayer(Player.X);
                 }
                 if(inp == 3){
                    break;
                 }
             } catch (Exception e) {
                 System.out.println("Insert 1 or 2 . it doesn't understand anything other than that");
             }
         }
     }
 }

package chess;
import java.util.Scanner;
import java.io.IOException;
public class Chess implements Values{
      static Scanner scanner = new Scanner(System.in);
      
    public static void main(String[] args) throws ClassNotFoundException {
        
        boolean gameRun = true;
        String doSave;
        Board board;        
        
//        System.out.println("Load or new game?");
//        
//        boolean doLoad = scanner.nextLine().equals("load");
        board = new Board(false);
        
//        try{
//            if(doLoad) {
//                board.load(board.file);
//                System.out.println("loaded");
//            }
//            else System.out.println("not loaded");
//        }
//        catch(IOException e){
//            System.err.println(e);
//        }
        
        //use input to grab player actions add a save and quit function later.
        //based on the odd or even of the turn timer determine player turn
        while(gameRun == true){
            System.out.println("turn:" + Piece.turn);
             Board.displayBoard();
             
             if(Piece.turn % 2 == 0){System.out.println("white player turn");}
             else{System.out.println("black player turn");}

            System.out.println("Provide x of piece you would like to move");
            Board.selection[0]=scanner.nextInt()-1;

            System.out.println("Provide y of piece you would like to move");
            Board.selection[1]=scanner.nextInt()-1;

            System.out.println("Provide x of where you would like to move");
            Board.moveTo[0]=scanner.nextInt()-1;

            System.out.println("Provide y of where you would like to move");
            Board.moveTo[1]=scanner.nextInt()-1;

            if(Piece.turn % 2 == 0){
                //team is white
                if (Board.coordinates[Board.selection[0]] [Board.selection[1]].team.equals(White)){
                    Board.coordinates[Board.selection[0]] [Board.selection[1]].moveTO(Board.moveTo[0], Board.moveTo[1]);
                }
            }
            else {
                 //team is black
                if (Board.coordinates[Board.selection[0]] [Board.selection[1]].team.equals(White)){
                    Board.coordinates[Board.selection[0]] [Board.selection[1]].moveTO(Board.moveTo[0], Board.moveTo[1]);
                }
            }
//            System.out.println("save or continue?");
//             doSave = scanner.next();
//             if(doSave.endsWith("save")){
//             try{
//                board.save(board.file);
//                System.out.println("Saved");
//            }
//            catch(IOException e){
//                System.err.println(e);
//                }
//            }
//             else System.out.println("did not save");
            Piece.turn++;
            }
        }
    }
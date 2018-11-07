package chess;
import java.util.Scanner;
import java.io.IOException;
public class Chess {
      static Scanner scanner = new Scanner(System.in);
      
    public static void main(String[] args) throws ClassNotFoundException {
        
        boolean gameRun = true;
        int posX;
        int posY;
        int movX;
        int movY;
        Board board;        
        
        System.out.println("Load or new game?");
        
        boolean doLoad = scanner.nextLine().equals("load");
        board = new Board(doLoad);
        
        try{
            if(doLoad) {
                board.load(board.file);
                System.out.println("loaded");
            }
            else System.out.println("not loaded");
        }
        catch(IOException e){
            System.err.println(e);
        }
        
        //use input to grab player actions add a save and quit function later.
        //based on the odd or even of the turn timer determine player turn
        System.out.println("White player moves first");
        while(gameRun == true){
             Board.displayBoard();
             if(Piece.turn % 2 == 0){System.out.println("white player turn");}
             else{System.out.println("black player turn");}

            System.out.println("Provide x of piece you would like to move");
            posX=scanner.nextInt()-1;

            System.out.println("Provide y of piece you would like to move");
            posY=scanner.nextInt()-1;

            System.out.println("Provide x of where you would like to move");
            movX=scanner.nextInt()-1;

            System.out.println("Provide y of where you would like to move");
            movY=scanner.nextInt()-1;

            if(Piece.turn % 2 == 0){
                 //team is white
                 for (WhitePiece whitePiece : board.whitePieces) {
                     if (whitePiece.x == posX && whitePiece.y == posY) whitePiece.moveTO(movX, movY);
                 }
            }
            else {
                 //team is black
                 for (BlackPiece blackPiece : board.blackPieces) {
                     if (blackPiece.x == posX && blackPiece.y == posY) blackPiece.moveTO(movX, movY);
                }
            }
            try{
                board.save(board.file);
            }
            catch(IOException e){
                System.err.println(e);
            }
            Piece.turn++;
            }
        }
    }
package chess;
import java.util.Scanner;
public class Chess {
      static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int turnCount = 0;
        boolean gameRun = true;
        int posX;
        int posY;
        int movX;
        int movY;
        Board board = new Board();
        
       
        
        //use input to grab player actions add a save and quit function later.
        //based on the odd or even of the turn timer determine player turn
        System.out.println("White player moves first");
        while(gameRun == true){
            
        //System.out.println(board.whiteRook[0].x);
        //System.out.println(board.whiteRook[0].y);
        
         board.displayBoard();
         if(turnCount % 2 == 0){System.out.println("white player turn");}
         else{System.out.println("black player turn");}
         
        System.out.println("Provide x of piece you would like to move");
        posX=scanner.nextInt()-1;
        
        System.out.println("Provide y of piece you would like to move");
        posY=scanner.nextInt()-1;
        
        System.out.println("Provide x of where you would like to move");
        movX=scanner.nextInt()-1;
        
        System.out.println("Provide y of where you would like to move");
        movY=scanner.nextInt()-1;
        
         if(turnCount % 2 == 0){
         //team is white

         if(board.whiteKing.x == posX && board.whiteKing.y == posY){
        board.whiteKing.moveTO(movX, movY);
        }
         if(board.whiteQueen.x == posX && board.whiteQueen.y == posY){
        board.whiteQueen.moveTO(movX, movY);
        }
         for (int i = 0; i < 8; i++){
             
         if(i <= 1){      
        if(board.whiteRook[i].x == posX && board.whiteRook[i].y == posY){
        board.whiteRook[i].moveTO(movX, movY);
        }
         
         if(board.whiteBishop[i].x == posX && board.whiteBishop[i].y == posY){
        board.whiteBishop[i].moveTO(movX, movY);
        }

         if(board.whiteKnight[i].x == posX && board.whiteKnight[i].y == posY){
        board.whiteKnight[i].moveTO(movX, movY);
        }
        }
         if(board.whitePawns[i].x == posX && board.whitePawns[i].y == posY){
         board.whitePawns[i].moveTO(movX, movY);
         }
         }
         }
         else {
           //team is black 
           
           if(board.blackKing.x == posX && board.blackKing.y == posY){
        board.blackKing.moveTO(movX, movY);
        }
         if(board.blackQueen.x == posX && board.blackQueen.y == posY){
        board.blackQueen.moveTO(movX, movY);
        }
         for (int i = 0; i < 8; i++){
             
         if(i <= 1){      
        if(board.blackRook[i].x == posX && board.blackRook[i].y == posY){
        board.blackRook[i].moveTO(movX, movY);
        }
         
         if(board.blackBishop[i].x == posX && board.blackBishop[i].y == posY){
        board.blackBishop[i].moveTO(movX, movY);
        }

         if(board.blackKnight[i].x == posX && board.blackKnight[i].y == posY){
        board.blackKnight[i].moveTO(movX, movY);
        }
        }
         if(board.blackPawns[i].x == posX && board.blackPawns[i].y == posY){
         board.blackPawns[i].moveTO(movX, movY);
         }
         }
         }
         turnCount++;
        }
        }
    }
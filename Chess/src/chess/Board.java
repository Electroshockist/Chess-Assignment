package chess;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Board {
    public String file = "chess.ser";
    
    BlackPiece blackPieces[] = new BlackPiece[16];    
    WhitePiece whitePieces[] = new WhitePiece[16];
    
    public Board(boolean doLoad) {
        if (!doLoad){
            setDefaults();
            try{
                save(file);
            }
            catch(IOException e){
                System.err.println(e);
            }
        }
    }  
    
    private void setDefaults(){        
        blackPieces[0] = new BlackPiece(0, 0, Piece.rook);
        blackPieces[1] = new BlackPiece(1, 0, Piece.knight);
        blackPieces[2] = new BlackPiece(2, 0, Piece.bishop); 
        blackPieces[3] = new BlackPiece(3, 0, Piece.queen);
        blackPieces[4] = new BlackPiece(4,0, Piece.king);
        blackPieces[5] = new BlackPiece(5, 0,Piece.bishop);                
        blackPieces[6] = new BlackPiece(6, 0, Piece.knight);
        blackPieces[7] = new BlackPiece(7, 0, Piece.rook);  
        
        whitePieces[0] = new WhitePiece(0, 7, Piece.rook);
        whitePieces[1] = new WhitePiece(1, 7, Piece.knight);
        whitePieces[2] = new WhitePiece(2, 7, Piece.bishop); 
        whitePieces[3] = new WhitePiece(3, 7, Piece.queen);
        whitePieces[4] = new WhitePiece(4,7, Piece.king);
        whitePieces[5] = new WhitePiece(5, 7,Piece.bishop);                
        whitePieces[6] = new WhitePiece(6, 7, Piece.knight);
        whitePieces[7] = new WhitePiece(7, 7, Piece.rook);
        
        for (int i = 0; i < Piece.board.length; i++){
            
            blackPieces[i + 8] = new BlackPiece(i, 1, Piece.pawn);
            whitePieces[i + 8] = new WhitePiece(i, 6, Piece.pawn);
        }
    }
    
    public void save(String whiteOutput) throws IOException{
        try (
            //open output stream
            ObjectOutputStream out  = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(whiteOutput)))) {
            
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 16; j++){
                    if(i == 0)out.writeObject(whitePieces[j]);
                    else out.writeObject(blackPieces[j]);
                }
            }
        }
    }
    
    public void load(String input) throws IOException, ClassNotFoundException{
        try (
            //open input stream
            ObjectInputStream in  = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(input)))) {
            
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 16; j++){
                    if(i == 0) {
                        whitePieces[j] = (WhitePiece)in.readObject();
                        whitePieces[j].moveTO(whitePieces[j].x, whitePieces[j].y);
                    }
                    else {
                        blackPieces[j] = (BlackPiece)in.readObject();
                        blackPieces[j].moveTO(blackPieces[j].x, blackPieces[j].y);
                    }
                }
            }
        }
    }    
    
    public static void displayBoard(){
        
        boolean whiteSquare = true;
        System.out.println(" 1   2  3   4  5   6  7   8");
        for (int l = 0; l < Piece.board.length; l++) {
            System.out.print(l+1);
            for (int w = 0; w < Piece.board[l].length; w++) {

                if (Piece.board[w][l] == null) {
                    if (whiteSquare) System.out.print(" □ ");
                    else System.out.print(" ■ ");
                } else {
                    System.out.print(" " + Piece.board[w][l] + " ");
                }
                //alternates empty grid
                whiteSquare = !whiteSquare;
            }            
            //restets white squares at end of line to create alternating grid
            whiteSquare = !whiteSquare;
            System.out.println();
        }
    }
    
}

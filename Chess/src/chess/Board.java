package chess;

import chess.Pieces.Bishop;
import chess.Pieces.King;
import chess.Pieces.Knight;
import chess.Pieces.Pawn;
import chess.Pieces.Queen;
import chess.Pieces.Rook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class Board {
    public String file = "chess.ser";
    
    Pawn pawns[] = new Pawn[16];
    Rook rooks[] = new Rook[4];
    Knight knights[] = new Knight[4];
    Bishop bishops[] = new Bishop[4];
    King kings[] = new King[2];
    Queen queens[] = new Queen[2];
    
    
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
        rooks[0] = new Rook(0, 0, Values.Black);
        knights[0] = new Knight(1, 0, Values.Black);
        bishops[0] = new Bishop(2, 0, Values.Black); 
        queens[0] = new Queen(3, 0, Values.Black);
        kings[0] = new King(4, 0, Values.Black);
        bishops[1] = new Bishop(5, 0, Values.Black);                
        knights[1] = new Knight(6, 0, Values.Black);
        rooks[1] = new Rook(7, 0, Values.Black);  
        
        rooks[0] = new Rook(0, 7, Values.White);
        knights[1] = new Knight(1, 7, Values.White);
        bishops[2] = new Bishop(2, 7, Values.White); 
        queens[3] = new Queen(3, 7, Values.White);
        kings[4] = new King(4, 7, Values.White);
        bishops[5] = new Bishop(5, 7,Values.White);                
        knights[6] = new Knight(6, 7, Values.White);
        rooks[7] = new Rook(7, 7, Values.White);
        
        for (int i = 0; i < Piece.board.length; i++){            
            pawns[i + 8] = new Pawn(i, 1, Values.Black);
            pawns[i + 8] = new Pawn(i, 6, Values.White);
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

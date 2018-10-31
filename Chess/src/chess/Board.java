package chess;
public class Board {
    BlackPiece blackPawns[] = new BlackPiece[8];
    BlackPiece blackRook[] = new BlackPiece[2];
    BlackPiece blackKnight[] = new BlackPiece[2];
    BlackPiece blackBishop[] = new BlackPiece[2];
    BlackPiece blackQueen;
    BlackPiece blackKing;
    
    WhitePiece whitePawns[] = new WhitePiece[8];
    WhitePiece whiteRook[] = new WhitePiece[2];
    WhitePiece whiteKnight[] = new WhitePiece[2];
    WhitePiece whiteBishop[] = new WhitePiece[2];
    WhitePiece whiteQueen;
    WhitePiece whiteKing;
    
    public Board(){
        setBlacks();
        setWhites();
        setPawns();
        
    }  
    
    private void setBlacks(){        
        blackRook[0] = new BlackPiece(0, 0, Piece.rook);
        blackKnight[0] = new BlackPiece(1, 0, Piece.knight);
        blackBishop[0] = new BlackPiece(2, 0, Piece.bishop); 
        blackQueen = new BlackPiece(3, 0, Piece.queen);
        blackKing = new BlackPiece(4,0, Piece.king);
        blackBishop[1] = new BlackPiece(5, 0,Piece.bishop);                
        blackKnight[1] = new BlackPiece(6, 0, Piece.knight);
        blackRook[1] = new BlackPiece(7, 0, Piece.rook);
        
    }
    private void setWhites(){        
        whiteRook[0] = new WhitePiece(0, 7, Piece.rook);
        whiteKnight[0] = new WhitePiece(1, 7, Piece.knight);
        whiteBishop[0] = new WhitePiece(2, 7, Piece.bishop); 
        whiteQueen = new WhitePiece(3, 7, Piece.queen);
        whiteKing = new WhitePiece(4,7, Piece.king);
        whiteBishop[1] = new WhitePiece(5, 7,Piece.bishop);                
        whiteKnight[1] = new WhitePiece(6, 7, Piece.knight);
        whiteRook[1] = new WhitePiece(7, 7, Piece.rook);
    }
    private void setPawns(){
        for (int i = 0; i < Piece.board.length; i++){
            blackPawns[i] = new BlackPiece(i, 1, Piece.pawn);
            whitePawns[i] = new WhitePiece(i, 6, Piece.pawn);
        }
    }
    
    public static void displayBoard(){
        
        boolean whiteSquare = true;
        System.out.println("-1---2--3---4--5---6--7---8");
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

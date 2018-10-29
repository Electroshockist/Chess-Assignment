package chess;
public class Board {
    BlackPiece blackRook[] = new BlackPiece[2];
    BlackPiece blackKnight[] = new BlackPiece[2];
    BlackPiece blackBishop[] = new BlackPiece[2];
    BlackPiece blackQueen;
    BlackPiece blackKing;
    
    WhitePiece whiteRook[] = new WhitePiece[2];
    WhitePiece whiteKnight[] = new WhitePiece[2];
    WhitePiece whiteBishop[] = new WhitePiece[2];
    WhitePiece whiteQueen;
    WhitePiece whiteKing;
    
    public Board(){
        blackRook[0] = new BlackPiece(0, 7, Piece.rook);
        blackKnight[0] = new BlackPiece(1, 7, Piece.knight);
        blackBishop[0] = new BlackPiece(2, 7, Piece.bishop); 
        blackQueen = new BlackPiece(3, 7, Piece.queen);
        blackKing = new BlackPiece(4,7, Piece.king);
        blackBishop[1] = new BlackPiece(5, 7,Piece.bishop);                
        blackKnight[1] = new BlackPiece(6, 7, Piece.knight);
        blackRook[1] = new BlackPiece(7, 7, Piece.rook);
        
    }    
    
    public static void displayBoard(){
        boolean whiteSquare = true;
        for (int l = 0; l <Piece.board.length; l++) {
            for (int w = 0; w <Piece.board[l].length; w++) {
                if (Piece.board[l][w] == null) {
                    if (whiteSquare) System.out.print(" □ ");
                    else System.out.print(" ■ ");
                } else {             
                }
                whiteSquare = !whiteSquare;
            }
            whiteSquare = !whiteSquare;
            System.out.println();
        }
    }
    
}

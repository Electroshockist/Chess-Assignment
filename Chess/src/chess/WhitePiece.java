package chess;
public class WhitePiece extends Piece {
    
    public WhitePiece(int x, int y, String type){        
        team = "White";
        this.x = x;
        this.y = y;
        switch (type){
            case Piece.pawn:
                symbol = "♙";
                break;
            case Piece.rook:
                symbol = "♖";
                break;
            case Piece.knight:
                symbol = "♘";
                break;
            case Piece.bishop:
                symbol = "♗";
                break;
            case Piece.king:
                symbol = "♔";
                break;
            case Piece.queen:
                symbol = "♕";
                break;
        }
        
        board[x][y] = symbol;
    }
    
}

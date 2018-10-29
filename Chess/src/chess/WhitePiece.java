package chess;
public class WhitePiece extends Piece {
    
    public WhitePiece(int x, int y, String type){
        team = "White";        
        this.x = x;
        this.y = y;
        Piece.board[x][y] = team;
    }
    
}

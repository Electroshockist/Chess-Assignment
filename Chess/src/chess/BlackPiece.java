package chess;
public class BlackPiece extends Piece {
    
    public BlackPiece(int x, int y, String type){        
        team = "Black";
        this.x = x;
        this.y = y;
        Piece.board[x][y] = team;
    }
    
}

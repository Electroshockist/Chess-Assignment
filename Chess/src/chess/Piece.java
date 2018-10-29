package chess;
public abstract class Piece implements Coordinates{      
    //piece position
    public int x; 
    public int y;
    //piece type and team
    public String symbol, team;
    
    public static final String pawn = "pawn";
    public static final String rook = "rook";
    public static final String knight = "knight";
    public static final String bishop = "bishop";
    public static final String king = "king";
    public static final String queen = "queen";
    
    public boolean canMoveTo(int x_, int y_){
        return board[x][y] == null;
    }
    public void moveTO(int x, int y){
        if (canMoveTo(x, y)){
            //update position
            board[this.x][this.y] = null;
            board[x][y] = team;
            this.x = x;
            this.y = y;
        }
    }
}

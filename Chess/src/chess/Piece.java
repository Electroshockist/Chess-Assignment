package chess;

import java.io.Serializable;

public abstract class Piece implements Coordinates, Values, Serializable{      
    //piece position
    public int x; 
    public int y;
    //piece type and team
    public String symbol, team, type;
    
    public static int turn;
    
    public Piece(int x_, int y_, String team_){
        x = x_;
        y = y_;
        
        team = team_;
        
        switch(team){
            case White:
                switch(type){
                    case pawn:
                        symbol = "♙";
                        break;
                    case rook:
                        symbol = "♖";
                        break;
                    case knight:
                        symbol = "♘";
                        break;
                    case bishop:
                        symbol = "♗";
                        break;
                    case king:
                        symbol = "♔";
                        break;
                    case queen:
                        symbol = "♕";
                        break;
                }
            break;
            
            case Values.Black:
                switch (type){                    
                    case pawn:
                        symbol = "♟";
                        break;
                    case rook:
                        symbol = "♜";
                        break;
                    case knight:
                        symbol = "♞";
                        break;
                    case bishop:
                        symbol = "♝";
                        break;
                    case king:
                        symbol = "♚";
                        break;
                    case queen:
                        symbol = "♛";
                        break;
                }
            break;
        }
        
        board[x][y] = symbol;
    }
    
    public boolean canMoveTo(int x_, int y_){
        return board[x_][y_] == null;
    }
    
    public void moveTO(int x, int y){
        if (canMoveTo(x, y)){
            //update position
            board[this.x][this.y] = null;
            board[x][y] = symbol;
            this.x = x;
            this.y = y;
        }
    }
}

package chess.Pieces;

import chess.Piece;

public class Queen extends Piece{
    public Queen(int x_, int y_, String team_){
        super(x_, y_, team_);
        type = queen;
    }
}

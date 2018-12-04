package chess.Pieces;

import chess.Piece;

public class Bishop extends Piece{
    public Bishop(int x_, int y_, String team_){
        super(x_, y_, team_);
        type = bishop;
    }
}

package chess.Pieces;

import chess.Piece;

public class King extends Piece{
    public King(int x_, int y_, String team_){
        super(x_, y_, team_);
        type = king;
    }
}
package chess.Pieces;

import chess.Piece;

public class Rook extends Piece{
    public Rook(int x_, int y_, String team_){
        super(x_, y_, team_);
        type = rook;
    }
}
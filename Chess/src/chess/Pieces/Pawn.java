package chess.Pieces;

import chess.Piece;

public class Pawn extends Piece{
    public Pawn(int x_, int y_, String team_){
        super(x_, y_, team_);
        type = pawn;
    }
}

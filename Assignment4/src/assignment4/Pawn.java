package assignment4;

import java.util.ArrayList;
import static assignment4.Constants.*;
public class Pawn extends Piece {
    public boolean promoted;

    public Pawn(Position position, Constants.PieceColor color) {
        super(position, color);
        this.promoted = false;
        this.my_mark= 'P';
    }

    @Override
    public char getMarker()
    {
        return 'P';
    }

    public boolean isPromoted()
    {
        return promoted;
    }

    public void setPromoted(boolean promoted)
    {
        this.promoted = promoted;
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        try {


            ArrayList<Move> possible_Moves = new ArrayList<>();
            Position current_Position = this.getPosition();
            int row_pos = current_Position.getRow();
            int col_Pos = current_Position.getCol();
            int num_Rows = board.getBoardSize();
            int num_Cols = board.getBoardSize();
            int color_Direction = (getColorMarker(this.getColor()) == 'B') ? 1 : -1; // Black moves down, White moves up

            // Check forward movement
            int forwardRow = row_pos + color_Direction;
            if (forwardRow >= 0 && forwardRow < num_Rows) {
                Position forwardPosition = new Position(forwardRow, col_Pos);
                if (board.getPiece(forwardPosition) == null) {
                    possible_Moves.add(new Move(current_Position, forwardPosition));
                }
            }

            // Check diagonal captures
            if (col_Pos > 0) {
                Position leftDiagonalPosition = new Position(forwardRow, col_Pos - 1);
                Piece leftDiagonalPiece = board.getPiece(leftDiagonalPosition);
                if (leftDiagonalPiece != null && leftDiagonalPiece.getColor() != this.getColor()) {
                    possible_Moves.add(new Move(current_Position, leftDiagonalPosition));
                }
            }

            if (col_Pos < num_Cols - 1) {
                Position rightDiagonalPosition = new Position(forwardRow, col_Pos + 1);
                Piece rightDiagonalPiece = board.getPiece(rightDiagonalPosition);
                if (rightDiagonalPiece != null && rightDiagonalPiece.getColor() != this.getColor()) {
                    possible_Moves.add(new Move(current_Position, rightDiagonalPosition));
                }
            }



            return possible_Moves;
        }
        catch  (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return  super.toString();

    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o== null || getClass() != o.getClass()) {
            return false;
        }
        Pawn new_Pwan = (Pawn) o;
        return this.getPosition().equals(new_Pwan.getPosition()) &&
                this.getColor() == new_Pwan.getColor();
    }
}

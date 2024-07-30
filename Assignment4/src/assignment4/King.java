package assignment4;

import java.util.ArrayList;
import static assignment4.Constants.*;

public class King extends Piece {
    public King(Position position, PieceColor color) {
        super(position, color);
        this.my_mark= 'K';
    }

    @Override
    public char getMarker()
    {
        return 'K';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possible_Moves = new ArrayList<>();
        Position current_Position = this.getPosition();
        int row_pos = current_Position.getRow();
        int col_pos = current_Position.getCol();
        int num_rows = board.getBoardSize();
        int num_cols = board.getBoardSize();

        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < rowOffsets.length; i++) {
            int new_Row = row_pos + rowOffsets[i];
            int new_Col = col_pos + colOffsets[i];

            if (new_Row >= 0 && new_Row < num_rows && new_Col >= 0 && new_Col < num_cols) {
                Position newPosition = new Position(new_Row, new_Col);
                Piece piece = board.getPiece(newPosition);

                if (piece == null || piece.getColor() != this.getColor()) {
                    Move newMove = new Move(current_Position, newPosition);
                    possible_Moves.add(newMove);
                }
            }
        }

        return possible_Moves;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
    public boolean equals(Object o) {
        //check if the same object
        if (this == o) {
            return true;
        }
        if (o== null || getClass() != o.getClass()) {
            return false;
        }
        King new_King = (King) o;
        boolean b;
        b=this.getPosition().equals(new_King.getPosition()) &&
                this.getColor() == new_King.getColor();
        return b;
    }
}
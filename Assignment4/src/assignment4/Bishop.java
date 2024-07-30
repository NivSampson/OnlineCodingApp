package assignment4;

import java.util.ArrayList;
import static assignment4.Constants.*;
public class Bishop extends Piece {
    public Bishop(Position position, PieceColor color) {
        super(position, color);
        this.my_mark= 'B';
    }

    @Override
    //the name of the object
    public char getMarker() {
        return 'B';
    }


    public ArrayList<Move> getPossibleMoves(Board board) {

        ArrayList<Move> possible_Moves = new ArrayList<>();
        Position curr_Position = this.getPosition();

        int[] row_sets = {-1, -1, 1, 1};
        int[] col_sets = {-1, 1, -1, 1};
        int row_Pos = curr_Position.getRow();
        int col_Pos = curr_Position.getCol();
        int num_Rows = board.getBoardSize();
        int num_Cols = board.getBoardSize();

        for (int j = 0; j < row_sets.length; j++) {
            int new_Row = row_Pos + row_sets[j];
            int new_Col = col_Pos + col_sets[j];
            //check if thd coarniate in the size

            while (new_Row >= 0 && new_Row < num_Rows && new_Col >= 0 && new_Col < num_Cols) {
                Position newPosition = new Position(new_Row, new_Col);
                Piece piece = board.getPiece(newPosition);

                if (piece == null || piece.getColor() != this.getColor()) {
                    Move newMove = new Move(curr_Position, newPosition);
                    possible_Moves.add(newMove);
                    if (piece!=null){
                        break;
                    }


                } else {
                    break;
                }

                new_Row += row_sets[j];
                new_Col += col_sets[j];
            }
        }

        return possible_Moves;
    }

    @Override
    public String toString() {

        return super.toString();
    }

    public boolean equals(Object o) {
        //check if the same object
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bishop new_Bishop = (Bishop) o;
        boolean b;
        b=this.getPosition().equals(new_Bishop.getPosition()) &&
                this.getColor() == new_Bishop.getColor();
        return b;
    }


}
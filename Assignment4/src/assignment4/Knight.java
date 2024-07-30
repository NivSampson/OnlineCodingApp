package assignment4;

import java.util.ArrayList;
import static assignment4.Constants.PieceColor;

public class Knight extends Piece {
    public Knight(Position position, PieceColor color) {
        super(position, color);
        this.my_mark= 'N';
    }

    @Override
    public char getMarker() {
        return 'N';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Position currentPosition = getPosition();

//check all the moves of the king with the coarinate
        int[][] directions = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];

            int current_Row = currentPosition.getRow() + dx;
            int current_Col = currentPosition.getCol() + dy;

            Position nextPosition = new Position(current_Row, current_Col);


            if (board.ValidPosition(nextPosition)) {
                Piece nextPiece = board.getPiece(nextPosition);


                if (nextPiece == null || nextPiece.getColor() != getColor()) {
                    possibleMoves.add(new Move(currentPosition, nextPosition));
                }
            }
        }

        return possibleMoves;
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
        if (o== null || getClass() != o.getClass()) {
            return false;
        }
        Knight new_Knight = (Knight) o;
        boolean b;
        b=this.getPosition().equals(new_Knight.getPosition()) &&
                this.getColor() == new_Knight.getColor();
        return b;
    }
}
package assignment4;

import java.util.ArrayList;
import static assignment4.Constants.*;

public class Tank extends Piece {
    public boolean canShoot;
    public int cooldown;

    public Tank(Position position, PieceColor color) {
        super(position, color);
        this.canShoot = true;
        this.cooldown = 0;
        this.my_mark='T';
    }

    @Override
    public char getMarker()
    {
        return 'T';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Position currentPosition = getPosition();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];

            int currentRow = currentPosition.getRow();
            int currentCol = currentPosition.getCol();

            while (true) {
                currentRow += dx;
                currentCol += dy;
                Position nextPosition = new Position(currentRow, currentCol);

                if (!board.ValidPosition(nextPosition)) {
                    break;
                }
                Piece nextPiece = board.getPiece(nextPosition);

                if (nextPiece == null) {
                    possibleMoves.add(new Move(currentPosition, nextPosition));
                } else if (nextPiece.getColor() != getColor()) {

                    possibleMoves.add(new Move(currentPosition, nextPosition));

                } else {
                    break;
                }
            }
        }
        return possibleMoves;
    }



    public int getCooldown() {
        return cooldown;

    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o== null || getClass() != o.getClass()) {
            return false;
        }
        Tank new_Thank = (Tank) o;
        boolean b;
        b=this.getPosition().equals(new_Thank.getPosition()) &&
                this.getColor() == new_Thank.getColor()&&this.cooldown == new_Thank.cooldown;
        return b;
    }

}
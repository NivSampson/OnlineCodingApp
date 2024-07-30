package assignment4;

import java.util.Objects;

public class Move {
    public Position my_startPos;
    public Position my_endPos;

    public Move(Position startPos, Position endPos) {
        this.my_startPos = startPos;
        this.my_endPos = endPos;
    }

    public Position getStartPos() {
        return my_startPos;
    }

    public Position getEndPos() {
        return my_endPos;
    }




    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Move otherMove = (Move) obj;
        boolean b;
        b=my_startPos.equals(otherMove.my_startPos) &&
                my_endPos.equals(otherMove.my_endPos) &&
                Objects.equals(my_endPos, otherMove.my_endPos);

        return b;
    }
    public void updateBoard(Board board) {

        board.updatePosition(my_startPos, my_endPos);

    }



}

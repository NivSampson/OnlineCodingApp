package assignment4;
import static assignment4.Constants.*;
import java.util.ArrayList;
public abstract class Piece
{
    public Position my_position;
    public    PieceColor my_color;

    public char my_mark;

    Piece(Position position,
          PieceColor color)
    {
        this. my_position=position;
        this.my_color=color;
        
    }

    public abstract char getMarker();
    public abstract ArrayList<Move> getPossibleMoves(Board board);

    public void setPosition(Position position)
    {
        this. my_position = position;
    }
    public PieceColor getColor()
    {
        return  this.my_color;
    }
    public Position getPosition()
    {
        return this. my_position;
    }
    //who to print the piece
    public String toString() {
        char a =getMarker();
        int x =my_position.getRow();
        int y =my_position.getCol();
        return  a+this.my_position.toString()+this.my_color.toString().charAt(0);

    }
    public abstract  boolean equals(Object o);


}

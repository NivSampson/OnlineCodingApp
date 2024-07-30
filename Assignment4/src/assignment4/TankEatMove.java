package assignment4;

public class TankEatMove extends Move {
    public Position enamy;


    public TankEatMove(Position startPos, Position endPos) {
        super(startPos, endPos);
        this.enamy=null ;
    }
    public TankEatMove(Position startPos, Position endPos, Position enamy) {
        super(startPos, endPos);
        this.enamy=enamy;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TankEatMove))
            return false;
        return super.equals(o);
    }
    public String toString() {
        return super.toString();
    }
    public int hashCode() {
        return super.hashCode();
    }



}
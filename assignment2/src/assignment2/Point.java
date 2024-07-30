package assignment2;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void shift(double xShift, double yShift) {
        this.x += xShift;
        this.y += yShift;
    }

    public double distance(Point other) {
        return Math.hypot(Math.abs(this.x - other.x), Math.abs(this.y - other.y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return (point.x == x && point.y == y);
    }

    @Override
    public String toString() {
        return "<" + x + "," + y + ">";
    }
}

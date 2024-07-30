package assignment2;

import java.util.Arrays;

public class Triangle extends Polygon {
    public Triangle(Point[] points, String name) {
        super(points, name);
    }

    @Override
    public double calcArea() {
        Point p1 = this.getPointAt(0);
        double px1 = p1.getX();
        double py1 = p1.getY();
        Point p2 = this.getPointAt(1);
        double px2 = p2.getX();
        double py2 = p2.getY();
        Point p3 = this.getPointAt(2);
        double px3 = p3.getX();
        double py3 = p3.getY();
        return 0.5 * Math.abs(((px1 * py2) + (px2 * py3) + (px3 * py1)) - ((py1 * px2) + (py2 * px3) + (py3 * px1)));


    }

    @Override
    public boolean equals(Object other) {
        if(this==other){
            return true;
        }

        if(other!=null && this.getClass() == other.getClass()){
            Triangle t=(Triangle) other;
            int count=0;
            for(int i=0;i <= this.getNumOfPoints()-1;i++){
                for (int j=0;j <= t.getNumOfPoints()-1;j++){
                    if (this.getPointAt(i).equals(t.getPointAt(j))){
                        count++;
                        break;
                    }
                }
            }
            return (count==3 && this.getName().equals(t.getName()));
        }


        return false;
    }


}

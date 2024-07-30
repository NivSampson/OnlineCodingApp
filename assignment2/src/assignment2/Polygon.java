package assignment2;

import java.util.Arrays;

public abstract class Polygon extends Shape {
    private Point[] points;
    private int accessCounter;

    public Polygon(Point[] points, String name)
    {
        this.setName(name);
        this.points=points;
    }

    public Point getPointAt(int index) {
        accessCounter++;
        return new Point(points[index]);
    }

    public int getAccessCounter()
    {
        return accessCounter;
    }

    public int getNumOfPoints()
    {
        return points.length;
    }

    @Override
    public double calcCircumference()
    {
        if (getNumOfPoints()==3)
        {
            double x1= points[0].getX();
            double x2= points[1].getX();
            double x3= points[2].getX();
            double y1= points[0].getY();
            double y2= points[1].getY();
            double y3= points[2].getY();
            double rib1= Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            double rib2= Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
            double rib3= Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
            return rib1+rib2+rib3;
        }
        if (getNumOfPoints()==4){
            double x1= points[0].getX();
            double x2= points[1].getX();
            double x3= points[2].getX();
            double x4= points[2].getX();
            double y1= points[0].getY();
            double y2= points[1].getY();
            double y3= points[2].getY();
            double y4= points[2].getY();
            double rib1= Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
            double rib2= Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
            double rib3= Math.sqrt(Math.pow((x4 - x3), 2) + Math.pow((y4 - y3), 2));
            double rib4= Math.sqrt(Math.pow((x1 - x4), 2) + Math.pow((y1 - y4), 2));
            return  rib1+rib2+rib3 +rib4;
        }
        return 0;

    }

    @Override
    public double getLeftMostX() {
        if (getNumOfPoints() == 3) {
            double x1 = points[0].getX();
            double x2 = points[1].getX();
            double x3 = points[2].getX();
            if (x1 <= x2 && x1 <= x3) {
                return x1;
            }
            if (x2 <= x1 && x2 <= x3) {
                return x2;
            }
            if (x3 <= x1 && x3 <= x2) {
                return x3;

            }

        }
        if (getNumOfPoints() == 4) {
            double x1 = points[0].getX();
            double x2 = points[1].getX();
            double x3 = points[2].getX();
            double x4 = points[2].getX();
            if (x1 <= x2 && x1 <= x3 && x1 <= x4) {
                return x1;
            }
            if (x2 <= x1 && x2 <= x3 && x2 <= x4) {
                return x2;
            }
            if (x3 <= x2 && x3 <= x1 && x3 <= x4) {
                return x3;
            }
            if (x4 <= x2 && x4 <= x3 && x4 <= x1) {
                return x4;
            }


        }
        return 0;
    }

    @Override
    public double getUpperMostY()
    {
        if (getNumOfPoints() == 3) {
            double y1 = points[0].getY();
            double y2 = points[1].getY();
            double y3 = points[2].getY();
            if (y1 >= y2 && y1 >= y3) {
                return y1;
            }
            if (y2 >= y1 && y2 >= y3) {
                return y2;
            }
            if (y3 >= y1 && y3 >= y2) {
                return y3;

            }

        }
        if (getNumOfPoints() == 4) {
            double y1 = points[0].getY();
            double y2 = points[1].getY();
            double y3 = points[2].getY();
            double y4 = points[2].getY();
            if (y1 >= y2 && y1 >= y3 && y1 >= y4) {
                return y1;
            }
            if (y2 >= y1 && y2 >= y3 && y2 >= y4) {
                return y2;
            }
            if (y3 >= y2 && y3 >= y1 && y3 >= y4) {
                return y3;
            }
            if (y4 >= y2 && y4 >= y3 && y4 >= y1) {
                return y4;
            }
        }
        return 0;
    }

    @Override
    public void shift(double xShift, double yShift)
    {
        for(int i=0 ; i<this.getNumOfPoints();i++){

            this.points[i].shift(xShift,yShift);


        }
    }

    @Override
    public boolean equals(Object other) {
        boolean bool = true;
        if (getNumOfPoints() == 3) {
            Point p1 = points[0];
            Point p2 = points[1];
            Point p3 = points[2];
            Polygon s = ((Polygon) other);
            if (this.getName().equals(((Polygon) other).getName())){
                return false;
            }
            Point s1 = ((Polygon) other).points[0];
            Point s2 = ((Polygon) other).points[1];
            Point s3 = ((Polygon) other).points[2];
            if (!(p1.equals(s1) || p1.equals(s2) || p1.equals(s3))) {
                bool = false;
            }
            if (!(p2.equals(s1) || p2.equals(s2) || p2.equals(s3))) {
                bool = false;
            }
            if (!(p3.equals(s1) || p3.equals(s2) || p3.equals(s3))) {
                bool = false;
            }
        }
        if (getNumOfPoints() == 4){
            Point p1 = points[0];
            Point p2 = points[1];
            Point p3 = points[2];
            Point p4 = points[3];
            Polygon s = ((Polygon) other);
            if (this.getName().equals(((Polygon) other).getName())) {
                return false;
            }
            Point s1 = ((Polygon) other).points[0];
            Point s2 = ((Polygon) other).points[1];
            Point s3 = ((Polygon) other).points[2];
            Point s4 = ((Polygon) other).points[3];
            if (!(p1.equals(s1) || p1.equals(s2) || p1.equals(s3)||p1.equals(s4))) {
                bool = false;
            }
            if (!(p2.equals(s1) || p2.equals(s2) || p2.equals(s3))||p2.equals(s4)) {
                bool = false;
            }
            if (!(p3.equals(s1) || p3.equals(s2) || p3.equals(s3)||p3.equals(s4))) {
                bool = false;
            }
            if (!(p4.equals(s1) || p4.equals(s2) || p4.equals(s3)||p4.equals(s4))) {
                bool = false;
            }
        }
            return bool;

        }
    }

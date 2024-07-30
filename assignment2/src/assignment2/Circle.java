package assignment2;

import javax.lang.model.type.NullType;
import java.util.Objects;

public class Circle extends Shape implements Comparable<Circle> {
    private double radius;
    private Point center;

    public static final double PI = 3.14;

    public Circle()
    {
        this.center= new Point();
        this.radius=0;

    }

    public Circle(double radius, Point center, String name) {


        double x=center.getX();
        double y=center.getY();
        Point p=new Point(x,y);
        this.center=p;
        this.radius=radius;
        this.setName(name);
    }

    public Circle(Circle other)
    {
        Point p1=new Point(other.center);
        //p1=other.center;
        this.center=p1;
        this.radius=other.radius;
        String new_name=other.getName();
        this.setName(new_name);
    }

    public double getRadius()
    {
        return radius;
    }

    public Point getCenter()
    {
        return center;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public void setCenter(Point center)
    {
        this.center = center;
    }

    @Override
    public double calcCircumference()
    {
        return radius*PI*2;
    }

    @Override
    public double calcArea()
    {
        return (radius*radius)*PI;
    }

    @Override
    public void shift(double xShift, double yShift)
    {
        this.center.setX(this.center.getX()+xShift);
        this.center.setY(this.center.getY()+yShift);

    }

    @Override
    public int compareTo(Circle other)
    {
        if (other==null){
            return 1;
        }


        if (this.radius < other.getRadius())
        {
            return -1;
        }
        else if (this.radius > other.getRadius())
        {
            return 1;
        }
        else {

            return this.getName().compareTo(other.getName());
        }

    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if (!(other instanceof Circle))
        {
            return false;
        }
        Circle circle = (Circle) other;
        return (Objects.equals(this.getName(), circle.getName())
                && this.radius == circle.radius
                && Objects.equals(this.center,circle.center));
    }


    @Override
    public double getLeftMostX()
    {
        return this.center.getX()-this.getRadius();
    }

    @Override
    public double getUpperMostY()
    {
        return this.radius+this.center.getY();
    }
}

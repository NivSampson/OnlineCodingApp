package assignment2;

import java.util.Objects;

public abstract class Shape implements EdgePointer{
    private String name;

    public Shape()
    {
        name=null;

    }

    public Shape(String name)
    {
        this.name = name;
    }


    public String getName(){
     if (name==null){
        return "no have name";
    }
        return name;
}

    public void setName(String name)
    {
        this.name=name;
    }

    public abstract double calcCircumference();

    public abstract double calcArea();

    public abstract void shift(double xShift, double yShift);

    @Override
    public boolean equals(Object o)
    {
        if(this==o){
            return true;
        }
        return false;
    }
}

package assignment2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ShapeContainer implements Iterable<Shape> {
    public class ShapeContainerIterator implements Iterator<Shape> {
        private Shape[] shapes;

        private int index = 0;

        public ShapeContainerIterator(Shape[] shapes) {
            this.shapes = shapes;
        }

        @Override
        public boolean hasNext() {
            return index < shapes.length && shapes[index] != null;
        }

        @Override
        public Shape next() {
            return this.shapes[index++];
        }
    }

    public static class NameComparator implements Comparator<Shape>
    {
        @Override
        public int compare(Shape o1, Shape o2)
        {
            String o_1=o1.getName();
            String o_2=o2.getName();
            return o_1.compareTo(o_2);
        }



    }

    public static class CircumferenceComparator implements Comparator<Shape>
    {
        @Override
        public int compare(Shape o1, Shape o2)
        {
            double o1_size=o1.calcCircumference();
            double o2_size=o2.calcCircumference();
            if (o1_size < o2_size) {
                return -1;
            } else if (o1_size > o2_size) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public static class EdgeComparator implements Comparator<Shape>
    {
        @Override
        public int compare(Shape o1, Shape o2)
        {
            if (o1.getLeftMostX() < o2.getLeftMostX()) {
                return -1;
            }
            if (o1.getLeftMostX() > o2.getLeftMostX()) {
                return 1;
            } else {
                if (o1.getUpperMostY() < o2.getUpperMostY()) {
                    return -1;
                }
                if (o1.getUpperMostY() > o2.getUpperMostY()) {
                    return 1;
                }
            }
            return 0;
        }
    }

    private Shape[] shapes;
    private int number=0;

    public ShapeContainer()
    {
        int  initialSize=1;
        this.shapes=new Shape[initialSize];

    }

    public ShapeContainer(Shape[] shapes)
    {
        this.shapes=shapes;
        int number=0;
        Iterator<Shape> it = iterator();
        while (it.hasNext()){
            number++;
            it.next();
        }

        this.number=number;
        }



    public Shape[] getShapes()
    {
        return shapes;
    }

    public void addShape(Shape newShape) {
        if (shapes[shapes.length - 1] != null)
        {
            Shape[] dynamicArray = new Shape[shapes.length * 2];
            System.arraycopy(shapes, 0, dynamicArray, 0, shapes.length);
            shapes = dynamicArray;
        }
        shapes[number]=newShape;
        number++;

    }

    public int contains(Shape shape) {
        for (int i = 0; i < number; i++) {
            if (shape.equals(shapes[i])) {
                return i;
            }
        }
        return -1;
    }

    public double calcAllCircumference() {
        double sum = 0;
        for (int i = 0; i < this.shapes.length; i++) {
            if (this.shapes[i] != null) {
                sum += this.shapes[i].calcCircumference();
            }


        }
        return sum;
    }

    public double calcCircleArea()
    {
        double sum=0;
        for (int i =0 ; i < this.shapes.length; i++) {
            if (this.shapes[i] instanceof Circle) {
                sum += this.shapes[i].calcArea();
            }
        }
        return sum;

    }

    public double calcPolygonArea()
    {
        double sum=0;
        for (int i =0 ; i < this.shapes.length; i++) {
            if (this.shapes[i] instanceof Polygon) {
                sum += this.shapes[i].calcArea();
            }
        }
        return sum;

    }


    public void sort(Comparator<Shape> comparator)
    {
        Arrays.sort(shapes, 0,number, comparator);
    }

    @Override
    public Iterator<Shape> iterator()
    {
        return new ShapeContainerIterator(shapes);
    }
}

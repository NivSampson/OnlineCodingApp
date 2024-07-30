package assignment2;

public class Square extends Polygon {
    public Square(Point[] points, String name) {
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
        Point p4 = this.getPointAt(3);
        double px4 = p4.getX();
        double py4 = p4.getY();
        return Math.abs((px1 * py2 + px2 * py3 + px3 * py4 + px4 * py1) - (py1 * px2 + py2 * px3 + py3 * px4 + py4 * px1)) / 2;

    }

    @Override
    public double calcCircumference() {
        double maxDistance = 0;
        Point p1 = null;
        Point p2=null;
        for (int i = 0; i < this.getNumOfPoints(); i++) {
            for (int j = i + 1; j < this.getNumOfPoints(); j++) {
                double distance = this.getPointAt(i).distance(this.getPointAt(j));
                if (distance > maxDistance) {
                    maxDistance = distance;
                    p1=this.getPointAt(i);
                    p2=this.getPointAt(j);
                }
            }

        }
        return 2 * (Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()));




    }

    @Override
    public boolean equals(Object other) {


        if(other!=null && this.getClass() == other.getClass()){
            Square s=(Square)other;
            int count=0;
            for(int i=0;i <= this.getNumOfPoints()-1;i++){
                for (int j=0;j <= s.getNumOfPoints()-1;j++){
                    //if (this.getPointAt(i).equals(s.getPointAt(j))&&this.getLeftMostX()==s.getLeftMostX()&&this.getUpperMostY()==s.getUpperMostY()){
                    if (this.getPointAt(i).getX()==((Square) other).getPointAt(j).getX()&&this.getPointAt(i).getY()==((Square) other).getPointAt(j).getY()){
                        count++;
                        break;
                    }
                }
            }
            return count==4 && this.getName().equals(s.getName());
        }


        return false;
    }
}

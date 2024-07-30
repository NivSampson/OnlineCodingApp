public class student {
    public String firstName;
    public String lastName;
    public Main.StudentType myType;
    public student(String first, String last , Main.StudentType type) {


         this.firstName =first;
         this.lastName=last;
         this.myType= type;


    }
     public void PrintStudent() {
        System.out.println(this.firstName);
         System.out.println(this.lastName);
         System.out.println(this.myType);

    }

}


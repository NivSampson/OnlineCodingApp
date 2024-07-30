package assignment3;

import java.util.Scanner;
import java.io.*;

public class PersonRegistry {
    public boolean corrupted=false;
    private MyArrayList<Person> personList;
    private MySet<Person> uniq_person;

    public boolean isCorrupted()
    {
        return this.corrupted;
    }

    public PersonRegistry(String filePath) {
        personList = new MyArrayList<>();
        uniq_person=new MySet<>();
            if (filePath.endsWith(".bin")) {
                // Read from the  file
                try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {
                    personList = (MyArrayList<Person>) inputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                // Read from a CSV file
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    //take the word aftar a comoon and put in thir field
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        String my_name = data[0];
                        int my_age = Integer.parseInt(data[1]);
                        double my_luckyNumber = Double.parseDouble(data[2]);
                        Person person = new Person(my_name, my_age, my_luckyNumber);
                        personList.add(person);
                    }
                } catch (IOException e) {
                   corrupted=true;
                }
            }
        }





    public PersonRegistry()
    {
        this.personList=new MyArrayList<Person>();
        this.uniq_person=new MySet<>();


    };
    public PersonRegistry(Iterable<? extends Person> persons){
        personList = new MyArrayList<>();
        for (Person person : persons) {
            personList.add(person);
        }

    }
    public PersonRegistry(Person[] persons){
        personList = new MyArrayList<>(persons);
        for (Person person : persons) {
            personList.add(person);
        }
    }


    public void add(Person p){
        this.personList.add(p);
        this.uniq_person.add(p);



    }
    public Person get(int index){
        return this.personList.get(index);

    }
    public boolean writeCSV(String filePath){
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(filePath));
            // Iterate over the persons
            for (Person person : personList) {
                // Write each person's data
                write.write(person.getName() + "," + person.getAge() + "," + person.getLuckyNumber());
                write.newLine();
            }
            write.close();
            return true;    // Writing  success
        } catch (IOException e) {
            return false;   // Writing failed
        }
    }

    public int maxAge(){
        int maxAge = Integer.MIN_VALUE;
        for (Person person : personList) {
            if (person.getAge() > maxAge) {
                maxAge = person.getAge();
            }
        }
        return maxAge;
    }
    public double meanLuckyNumber(){
        int sum = 0;
        int count = 0;
        for (Person person : personList) {
            if (person.getLuckyNumber() >0) {
                sum += person.getLuckyNumber();
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;

    }
    public MyArrayList<String> uniqueNames() {
        MySet<String> uniqueNamesSet = new MySet<>();
        MyArrayList<String> uniqueNamesList = new MyArrayList<>();

        for (Person person : personList) {
            String name = person.getName();
            uniqueNamesSet.add(name);
        }

        for (String name : uniqueNamesSet) {
            uniqueNamesList.add(name);
        }

        return uniqueNamesList;
    }
    public int count(Person person)

    {
        int j=0;

        for (int i = 0 ; i <this.personList.count_like_set();i++){

            if (this.personList.get(i).equals(person)){
                j++;
            }
        }
        return j;
    }






}

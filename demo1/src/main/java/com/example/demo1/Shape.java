package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.io.IOException;

/*
 class newthread implements Runnable {

     Thread t;

     newthread() {
         t = new Thread(this, "My Thread");
         t.start();
     }

     public void run() {



             System.out.println(t);



         }

 }
    class multithreaded_programing
    {
        public static void main (String args [])
        {
            new newthread();


        }
    }

/*
public class fileinputoutput
{
    public static void main (String[] args)
    {
        String obj = "abc";
        byte b[]=obj.getBytes();
        ByteArrayInputStream obj1 = new ByteArrayInputStream(b);
        for (int i =0; i<2;++i)
        {
            int c ;
            while ((c=obj1.read())!=-1)
            {
                if (i==0)
                {
                    System.out.println(Character.toUpperCase((char) c));
                }
            }
        }
    }
}

 */
/*
public class Shape
{
    public int area()
    {
        return 1;
    }
}

class Main {
    public static void main(String[] args){
        Shape shape=new Shape();
        rec rec=new rec();
        shape=rec;

        System.out.println(shape.area());
    }
}

 */

import java.util.*;
public class gener<E>{
    Stack <E> stk=new Stack<E>();
    public void push(E obj)
    {
        stk.push(obj);
    }
    public E pop()
    {
        E obj=stk.pop();
        return obj;

    }

}
class output
{
    public static void main (String args [])
    {
        gener <String> gs = new gener<String>();
        gs.push("Hello");
        System.out.print(gs.pop()+"" );
        gener <Integer> gs=new gener<>()
    }
}

package assignment3;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Iterator;


public class MySet<T extends Serializable> implements  Iterable<T>, Serializable {
    public MyArrayList set;

    public MySet() {
        this.set = new MyArrayList<>();

    }


    public MySet(Iterable<? extends T> collection) {
        set = new MyArrayList<>();
        for (T element : collection) {
            if (set.index(element) == -1) {
                set.add(element);
            }
        }

    }

    public MySet(T[] arr) {
        set = new MyArrayList<>();
        for (T element : arr) {
            if (element != null && (set.index(element)) == -1) {
                set.add(element);
            }
        }
    }
            /*

        }
        for (int i =0; i<arr.length;i++){
            for (int j =0; j<arr.length-1;j++){
                if (this.set.get(i)==this.set.get(j)){
                    this.set.remove(this.set.get(j));
                }
            }

        }

             */

    public void add(T element) {
        if ( (set.index(element)) == -1) {
            set.add(element);
        }
    }


    public boolean contains(T element) {

        if (element==null){
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < set.capacity(); i++) {
            if (this.set.arr.get(i) == element) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    public int size() {
        int i = 0;
        for (int j = 0; j < this.set.capacity(); j++) {
            if (this.set.arr.get(j) != null) {
                i++;
            }
        }
        return i;

    }

    public void remove(T element) {
        this.set.remove(element);
    }
        /*
        int i = 0;
        for (int j = 0; j < this.set.capacity() - 1; j++) {
            if (this.set.get(j) == element) {
                i++;

            }
        }
        if (i > 0) {
            this.set.remove(element);
        } else {
            throw new NoSuchElementException();
        }

    }

         */

    public MySet<T> union(MySet<T> other){
        MySet<T> unionSet = new MySet<>();

        for (Object element : this.set) {
            unionSet.add((T) element);
        }

        for (Object element : other.set) {
            unionSet.add((T) element);
        }
        return unionSet;
    }

    public MySet<T> intersection(MySet<T> other){
        MySet<T> intersectionSet = new MySet<>();

        for (Object element : this.set) {
            if (other.contains((T) element)) {
                intersectionSet.add((T) element);
            }
        }

        return intersectionSet;
    }
    public MySet<T> difference(MySet<T> other){
        MySet<T> differenceSet = new MySet<>();

        for (Object element : this.set) {
            if (!other.contains((T) element)) {
                differenceSet.add((T) element);
            }
        }

        return differenceSet;
    }
    public boolean equals(MySet<T> other){
        if (this.size() != other.size()) {
            return false;
        }

        for (Object element : this.set) {
            if (!other.contains((T) element)) {
                return false;
            }
        }

        return true;
    }

    public T get(int index) {
        if (index >= 0 && this.set.size() > index && this.set.get(index) != null) {
            return (T) this.set.get(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.set.iterator();
    }
}

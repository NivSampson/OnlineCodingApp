package assignment3;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyArrayList<T extends Serializable> implements Iterable<T>, Serializable {
    public SimpleArray<T> arr;
    private int currentIndex = 0;
    public int num = 0;

    public SimpleArray<T> getUnderlyingSimpleArray() {
        return this.arr;
    }

    public int capacity() {
        return this.arr.length();
    }

    public MyArrayList() {
        this.arr = new SimpleArray<>(1);

    }

    public MyArrayList(T[] arr) {
        SimpleArray new_simple = new SimpleArray<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            new_simple.set(i, arr[i]);

        }

        this.arr = new_simple;

    }

    public T get(int index) {

        if (index < 0 || arr.size() <= index || arr.get(index) == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.arr.get(index);
    }

    public int size() {

        int count = 0;
        for (int i = 0; i < this.arr.size(); i++) {
            if (getUnderlyingSimpleArray().get(i) != null) {
                count++;
            }
        }
        return count;
    }

    public int count_like_set() {
        MySet<T> distinct_Elements = new MySet<>();

        for (T element : this) {
            distinct_Elements.add(element);
        }

        return distinct_Elements.size();
    }


    public void add(T element) {


        if (this.arr.get(this.arr.size() - 1) != null) {
            //  double the size
            SimpleArray<T> newArray = new SimpleArray<>(this.arr.length() * 2);

            // Copy the elements from the original array to the new array
            for (int i = 0; i < this.arr.size(); i++) {
                newArray.set(i, this.arr.get(i));

            }

            // Add the new element
            newArray.set(this.arr.size(), element);
            this.num++;

            // Update the reference
            this.arr = newArray;
        } else {
            // Find the first null  and set  new element
            for (int i = 0; i < this.arr.size(); i++) {
                if (this.arr.get(i) == null) {
                    this.arr.set(i, element);
                    this.num++;
                    break;
                }
            }
        }
    }


    private void increaseSize() {
        int newSize = this.arr.size() * 2;
        SimpleArray<T> newArray = new SimpleArray<>(newSize);
        for (int i = 0; i < this.arr.size(); i++) {
            newArray.set(i, this.arr.get(i));
        }
        this.arr = newArray;
    }


    public void remove(T element) {
        int nullIndex = arr.size() - 1;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null && arr.get(i).equals(element)) {
                arr.set(i, null);
                num--;

            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == null) {
                while (nullIndex >= 0 && arr.get(nullIndex) == null) {
                    nullIndex--;
                }

                if (i < nullIndex) {
                    arr.set(i, arr.get(nullIndex));
                    arr.set(nullIndex, null);
                }
            }
        }
    }


    public int index(T element) {
        int a = -1;
        for (int i = 0; i < this.arr.size(); i++) {
            if (this.arr.get(i) == element) {
                a = i;
                break;
            }

        }
        return a;
    }

    public int count(T element) {
        int a = 0;
        for (int i = 0; i < this.arr.size(); i++) {
            if (this.arr.get(i) == element) {
                a++;
            }

        }
        return a;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int iteratorIndex = 0;
            private int count = 0;

            public boolean hasNext() {
                return count < num;
            }

            public T next() {
                if (hasNext()) {
                    while (iteratorIndex < arr.length()) {
                        T element = arr.get(iteratorIndex);
                        iteratorIndex++;
                        if (element != null) {
                            count++;
                            return element;
                        }
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }
        };

    }
}
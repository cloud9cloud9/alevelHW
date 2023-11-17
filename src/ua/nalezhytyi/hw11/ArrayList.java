package ua.nalezhytyi.hw11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> {
    private Object[] array;
    private int size;

    private int counter = 0;

    ArrayList(int size) {
        this.size = size;
        array = new Object[size];
    }


    //Add element to the end of array {1,2,3} -> {1,2,3,4}
    void add(T element) {
        if (counter == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[counter++] = element;
}


    //Add element to given position of array {1,2,3} -> {1,4,2,3}
    void add(T element, int index) {
        if (index >= 0 && index <= counter) {
            T[] newArray = (T[]) Arrays.copyOf(array, array.length + 1);
            System.arraycopy(array, 0, newArray, 0, index);
            // Додати новий елемент
            newArray[index] = element;
            // Скопіювати елементи після бажаного індексу
            System.arraycopy(array, index, newArray, index + 1, array.length - index);
            // Замінити оригінальний масив новим
            array = newArray;
            counter++;
        }
    }

    //
    //Returns index of the given element, if element doesnt exist return -1
    int indexOf(T element) {
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    boolean isContains(T element) {
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    T[] get() {
        return (T[]) array;
    }

    T get(int index) {
        if (index >= 0 && index < array.length) {
            return (T) array[index];
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for array of size " + array.length);
        }
    }


    T remove(int index) {
        T removed = (T) array[index];
        // Creating a new array with size - 1

        T[] destinationArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length - 1);
        // Copying elements from the original array to the new array

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i == index) {
                continue; // Skip the element we want to delete
            }
            destinationArray[j++] = (T) array[i];
        }
        // Updating the reference to the new array
        array = destinationArray;

        return removed;
    }
}

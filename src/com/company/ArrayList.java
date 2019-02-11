package com.company;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] values;
    private int size = 0;

    public ArrayList() {
        this.values = new Object[INITIAL_CAPACITY];
    }

    @Override
    public T get(int i) {
        checkIndexException(i);
        return (T) values[i];
    }

    private void checkIndexException(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index is: " + index + ", but Size is: " + size);
        }
    }

    @Override
    public boolean add(T t) {
        if (size == values.length) {
            increaseCapacity();
        }
        values[size++] = t;
        return true;
    }

    private void increaseCapacity() {
        values = Arrays.copyOf(values, values.length*2);
    }

    @Override
    public T remove(int i) {
        checkIndexException(i);
        T element = (T) values[i];
        values[i] = null;
        int currentIndex = i;
        int nextIndex = i + 1;
        while (currentIndex < size) {
            values[currentIndex] = values[nextIndex];
            values[nextIndex] = null;
            currentIndex++;
            nextIndex++;
        }
        size--;
        return element;
    }

    @Override
    public int size() { return size; }


}

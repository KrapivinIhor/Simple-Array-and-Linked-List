package com.company;

public interface List<T> {
    T get(int i);
    boolean add(T t);
    T remove(int i);
    int size();
}

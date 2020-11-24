package com.han.demo4;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Test6<T> {
    private T[] elements;
    private int size = 0;

    private static final int INIT_CAPACITY = 16;

    public Test6(){
        elements = (T[]) new Object[INIT_CAPACITY];
    }
    public void push(T elem){
        ensureCapacity();
        elements[size++] = elem;
    }
    public T pop(){
        if (size == 0){
            throw new EmptyStackException();
        }
        return elements[--size];
    }
    public void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}


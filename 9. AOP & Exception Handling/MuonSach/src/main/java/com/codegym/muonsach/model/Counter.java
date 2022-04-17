package com.codegym.muonsach.model;

public class Counter {
    private int counter;
    private int counter1;

    public Counter() {
    }

    public Counter(int counter,int counter1) {
        this.counter = counter;
        this.counter1 = counter1;
    }

    public int getCounter1() {
        return counter1;
    }

    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void increment() {
        counter++;
    }
    public void increment1() {
        counter1++;
    }
}

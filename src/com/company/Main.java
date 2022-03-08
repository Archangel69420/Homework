package com.company;

public class Main {
    public static void main(String[] args) {
        IntStack test = new IntStack(100);
        for (int i = 1; !test.isFull(); i++)
            test.push(i);
        while (!test.isEmpty())
            System.out.println(test.pop());
    }

}

class IntStack {
    private final int SIZE = 1000;
    private int capacity = 0;
    private int counter = 0;
    private int[] staticStack = new int[1000];
    public IntStack(int capacity) {
        if (capacity <= SIZE)
            this.capacity = capacity;
        else {
            System.out.println("Capacity too large");
            System.exit(1);
        }
    }
    public boolean isFull() {
        if (counter == capacity)
            return true;
        return false;
    }
    public boolean isEmpty() {
        if (counter == 0)
            return true;
        return false;
    }
    public void push (int item) {
        staticStack[counter] = item;
        counter ++;
    }
    public int pop() {
        counter--;
        return staticStack[counter];
    }
}
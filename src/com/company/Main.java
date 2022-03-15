package com.company;
import ibadts.*;

/* public class Main {
    public static void main(String[] args) {
        IntQueue queue = new IntQueue(5);
        for (int i = 0; i < 5; i++)
            queue.enqueue(i);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(69);
        for (int i = 0; i < 4; i ++)
            System.out.println(queue.dequeue());
    }
}

class IntQueue {
    int[] arr;
    int capacity;
    int count = 0;
    public IntQueue(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
    }
    public void enqueue (int item) {
        if (count < capacity) {
            arr[count] = item;
            count++;
        }
        else
            System.out.println("Limit exceeded");
    }

    public int dequeue() {
        if (!isEmpty()) {
            int value = arr[0];
            for (int i = 0; i < count - 1; i++) {
                arr[i] = arr[i + 1];
            }
            count--;
            return value;
        } else return -1;
    }

    public boolean isEmpty() {
        if (count == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (count == capacity - 1)
            return true;
        return false;
    }
} */

public class Main {
    public static void main(String[] args) {
        Queue<String> economy = new Queue<>(), business = new Queue<>();
        economy.enqueue("Sarah_A");
        economy.enqueue("John_B");
        economy.enqueue("Wendy_C");
        business.enqueue("Sir_A");
        business.enqueue("Madam_B");
        business.enqueue("Rick_C");
        byte counter = 1;
        System.out.println("economy: " + economy);
        System.out.println("business: " + business);
        System.out.print("order: ");
        while (!economy.isEmpty() || !business.isEmpty()) {
            if (counter % 3 != 0 && !business.isEmpty())
                System.out.print(business.dequeue() + " ");
            else {
                System.out.print(economy.dequeue() + " ");
                counter = 0;
            }
            counter++;
        }
    }
}
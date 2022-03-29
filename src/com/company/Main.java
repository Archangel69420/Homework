package com.company;

import java.io.*;
import java.util.*;

package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random generator = new Random();
        Node first = new Node(-1);
        for (int i = 0; i < 1000; i++) {
            first.add(generator.nextInt(100));
        }
        first.print();
        System.out.println("------------------------------------------------");
        first = first.remove(first, -1);
        first.print();
        Node second = new Node(0);
        for (int i = 0; i < 1000; i ++) {
            second.add(i);
        }
        System.out.println("------------------------------------------------");
        second.add(50);
        second = second.remove(second, 50);
        second.print();
    }
}
class Node {
    Node(int v) {
        value = v;
        next = null;
    }
    void add (int v) {
        if (next == null)
            next = new Node(v);
        else next.add(v);
    }

    Node add(Node to, Node from) {
        to.add(from.value);
        if (from.next == null)
            return to;
        else
            return add(to, from.next);
    }

    void print() {
        System.out.println(value + " ");
        if (next != null) next.print();
    }
    Node remove (Node head, int v) {
        if (head.value == v && head.next != null) {
            return head.next;
        }
        else {
            assert head.next != null;
            return add(new Node(head.value), remove(head.next, v));
        }
    }
    int value;
    Node next;
}

public class Main {
    public static void main(String[] args) {
        Priority mt1 = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");
        Priority mt3 = new Priority("Normal Priority #1");
        Priority mt4 = new Priority("Normal Priority #2");
        Priority mt5 = new Priority("Normal Priority #3");
        mt1.thrd.setPriority(Thread.NORM_PRIORITY + 2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY - 2);
        mt1.thrd.start();
        mt2.thrd.start();
        mt3.thrd.start();
        mt4.thrd.start();
        mt5.thrd.start();
        try {
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
            mt4.thrd.join();
            mt5.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("\nHigh priority thread counted to " +
                mt1.count);
        System.out.println("Low priority thread counted to " +
                mt2.count);
        System.out.println("1st Normal priority thread counted to " +
                mt3.count);
        System.out.println("2nd Normal priority thread counted to " +
                mt4.count);
        System.out.println("3rd Normal priority thread counted to " +
                mt5.count);
    }
}

class Priority implements Runnable {
    int count;
    Thread thrd;
    static boolean stop = false;
    static String currentName;

    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run() {
        System.out.println(thrd.getName() + " starting.");
        do {
            count++;
            if (currentName.compareTo(thrd.getName()) != 0) {
                currentName = thrd.getName();
                System.out.println("In " + currentName);
            }
        } while (stop == false && count < 10000000);
        stop = true;
        System.out.println("\n" + thrd.getName() +
                " terminating.");
    }
}
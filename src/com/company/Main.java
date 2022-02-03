package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        HW7 exp = new HW7();
        exp.controller(exp.pairOne, exp.pairTwo,0);
    }
}

class HW7 {
    int[] arr = {2, 1, -3, 0 };
    LinkedList<Integer> pairOne, pairTwo;

    private boolean eqSum (LinkedList<Integer> A, LinkedList<Integer> B) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < A.size(); i++) {
            sum1 += A.get(i);
        }
        for (int i = 0; B != null && i < B.size(); i++) {
            sum1 += B.get(i);
        }
        if (sum1 == sum2)
            return true;
        return false;
    }

    public void controller (LinkedList<Integer> first, LinkedList<Integer> second, int counter) {
        LinkedList<Integer> Anew = new LinkedList<>(), Bnew = new LinkedList<>();
        if (counter == arr.length && eqSum(first, second)) {
            outPut(first, second);
        }
        if (counter < arr.length) {
            Anew.add(arr[counter]);
            Bnew.add(arr[counter]);
            controller(Anew, second, counter++);
            controller(first, Bnew, counter++);
        }
    }

    private void outPut(LinkedList<Integer> A, LinkedList<Integer> B) {
        System.out.print("A=[");
        for (Integer v: A) {
            System.out.print(v);
        }
        System.out.print("], B=[");
        for (Integer v: A) {
            System.out.print(v);
        }
        System.out.print("]" + "\n");
    }
}
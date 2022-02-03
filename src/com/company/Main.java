package com.company;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        HW7 exp = new HW7(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
        exp.controller(exp.pairOne, exp.pairTwo, 0);
    }
}

class HW7 {
    int[] arr;
    LinkedList<Integer> pairOne, pairTwo;

    public HW7 (int[] arr) {
        this.arr = arr;
    }

    private boolean eqSum(LinkedList<Integer> A, LinkedList<Integer> B) {
        int sum1 = 0;
        if (A != null) {
            for (int i = 0; i < A.size(); i++) {
                sum1 = sum1 + A.get(i);
            }
        }
        if (B!= null) {
            for (int i = 0; i < B.size(); i++) {
                sum1 = sum1 - B.get(i);
            }
        }
        if (sum1 == 0) {
            return true;
        }
        return false;
    }

    public void controller(LinkedList<Integer> first, LinkedList<Integer> second, int counter) {
        LinkedList<Integer> Anew = new LinkedList<>(), Bnew = new LinkedList<>();
        if (counter == arr.length && eqSum(first, second)) {
            outPut(first, second);
        }
        if (counter < arr.length) {
            if (first != null)
                Anew = (LinkedList<Integer>) first.clone();
            if (second != null)
                Bnew = (LinkedList<Integer>) second.clone();
            Anew.add(arr[counter]);
            Bnew.add(arr[counter]);
            controller(Anew, second, counter + 1);
            controller(first, Bnew, counter + 1);
        }
    }

    private void outPut(LinkedList<Integer> A, LinkedList<Integer> B) {
        System.out.print("A=[");
        if (A != null) {
            for (Integer v : A) {
                System.out.print(v + " ");
            }
        }
        System.out.print("], B=[");
        if (B != null) {
            for (Integer v : B) {
                System.out.print(v + " ");
            }
        }
        System.out.print("]" + "\n");
    }
}
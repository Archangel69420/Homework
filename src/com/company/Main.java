package com.company;

public class Main {

    public static void main(String[] args) {
        final int N = 7;
        int[][] arr = new int[N][N];
        int Srow = 0, Erow = 0, Scol = 0, Ecol = 0, k = 1;
        while (k <= N*N) {
            for (int r = Srow, c = Scol; r <= Erow && c >= Ecol; r ++, c--) {
             arr[r][c] = k;
             k++;
            }
            if (Scol <= N - 2) {
                Scol++;
                Erow++;
            }
            else {
                Srow++;
                Ecol++;
            }
        }
        for (int[] v : arr) {
            for (int i : v)
                System.out.print(i + " ");
            System.out.print("\n");
        }
    }
}
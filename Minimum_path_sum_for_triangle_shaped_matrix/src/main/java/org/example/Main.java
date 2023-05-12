package org.example;

public class Main {
    public static void main(String[] args) {
        int [][] matrix = {{4},{1, 3},{1, 2, 1}, {8, 4, 5, 1}};

        String memoization = Memoization.execute(matrix);
        System.out.println("Memoization:\n" + memoization);
        System.out.println("****************************************");

        String tabulation = Tabulation.execute(matrix);
        System.out.println("Tabulation:\n"+ tabulation);
        System.out.println("*****************************************");
    }
}
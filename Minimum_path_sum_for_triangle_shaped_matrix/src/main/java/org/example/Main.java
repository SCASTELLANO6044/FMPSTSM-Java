package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int [][] matrix = {{4},{1, 3},{1, 2, 1}, {8, 4, 5, 1}};

        MatrixIndex matrixIndex = new MatrixIndex(0, 0);
        Map<MatrixIndex, Integer> memoizationDictionary = new HashMap<MatrixIndex, Integer>();
        String memoization = Memoization.execute(matrix, memoizationDictionary, matrixIndex);
        System.out.println("Memoization:\n" + memoization);
        System.out.println("****************************************");

        String tabulation = Tabulation.execute(matrix);
        System.out.println("Tabulation:\n"+ tabulation);
        System.out.println("*****************************************");
    }
}
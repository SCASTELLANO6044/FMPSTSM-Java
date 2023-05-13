package org.example;

public class Tabulation {
    public static String execute(int[][] matrix){
        Integer tabulation = tabulation(matrix, new MatrixIndex(0,0));
        return String.valueOf(tabulation);
    }

    private static Integer tabulation(int[][]matrix, MatrixIndex matrixIndex){

        int[][] table = new int[matrix.length][matrix[matrix.length-1].length];

        for (int i = 1; i < table.length; i++){
        }

        return null;
    }
}

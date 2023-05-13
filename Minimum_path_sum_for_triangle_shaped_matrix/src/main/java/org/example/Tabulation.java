package org.example;

import java.util.*;

public class Tabulation {

    private Tabulation (){
        throw new IllegalStateException("Utility class");
    }

    public static String execute(int[][] matrix){
        int [][] tabulation = tabulation(matrix);
        String resultMessage = "The result value is: "+ tabulation[0][0];
        resultMessage += " and the path chosen is: " + pathChosen(tabulation, matrix);
        return resultMessage;
    }

    private static int[][] tabulation(int[][]matrix){

        int rowAmount = matrix.length;
        int [][] table = new int[rowAmount][rowAmount];
        table[rowAmount-1] = Arrays.copyOf(matrix[rowAmount-1], rowAmount);
        for (int row = rowAmount - 2; row >= 0; row--){
            for (int col = 0; col <= row; col++){
                table[row][col] = matrix[row][col] + Integer.min(table[row+1][col], table[row+1][col+1]);
            }
        }
        return table;
    }

    private static String pathChosen(int[][] table, int[][] originalMatrix){
        List<MatrixIndex> matrixIndexList = new ArrayList<>(table.length);
        for (int i = 0; i < table.length; i++){
            int lessValueItem = Integer.MAX_VALUE;
            int y = -1;
            for(int j = 0; j <= i; j++){
                if (table[i][j] < lessValueItem){
                    lessValueItem = table[i][j];
                    y = j;
                }
            }
            matrixIndexList.add(new MatrixIndex(i, y));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (MatrixIndex matrixIndex: matrixIndexList) {
            stringBuilder.append("[").append(originalMatrix[matrixIndex.getX()][matrixIndex.getY()]).append("]");
        }
        return stringBuilder.toString();
    }
}
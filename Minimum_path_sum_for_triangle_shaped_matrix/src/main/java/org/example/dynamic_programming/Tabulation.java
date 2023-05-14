package org.example.dynamic_programming;

import org.example.utils.MatrixIndex;

import java.util.*;

public class Tabulation {

    private Tabulation (){
        throw new IllegalStateException("Utility class");
    }

    public static String execute(int[][] matrix){
        int [][] tabulation = tabulation(matrix);

        return "The result value is: "+ tabulation[0][0] +
                " and the path chosen is: " +
                pathChosen(tabulation, matrix);
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
        matrixIndexList.add(new MatrixIndex(0,0));
        for (int i = 1; i < table.length-1; i++){
            int lessValueItem = Integer.MAX_VALUE;
            int y = -1;
            for(int j = matrixIndexList.get(matrixIndexList.size()-1).getY(); j <= matrixIndexList.get(matrixIndexList.size()-1).getY()+1; j++){
                if (table[i][j] < lessValueItem){
                    lessValueItem = table[i][j];
                    y = j;
                }
            }
            matrixIndexList.add(new MatrixIndex(i, y));
        }

        if (table[matrixIndexList.get(matrixIndexList.size()-1).getX()+1]
                [matrixIndexList.get(matrixIndexList.size()-1).getY()] <
                table[matrixIndexList.get(matrixIndexList.size()-1).getX()+1]
                        [matrixIndexList.get(matrixIndexList.size()-1).getY()+1]){
            matrixIndexList.add(new MatrixIndex(matrixIndexList.get(matrixIndexList.size()-1).getX()+1,
                    matrixIndexList.get(matrixIndexList.size()-1).getY()));
        }else {
            matrixIndexList.add(new MatrixIndex(matrixIndexList.get(matrixIndexList.size()-1).getX()+1,
                    matrixIndexList.get(matrixIndexList.size()-1).getY()+1));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (MatrixIndex matrixIndex: matrixIndexList) {
            stringBuilder.append("[").append(originalMatrix[matrixIndex.getX()][matrixIndex.getY()]).append("]");
        }
        return stringBuilder.toString();
    }
}

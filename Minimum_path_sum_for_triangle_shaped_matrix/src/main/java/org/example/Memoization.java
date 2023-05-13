package org.example;

import java.util.Map;

public class Memoization {

    private Memoization (){
        throw new IllegalStateException("Utility class");
    }

    public static String execute(int[][] matrix,
                                 Map<MatrixIndex, Integer> memoizationDictionary,
                                 MatrixIndex matrixIndex){
        Integer memoizationResult = memoization(matrix, memoizationDictionary, matrixIndex);
        return String.valueOf(memoizationResult);
    }

    private static Integer memoization(int[][] matrix,
                                       Map<MatrixIndex, Integer> memoizationDictionary,
                                       MatrixIndex matrixIndex){

        if(memoizationDictionary.containsKey(matrixIndex)){
            System.out.println("***Result found on dictionary***");
            return memoizationDictionary.get(matrixIndex);
        }

        int result;

        if (matrixIndex.getX() == matrix.length - 2) {

            result = matrix[matrixIndex.getX()][matrixIndex.getY()] +
                    Integer.min(matrix[matrixIndex.getX() + 1][matrixIndex.getY()],
                            matrix[matrixIndex.getX() + 1][matrixIndex.getY()+1]);

        }else {
            MatrixIndex downMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY());
            MatrixIndex rightDownMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY() + 1);

            Integer downElement = memoization(matrix, memoizationDictionary, downMatrixIndex);
            Integer rightDownElement = memoization(matrix, memoizationDictionary, rightDownMatrixIndex);

            result = matrix[matrixIndex.getX()][matrixIndex.getY()] + Integer.min(downElement, rightDownElement);
        }
        memoizationDictionary.put(matrixIndex, result);
        return result;
    }
}

package org.example;

import java.util.Map;

public class Memoization {
    public static String execute(int[][] matrix,
                                 Map<MatrixIndex, Integer> memoizationDictionary,
                                 MatrixIndex matrixIndex){
        Integer memoizationResult = memoization(matrix, memoizationDictionary, matrixIndex);
        return ""+memoizationResult;
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
                    min(matrix[matrixIndex.getX() + 1][matrixIndex.getY()], matrix[matrixIndex.getX() + 1][matrixIndex.getY()+1]);

        }else {
            MatrixIndex downMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY());
            MatrixIndex rightDownMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY() + 1);

            Integer downElement = memoization(matrix, memoizationDictionary, downMatrixIndex);
            Integer rightDownElement = memoization(matrix, memoizationDictionary, rightDownMatrixIndex);

            result = matrix[matrixIndex.getX()][matrixIndex.getY()] + min(downElement, rightDownElement);
        }
        memoizationDictionary.put(matrixIndex, result);
        return result;
    }


    private static Integer min(Integer firstOperand, Integer secondOperand){
        if(firstOperand < secondOperand){
            return firstOperand;
        }else {
            return secondOperand;
        }
    }
}

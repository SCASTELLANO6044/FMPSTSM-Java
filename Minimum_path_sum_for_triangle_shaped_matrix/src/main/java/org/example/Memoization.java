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
            return memoizationDictionary.get(matrixIndex);
        }
        Integer result;
        if(matrixIndex.getX() == 0 && matrixIndex.getY() == 0){
            result = matrix[0][0];
            memoizationDictionary.put(matrixIndex, matrix[0][0]);
            return result;
        } else if (matrixIndex.getX() == matrix.length - 1) {
            result = min(matrix[matrixIndex.getX()+1][matrixIndex.getY()], matrix[matrixIndex.getX()+1][matrixIndex.getY()+1]);
            memoizationDictionary.put(matrixIndex, result);
            return result;
        }else {
            MatrixIndex downMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY());
            MatrixIndex rightDownMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY() + 1);

            Integer downElement = memoization(matrix, memoizationDictionary, downMatrixIndex);
            Integer rigthDownElement = memoization(matrix, memoizationDictionary, rightDownMatrixIndex);

            result = min(downElement, rigthDownElement);
            memoizationDictionary.put(matrixIndex, result);
        }
        return null;
    }


    private static Integer min(Integer firstOperand, Integer secondOperand){
        if(firstOperand < secondOperand){
            return firstOperand;
        }else {
            return secondOperand;
        }
    }
}

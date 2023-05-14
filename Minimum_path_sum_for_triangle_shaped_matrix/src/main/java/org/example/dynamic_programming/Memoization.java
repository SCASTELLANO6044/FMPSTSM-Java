package org.example.dynamic_programming;

import org.example.utils.MatrixIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memoization {

    private Memoization (){
        throw new IllegalStateException("Utility class");
    }

    public static String execute(int[][] matrix){

        MatrixIndex matrixIndex = new MatrixIndex(0, 0);
        Map<MatrixIndex, Integer> memoizationDictionary = new HashMap<>();

        Integer memoizationResult = memoization(matrix, memoizationDictionary, matrixIndex);

        return "The result value is: "+memoizationResult +
                " and the path chosen is: " +
                pathChosen(matrix, memoizationDictionary);
    }

    private static Integer memoization(int[][] matrix,
                                       Map<MatrixIndex, Integer> memoizationDictionary,
                                       MatrixIndex matrixIndex){

        if(memoizationDictionary.containsKey(matrixIndex)){
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

    private static String pathChosen(int[][]matrix, Map<MatrixIndex, Integer> memoizationDictionary){
        List<MatrixIndex> matrixIndexList = new ArrayList<>(matrix.length);
        MatrixIndex matrixIndex = new MatrixIndex(0,0);
        matrixIndexList.add(matrixIndex);

        while (matrixIndex.getX() != matrix.length - 2) {
            MatrixIndex downMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY());
            MatrixIndex rightDownMatrixIndex = new MatrixIndex(matrixIndex.getX() + 1, matrixIndex.getY() + 1);
            if (memoizationDictionary.get(downMatrixIndex) < memoizationDictionary.get(rightDownMatrixIndex)) {
                matrixIndexList.add(downMatrixIndex);
                matrixIndex = downMatrixIndex;
            } else {
                matrixIndexList.add(rightDownMatrixIndex);
                matrixIndex = rightDownMatrixIndex;
            }
        }
        if(matrix[matrixIndex.getX()+1][matrixIndex.getY()]< matrix[matrixIndex.getX()+1][matrixIndex.getY()+1]){
            matrixIndexList.add(new MatrixIndex(matrixIndex.getX()+1, matrixIndex.getY()));
        }else {
            matrixIndexList.add(new MatrixIndex(matrixIndex.getX()+1, matrixIndex.getY()+1));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (MatrixIndex matrixIndexIterator: matrixIndexList) {
            stringBuilder.append("[").append(matrix[matrixIndexIterator.getX()][matrixIndexIterator.getY()]).append("]");
        }
        return stringBuilder.toString();
    }
}

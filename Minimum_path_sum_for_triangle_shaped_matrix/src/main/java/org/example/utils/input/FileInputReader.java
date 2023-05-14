package org.example.utils.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputReader {
    private FileInputReader (){
        throw new IllegalStateException("Utility class");
    }

    public static int[][] readMatrixFromFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int rows = Integer.parseInt(br.readLine().trim());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            String[] line = br.readLine().trim().split(" ");
            matrix[i] = new int[line.length];
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();
        return matrix;
    }


}

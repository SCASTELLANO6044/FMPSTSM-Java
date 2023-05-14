package org.example;

import org.example.dynamic_programming.Memoization;
import org.example.dynamic_programming.Tabulation;
import org.example.utils.input.FileInputReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int [][] matrix = FileInputReader.readMatrixFromFile("C:\\GitHubProjects\\minimum-path-sum-for-triangle-shaped-matrix\\Minimum_path_sum_for_triangle_shaped_matrix\\input-files\\2.txt");

        String memoization = Memoization.execute(matrix);
        System.out.println("Memoization:\n" + memoization);
        System.out.println("****************************************");

        String tabulation = Tabulation.execute(matrix);
        System.out.println("Tabulation:\n"+ tabulation);
        System.out.println("*****************************************");
    }
}
package org.example;

import org.example.dynamic_programming.Memoization;
import org.example.dynamic_programming.Tabulation;
import org.example.utils.AlphanumericSortComparator;
import org.example.utils.input.FileInputReader;
import org.example.utils.input.Switches;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        if (Switches.contains(args, "-h", "--help")) Switches.help();

        boolean tab = false;
        boolean mem = false;
        boolean both = false;

        if (Arrays.asList(args).contains("-check")) {
            both = true;
        } else if (Switches.contains(args, "-sm", "--memoization")) {
            mem = true;
        } else if (Switches.contains(args, "-st", "--tabulation" )) {
            tab = true;
        }else {
            Switches.help();
        }

        boolean isDirectory = false;
        String path = "";

        if (Switches.contains(args, "-d", "--directory")){
            isDirectory = true;
            path = args[Switches.indexOf(args, "-d", "--directory") + 1];
        } else if (Switches.contains(args, "-f", "--file")) {
            path = args[Switches.indexOf(args, "-f", "--file") + 1];
        }else {
            Switches.help();
        }

        if (isDirectory){
            File f = new File(path);
            String[] files = f.list();
            Comparator<String> numericalOrder = AlphanumericSortComparator.NUMERICAL_ORDER;
            Arrays.sort(files, numericalOrder);
            for(String file : files){
                int [][] matrix = FileInputReader.readMatrixFromFile(path+file);
                if(both){
                    long startTime = System.currentTimeMillis();
                    String memoization = Memoization.execute(matrix);
                    System.out.println(file + ": Memoization:\n" + memoization);
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + finalTime + " ms");
                    System.out.println("****************************************");
                    startTime = System.currentTimeMillis();
                    String tabulation = Tabulation.execute(matrix);
                    System.out.println(file + ": Tabulation:\n"+ tabulation);
                    finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + finalTime + " ms");
                    System.out.println("*****************************************");
                } else if (mem) {
                    long startTime = System.currentTimeMillis();
                    String memoization = Memoization.execute(matrix);
                    System.out.println(file + ": Memoization:\n" + memoization);
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + finalTime + " ms");
                    System.out.println("****************************************");
                } else if (tab){
                    long startTime = System.currentTimeMillis();
                    String tabulation = Tabulation.execute(matrix);
                    System.out.println(file + ": Tabulation:\n"+ tabulation);
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + finalTime + " ms");
                    System.out.println("*****************************************");
                }
            }
        }else {
            int [][] matrix = FileInputReader.readMatrixFromFile(path);
            if(both){
                long startTime = System.currentTimeMillis();
                String memoization = Memoization.execute(matrix);
                System.out.println(path + ": Memoization:\n" + memoization);
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + finalTime + " ms");
                System.out.println("****************************************");
                startTime = System.currentTimeMillis();
                String tabulation = Tabulation.execute(matrix);
                System.out.println(path + ": Tabulation:\n"+ tabulation);
                finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + finalTime + " ms");
                System.out.println("*****************************************");
            } else if (mem) {
                long startTime = System.currentTimeMillis();
                String memoization = Memoization.execute(matrix);
                System.out.println(path + ": Memoization:\n" + memoization);
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + finalTime + " ms");
                System.out.println("****************************************");
            } else if (tab){
                long startTime = System.currentTimeMillis();
                String tabulation = Tabulation.execute(matrix);
                System.out.println(path + ": Tabulation:\n"+ tabulation);
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + finalTime + " ms");
                System.out.println("*****************************************");
            }

        }
    }
}
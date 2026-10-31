package main.java.DSA_introduction.assignment_problems;


import java.util.Scanner;

public class BusiestBusRow {


    public static void findBusiestRow(int[][] grid) {
        int maxTotal = -1;
        int busiestRowIndex = -1;


        for (int r = 0; r < grid.length; r++) {
            int currentRowTotal = 0;


            for (int c = 0; c < grid[r].length; c++) {
                currentRowTotal += grid[r][c];
            }


            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                busiestRowIndex = r;
            }
        }

        System.out.printf("Row %d, Total %d\n", busiestRowIndex, maxTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        findBusiestRow(grid);
        sc.close();
    }
}


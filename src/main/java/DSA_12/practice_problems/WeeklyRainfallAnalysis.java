package main.java.DSA_12.practice_problems;

import java.util.Scanner;

public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rainfall = new double[7];

        for (int i = 0; i < 7; i++) {
            if (sc.hasNextDouble()) {
                rainfall[i] = sc.nextDouble();
            }
        }

        double total = 0.0;
        int wettestIndex = 0;
        int dryDays = 0;

        StringBuilder listOutput = new StringBuilder("Rainfall (mm):");
        for (int i = 0; i < 7; i++) {
            listOutput.append(" ").append(rainfall[i]);
            total += rainfall[i];

            if (rainfall[i] > rainfall[wettestIndex]) {
                wettestIndex = i;
            }
            if (rainfall[i] == 0.0) {
                dryDays++;
            }
        }

        double average = total / 7.0;

        System.out.println(listOutput);
        System.out.println("Total Rainfall: " + total + " mm");
        System.out.printf("Average Rainfall: %.2f mm%n", average);
        System.out.println("Wettest Day: Day " + (wettestIndex + 1) + " (" + rainfall[wettestIndex] + " mm)");
        System.out.println("Total Dry Days: " + dryDays);
        sc.close();
    }
}

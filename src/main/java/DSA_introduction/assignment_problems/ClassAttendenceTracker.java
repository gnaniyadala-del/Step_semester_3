package main.java.DSA_introduction.assignment_problems;


import java.util.Scanner;

public class ClassAttendenceTracker {


    public static void attendanceSummary(int[] days) {
        int totalPresent = 0;
        int currentStreak = 0;
        int longestStreak = 0;


        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {

                currentStreak = 0;
            }
        }

        System.out.printf("Present: %d, Longest streak: %d\n", totalPresent, longestStreak);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        attendanceSummary(days);
        sc.close();
    }
}

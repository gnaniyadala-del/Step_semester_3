package main.java.DSA_introduction.assignment_problems;

import java.util.Scanner;

public class DutyRosterRotation {


    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];


        k = k % n;


        for (int i = 0; i < n; i++) {
            int newPosition = (i + k) % n;
            rotated[newPosition] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        String[] result = rotateRoster(names, k);


        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }
}


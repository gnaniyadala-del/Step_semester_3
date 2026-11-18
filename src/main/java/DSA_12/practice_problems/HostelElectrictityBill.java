package main.java.DSA_12.practice_problems;

import java.util.Scanner;

public class HostelElectrictityBill {
    public static int calculateBill(int units) {
        int charge;
        if (units <= 100) {
            charge = units * 3;
        } else if (units <= 200) {
            charge = (100 * 3) + ((units - 100) * 5);
        } else {
            charge = (100 * 3) + (100 * 5) + ((units - 200) * 8);
        }
        return charge + 50; // Add fixed meter charge of 50
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int roomsBilled = 0;
        int blockTotal = 0;

        for (int i = 0; i < n; i++) {
            String room = sc.next();
            int reading = sc.nextInt();

            if (reading < 0) {
                System.out.println(room + ": invalid reading");
            } else {
                int bill = calculateBill(reading);
                roomsBilled++;
                blockTotal += bill;
                System.out.println(room + ": " + reading + " units, bill " + bill);
            }
        }

        System.out.println("Rooms billed " + roomsBilled + ", total " + blockTotal);
        sc.close();
    }
}

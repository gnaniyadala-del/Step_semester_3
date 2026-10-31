package main.java.DSA_introduction.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String input = sc.nextLine().trim();
        input = input.replaceAll("[\\[\\]\\s]", "");
        if (input.isEmpty()) return;

        String[] tokens = input.split(",");
        int even = 0, odd = 0;

        for (String token : tokens) {
            int num = Integer.parseInt(token);
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}

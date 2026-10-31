package main.java.DSA_introduction.practice_problems;


import java.util.Scanner;

public class WordRerverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String original = sc.next();
            String reversed = new StringBuilder(original).reverse().toString();

            if (original.equals(reversed)) {
                System.out.println(original + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }
        sc.close();
    }
}


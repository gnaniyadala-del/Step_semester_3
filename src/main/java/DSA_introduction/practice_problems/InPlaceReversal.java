package main.java.DSA_introduction.practice_problems;


import java.util.Scanner;

public class InPlaceReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String input = sc.nextLine().trim();
        input = input.replaceAll("[\\[\\]\\s]", "");
        if (input.isEmpty()) return;

        String[] array = input.split(",");
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            String temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}

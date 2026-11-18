package main.java.Sorting_Algorithm.assignment_problems;

import java.util.Arrays;

public class LibraryBookShelf {
    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        for (int i = 1; i < books.length; i++) {
            int newBook = books[i];
            int j = i - 1;

            // Shift larger books on the left one position to the right
            while (j >= 0 && books[j] > newBook) {
                books[j + 1] = books[j];
                j--;
            }

            // Place the new book into its sorted position
            books[j + 1] = newBook;

            System.out.println("After placing " + newBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Input ---");
        shelf(new int[]{30, 10, 40, 20});

        System.out.println("\n--- Custom Test Case ---");
        shelf(new int[]{25, 15, 5, 35, 20});
    }
}

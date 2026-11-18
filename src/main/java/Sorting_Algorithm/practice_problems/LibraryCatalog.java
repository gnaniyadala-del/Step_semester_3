package main.java.Sorting_Algorithm.assignment_problems;

import java.util.List;

public class LibraryCatalog {
    public record Book(String isbn, String title) {}

    public static String findBook(List<Book> catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = catalog.get(mid);
            int cmp = midBook.isbn().compareTo(targetIsbn);

            if (cmp == 0) {
                return midBook.title();
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        List<Book> catalog = List.of(
                new Book("0001112223", "Introduction to Algebra"),
                new Book("0002223334", "Beginning Python"),
                new Book("0003334445", "Classic Mythology"),
                new Book("0004445556", "Data and Society"),
                new Book("0005556667", "European History")
        );

        System.out.println(findBook(catalog, "0003334445")); // Expected: Classic Mythology
        System.out.println(findBook(catalog, "0009998887")); // Expected: Not Found
    }
}

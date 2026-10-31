package main.java.OOP_concepts2.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() { return title; }
    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.00;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = daysLate * 5.00;
        return Math.min(fine, 50.00); // Caps fine calculation at 50
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.00;
    }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            switch (type) {
                case "BOOK" -> items.add(new BookItem(title, daysLate));
                case "DVD" -> items.add(new DVDItem(title, daysLate));
                case "MAGAZINE" -> items.add(new MagazineItem(title, daysLate));
            }
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f\n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        sc.close();
    }
}


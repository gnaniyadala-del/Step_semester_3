package main.java.OOP_concepts.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;
    protected static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate();
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(3);
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            // Using regex to handle titles wrapped in quotes or multiple words safely
            String title = scanner.findInLine("\"([^\"]*)\"");
            if (title == null) {
                title = scanner.next();
            } else {
                title = title.replaceAll("\"", "");
            }

            switch (type) {
                case "BOOK":
                    items.add(new BookItem(title));
                    break;
                case "DVD":
                    items.add(new DVDItem(title));
                    break;
                case "MAGAZINE":
                    items.add(new MagazineItem(title));
                    break;
            }
        }

        for (LibraryItem item : items) {
            System.out.printf("%s: %s\n", item.getTitle(), item.calculateDueDate().toString());
        }
        scanner.close();
    }
}


package main.java.Class_Objects.class_problems;


    class IdCard {
        String name;
        int booksIssued;

        // Constructor
        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public class MainM4 {
        public static void main(String[] args) {
            IdCard ravi = new IdCard("Ravi", 0);

            // Assign a second variable to point to the same object reference
            IdCard duplicate = ravi;

            // Modify field through the second variable
            duplicate.booksIssued = 3;

            // Print values and comparisons
            System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
            System.out.println("duplicate == ravi: " + (duplicate == ravi));

            // Create a separate object with identical values
            IdCard separate = new IdCard("Ravi", 3);
            System.out.println("separate == ravi: " + (separate == ravi));
        }
    }



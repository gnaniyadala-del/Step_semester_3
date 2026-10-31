package main.java.OOP_concepts.assignment_problems;



import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}


class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }
}


class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }
}


class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.00; // Full amount + ₹10 service charge
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();


            switch (type) {
                case "STUDENT":
                    bills.add(new StudentCustomer(amount));
                    break;
                case "STAFF":
                    bills.add(new StaffCustomer(amount));
                    break;
                case "GUEST":
                    bills.add(new GuestCustomer(amount));
                    break;
            }
        }

        double grandTotal = 0;

        for (Customer customer : bills) {
            double finalAmount = customer.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", customer.getCustomerType(), finalAmount);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}


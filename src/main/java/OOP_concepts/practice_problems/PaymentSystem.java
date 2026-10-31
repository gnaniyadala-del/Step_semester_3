package main.java.OOP_concepts.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract Base Class
abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
    public abstract String getPaymentType();
}


class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% fee added
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}


class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% fee added
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}


class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount; // No processing fee
    }

    @Override
    public String getPaymentType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<PaymentMethod> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            switch (type) {
                case "CARD":
                    transactions.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    transactions.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    transactions.add(new BankTransferPayment(amount));
                    break;
            }
        }

        double grandTotal = 0;

        for (PaymentMethod tx : transactions) {
            double adjusted = tx.calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f\n", tx.getPaymentType(), adjusted);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}


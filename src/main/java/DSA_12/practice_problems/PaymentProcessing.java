package main.java.DSA_12.practice_problems;

import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
    String getModeName();
}

class CashPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }

    @Override
    public String getModeName() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount + (amount * 0.02);
    }

    @Override
    public String getModeName() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }

    @Override
    public String getModeName() {
        return "UPI";
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        PaymentMode[] modes = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();

            if (mode.equalsIgnoreCase("Cash")) {
                modes[i] = new CashPayment();
            } else if (mode.equalsIgnoreCase("Card")) {
                modes[i] = new CardPayment();
            } else {
                modes[i] = new UpiPayment();
            }
        }

        double totalProcessed = 0.0;
        for (int i = 0; i < n; i++) {
            double processed = modes[i].processPayment(amounts[i]);
            double fee = processed - amounts[i];
            totalProcessed += processed;

            System.out.println(modes[i].getModeName() + ": amount " + amounts[i]
                    + ", fee " + fee + ", processed " + processed);
        }
        System.out.println("Total Amount Processed: " + totalProcessed);
        sc.close();
    }
}


package main.java.OOP_concepts.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getDeliveryType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getDeliveryType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getDeliveryType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    // Encapsulating unique customs fee property inside the sub-class context
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getDeliveryType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFreeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            if (type.equals("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customsFee));
            } else if (type.equals("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else if (type.equals("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, distance));
            }
        }

        double grandTotalFee = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            grandTotalFee += fee;
            System.out.printf("%s: %.2f\n", d.getDeliveryType(), fee);
        }

        System.out.printf("Total: %.2f\n", grandTotalFee);
        scanner.close();
    }
}


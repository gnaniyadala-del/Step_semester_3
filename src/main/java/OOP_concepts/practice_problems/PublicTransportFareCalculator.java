package main.java.OOP_concepts.practice_problems;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Journey {
    protected double distance;

    public Journey(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTransportType();
}

class BusJourney extends Journey {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return distance * 2.5; // Example base rate for Bus
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }
}

class TrainJourney extends Journey {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return distance * 4.0; // Example base rate for Train
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (distance * 5.0) * peakHourFactor; // Base rate scaled by peak factor
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Journey> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            if (type.equals("METRO")) {
                double peakHourFactor = scanner.nextDouble();
                journeys.add(new MetroJourney(distance, peakHourFactor));
            } else if (type.equals("BUS")) {
                journeys.add(new BusJourney(distance));
            } else if (type.equals("TRAIN")) {
                journeys.add(new TrainJourney(distance));
            }
        }

        double totalFare = 0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();
            totalFare += fare;
            System.out.printf("%s: %.2f\n", j.getTransportType(), fare);
        }

        System.out.printf("Total Fare: %.2f\n", totalFare);
        scanner.close();
    }
}


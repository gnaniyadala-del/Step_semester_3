package main.java.OOP_concepts2.assignment_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Capability check interface
interface NightServiceSupported {}

abstract class CabTrip {
    protected double km;
    protected String timeOfDay;

    public CabTrip(double km, String timeOfDay) {
        this.km = km;
        this.timeOfDay = timeOfDay;
    }

    public abstract double getRatePerKm();
    public abstract String getCabType();

    public double calculateFare() throws UnsupportedOperationException {
        // Enforce capabilities checking polymorphically
        if (timeOfDay.equalsIgnoreCase("NIGHT") && !(this instanceof NightServiceSupported)) {
            throw new UnsupportedOperationException("night service not available");
        }

        double baseFare = km * getRatePerKm();
        if (baseFare < 100.00) {
            baseFare = 100.00; // Enforce minimum floor limit
        }

        if (timeOfDay.equalsIgnoreCase("NIGHT")) {
            baseFare *= 1.20; // 20% premium surcharge
        }
        return baseFare;
    }
}

class MiniCab extends CabTrip {
    public MiniCab(double km, String timeOfDay) { super(km, timeOfDay); }
    @Override public double getRatePerKm() { return 10.00; }
    @Override public String getCabType() { return "MINI"; }
}

class SedanCab extends CabTrip implements NightServiceSupported {
    public SedanCab(double km, String timeOfDay) { super(km, timeOfDay); }
    @Override public double getRatePerKm() { return 14.00; }
    @Override public String getCabType() { return "SEDAN"; }
}

class SUVCab extends CabTrip implements NightServiceSupported {
    public SUVCab(double km, String timeOfDay) { super(km, timeOfDay); }
    @Override public double getRatePerKm() { return 18.00; }
    @Override public String getCabType() { return "SUV"; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        List<CabTrip> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] tokens = line.split("\\s+");
            String cabType = tokens[0];
            double km = Double.parseDouble(tokens[1]);
            String timeOfDay = tokens[2];

            switch (cabType) {
                case "MINI" -> trips.add(new MiniCab(km, timeOfDay));
                case "SEDAN" -> trips.add(new SedanCab(km, timeOfDay));
                case "SUV" -> trips.add(new SUVCab(km, timeOfDay));
            }
        }

        double grandTotal = 0;
        for (CabTrip trip : trips) {
            try {
                double fare = trip.calculateFare();
                grandTotal += fare;
                System.out.printf("%s: %.2f\n", trip.getCabType(), fare);
            } catch (UnsupportedOperationException e) {
                System.out.printf("%s: %s\n", trip.getCabType(), e.getMessage());
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}


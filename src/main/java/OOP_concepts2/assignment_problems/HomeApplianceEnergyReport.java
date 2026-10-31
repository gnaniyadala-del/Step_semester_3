package main.java.OOP_concepts2.assignment_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

interface SaverModeSupported {}

abstract class Appliance {
    protected double hours;
    protected boolean isSaverRequested;

    public Appliance(double hours, boolean isSaverRequested) {
        this.hours = hours;
        this.isSaverRequested = isSaverRequested;
    }

    public abstract double getPowerRating();
    public abstract String getName();

    public double calculateUnits() throws UnsupportedOperationException {
        if (isSaverRequested && !(this instanceof SaverModeSupported)) {
            throw new UnsupportedOperationException("saver mode not supported");
        }

        double units = (getPowerRating() * hours) / 1000.0;
        if (isSaverRequested) {
            units *= 0.75; // 25% energy reduction adjustment
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8.00;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saver) { super(hours, saver); }
    @Override public double getPowerRating() { return 150.0; }
    @Override public String getName() { return "FRIDGE"; }
}

class AirConditioner extends Appliance implements SaverModeSupported {
    public AirConditioner(double hours, boolean saver) { super(hours, saver); }
    @Override public double getPowerRating() { return 1500.0; }
    @Override public String getName() { return "AC"; }
}

class Television extends Appliance {
    public Television(double hours, boolean saver) { super(hours, saver); }
    @Override public double getPowerRating() { return 100.0; }
    @Override public String getName() { return "TV"; }
}

class WashingMachine extends Appliance implements SaverModeSupported {
    public WashingMachine(double hours, boolean saver) { super(hours, saver); }
    @Override public double getPowerRating() { return 500.0; }
    @Override public String getName() { return "WASHER"; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Appliance> appliances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean saverRequested = (tokens.length == 3 && tokens[2].equalsIgnoreCase("SAVER"));

            switch (type) {
                case "FRIDGE" -> appliances.add(new Fridge(hours, saverRequested));
                case "AC" -> appliances.add(new AirConditioner(hours, saverRequested));
                case "TV" -> appliances.add(new Television(hours, saverRequested));
                case "WASHER" -> appliances.add(new WashingMachine(hours, saverRequested));
            }
        }

        double totalCost = 0;
        for (Appliance app : appliances) {
            try {
                double units = app.calculateUnits();
                double cost = app.calculateCost(units);
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getName(), units, cost);
            } catch (UnsupportedOperationException e) {
                System.out.printf("%s: %s\n", app.getName(), e.getMessage());
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}


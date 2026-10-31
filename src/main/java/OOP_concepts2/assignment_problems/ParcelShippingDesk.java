package main.java.OOP_concepts2.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Interface segregation: separating the concept of generic parcel from an insurable one
interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public abstract String getType();

    // Default structural template hook to calculate insurance without hardcoding class types
    public double getInsuranceAmount() {
        if (this instanceof Insurable insurableParcel) {
            return insurableParcel.calculateInsurance(this.declaredValue);
        }
        return 0.00;
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override public double calculateCharge() { return 40.0 + (10.0 * weight); }
    @Override public String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override public double calculateCharge() { return 80.0 + (15.0 * weight); }
    @Override public String getType() { return "EXPRESS"; }
    @Override public double calculateInsurance(double value) { return value * 0.02; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    @Override public double calculateCharge() { return (40.0 + 10.0 * weight) + 50.0; } // Standard charge + 50 handling
    @Override public String getType() { return "FRAGILE"; }
    @Override public double calculateInsurance(double value) { return value * 0.02; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            switch (type) {
                case "STANDARD" -> parcels.add(new StandardParcel(weight, value));
                case "EXPRESS" -> parcels.add(new ExpressParcel(weight, value));
                case "FRAGILE" -> parcels.add(new FragileParcel(weight, value));
            }
        }

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = p.getInsuranceAmount();
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}


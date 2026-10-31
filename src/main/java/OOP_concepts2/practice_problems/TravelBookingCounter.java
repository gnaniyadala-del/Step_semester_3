package main.java.OOP_concepts2.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class TravelBooking {
    protected double distanceKm;

    private static final double BOOKING_FEE = 50.00;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();
    public abstract String getMode();


    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) { super(distanceKm); }
    @Override public double calculateBaseFare() { return distanceKm * 2.00; }
    @Override public String getMode() { return "BUS"; }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) { super(distanceKm); }
    @Override public double calculateBaseFare() { return distanceKm * 1.50; }
    @Override public String getMode() { return "TRAIN"; }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) { super(distanceKm); }
    @Override public double calculateBaseFare() { return 2500.00 + (distanceKm * 4.00); }
    @Override public String getMode() { return "FLIGHT"; }
}

public class TravelBookingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            switch (mode) {
                case "BUS" -> bookings.add(new BusBooking(distance));
                case "TRAIN" -> bookings.add(new TrainBooking(distance));
                case "FLIGHT" -> bookings.add(new FlightBooking(distance));
            }
        }


        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f\n", booking.getMode(), booking.calculateTotalFare());
        }
        sc.close();
    }
}


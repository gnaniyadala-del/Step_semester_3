package main.java.OOP_concepts2.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract Base Class modeling the shared convenience fee logic
abstract class SeatBooking {
    protected int count;
    // Convenience fee is placed in one location only
    private static final double CONVENIENCE_FEE = 20.00;

    public SeatBooking(int count) {
        this.count = count;
    }

    public abstract double getBasePricePerTicket();
    public abstract String getSeatType();

    // The shared calculation logic written in one place
    public double calculateAmount() {
        return count * (getBasePricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularBooking extends SeatBooking {
    public RegularBooking(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 150.00; }
    @Override public String getSeatType() { return "REGULAR"; }
}

class PremiumBooking extends SeatBooking {
    public PremiumBooking(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 250.00; }
    @Override public String getSeatType() { return "PREMIUM"; }
}

class ReclinerBooking extends SeatBooking {
    public ReclinerBooking(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 400.00; }
    @Override public String getSeatType() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<SeatBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            switch (type) {
                case "REGULAR" -> bookings.add(new RegularBooking(count));
                case "PREMIUM" -> bookings.add(new PremiumBooking(count));
                case "RECLINER" -> bookings.add(new ReclinerBooking(count));
            }
        }

        double total = 0;
        for (SeatBooking booking : bookings) {
            double amount = booking.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f\n", booking.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}


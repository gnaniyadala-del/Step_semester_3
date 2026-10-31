package main.java.OOP_concepts2.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getConnectionType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) { super(units); }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.00;
        } else {
            return (100 * 5.00) + ((units - 100) * 7.00);
        }
    }

    @Override
    public String getConnectionType() { return "HOME"; }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) { super(units); }

    @Override
    public double calculateBill() {
        return (units * 8.00) + 100.00; // 8 per unit + 100 fixed charge
    }

    @Override
    public String getConnectionType() { return "SHOP"; }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) { super(units); }

    @Override
    public double calculateBill() {
        double baseBill = units * 6.00;
        return Math.max(baseBill, 1000.00); // Minimum charge floor limit
    }

    @Override
    public String getConnectionType() { return "FACTORY"; }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            switch (type) {
                case "HOME" -> connections.add(new HomeConnection(units));
                case "SHOP" -> connections.add(new ShopConnection(units));
                case "FACTORY" -> connections.add(new FactoryConnection(units));
            }
        }

        double totalBilled = 0;
        for (Connection conn : connections) {
            double bill = conn.calculateBill();
            totalBilled += bill;
            System.out.printf("%s: %.2f\n", conn.getConnectionType(), bill);
        }
        System.out.printf("Total: %.2f\n", totalBilled);
        sc.close();
    }
}


package main.java.OOP_concepts.assignment_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getRoomType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    // Notice that the extra parameter 'occupants' is captured neatly inside its own constructor context!
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }

    @Override
    public String getRoomType() {
        return "AC";
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("AC")) {
                rooms.add(new ACRoom(units));
            }
        }

        double grandTotal = 0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", room.getRoomType(), bill);
        }

        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}


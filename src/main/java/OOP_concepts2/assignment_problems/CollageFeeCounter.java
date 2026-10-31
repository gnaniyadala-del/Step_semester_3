package main.java.OOP_concepts2.assignment_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Student {
    protected String name;
    private static final double TRANSPORT_FEE = 12000.00;

    public Student(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public abstract double getTuitionFee();
    public abstract boolean usesCollegeBus(); // Allows the counter to know without parsing the class name directly

    public double calculateTotalFee() {
        double fee = getTuitionFee();
        if (usesCollegeBus()) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends Student {
    public DayScholar(String name) { super(name); }
    @Override public double getTuitionFee() { return 40000.00; }
    @Override public boolean usesCollegeBus() { return true; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override public double getTuitionFee() { return 40000.00 + 60000.00; } // Tuition + Hostel Fee
    @Override public boolean usesCollegeBus() { return false; }
}

class ScholarshipStudent extends Student {
    public ScholarshipStudent(String name) { super(name); }
    @Override public double getTuitionFee() { return 20000.00; } // Half Tuition
    @Override public boolean usesCollegeBus() { return true; }
}

public class CollageFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "DAY_SCHOLAR" -> students.add(new DayScholar(name));
                case "HOSTELLER" -> students.add(new Hosteller(name));
                case "SCHOLAR" -> students.add(new ScholarshipStudent(name));
            }
        }

        double totalCollected = 0;
        for (Student s : students) {
            double totalFee = s.calculateTotalFee();
            totalCollected += totalFee;
            System.out.printf("%s: %.2f\n", s.getName(), totalFee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}


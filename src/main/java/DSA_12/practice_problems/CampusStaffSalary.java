package main.java.DSA_12.practice_problems;

import java.util.Scanner;

class Staff {
    protected String name;
    protected double baseSalary;

    public Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return 0.0;
    }

    public String getType() {
        return "Staff";
    }
}

class Teacher extends Staff {
    public Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 5000.0;
    }

    @Override
    public String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    public LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return 2000.0;
    }

    @Override
    public String getType() {
        return "LabAssistant";
    }
}

public class CampusStaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();

            if (type.equals("Teacher")) {
                staffList[i] = new Teacher(name, base);
            } else if (type.equals("LabAssistant")) {
                staffList[i] = new LabAssistant(name, base);
            } else {
                staffList[i] = new Staff(name, base);
            }
        }

        double grandTotal = 0.0;
        for (Staff s : staffList) {
            double bonus = s.getBonus();
            double total = s.baseSalary + bonus;
            grandTotal += total;
            System.out.println(s.name + " (" + s.getType() + "): base " + s.baseSalary
                    + ", bonus " + bonus + ", total " + total);
        }
        System.out.println("Grand Total Salary: " + grandTotal);
        sc.close();
    }
}

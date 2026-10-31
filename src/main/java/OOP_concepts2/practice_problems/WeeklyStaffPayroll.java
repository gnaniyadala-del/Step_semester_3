package main.java.OOP_concepts2.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract Base Class prevents instantiation of a generic "staff member"
abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            switch (type) {
                case "FULLTIME" -> staffList.add(new FullTimeStaff(name, sc.nextDouble()));
                case "HOURLY" -> staffList.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()));
                case "INTERN" -> staffList.add(new InternStaff(name, sc.nextDouble()));
            }
        }

        double totalPayroll = 0;
        for (Staff staff : staffList) {
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", staff.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        sc.close();
    }
}


package main.java.OOP_concepts.assignment_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {
    public Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.00; // Fixed flat bonus
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            switch (type) {
                case "FULLTIME":
                    employees.add(new FullTimeEmployee(name, salary));
                    break;
                case "PARTTIME":
                    employees.add(new PartTimeEmployee(name, salary));
                    break;
                case "INTERN":
                    employees.add(new Intern(name, salary));
                    break;
            }
        }

        double totalBonus = 0;
        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f\n", employee.getName(), bonus);
        }

        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        scanner.close();
    }
}


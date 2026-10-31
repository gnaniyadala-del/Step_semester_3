package main.java.OOP_concepts2.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract Base Class modeling the shared property
abstract class GardenPlot {
    protected String owner;

    public GardenPlot(String owner) {
        this.owner = owner;
    }

    public String getOwner() { return owner; }
    public abstract double calculateArea();
    public abstract String getShapeName();
}

class CirclePlot extends GardenPlot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShapeName() { return "CIRCLE"; }
}

class RectanglePlot extends GardenPlot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getShapeName() { return "RECTANGLE"; }
}

class TrianglePlot extends GardenPlot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShapeName() { return "TRIANGLE"; }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<GardenPlot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            switch (shape) {
                case "CIRCLE" -> plots.add(new CirclePlot(owner, sc.nextDouble()));
                case "RECTANGLE" -> plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()));
                case "TRIANGLE" -> plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()));
            }
        }

        double totalArea = 0;
        for (GardenPlot plot : plots) {
            double area = plot.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f\n", plot.getOwner(), plot.getShapeName(), area);
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}


package main.java.string.class_problems;

import java.util.Random;
public class bmiCalculatorTeam {




        public static void main(String[] args) {
            int teamSize = 10; // Suggested N = 10
            double[] heights = new double[teamSize];
            double[] weights = new double[teamSize];


            Random random = new Random();



            for (int i = 0; i < teamSize; i++) {
                heights[i] = 1.50 + (random.nextDouble() * 0.45);
                weights[i] = 50.0 + (random.nextDouble() * 60.0);
            }


            printWellnessReport(heights, weights);
        }


        public static void printWellnessReport(double[] heights, double[] weights) {
            System.out.println("=====================================================================");
            System.out.println("                      CORPORATE WELLNESS REPORT                      ");
            System.out.println("=====================================================================");
            System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s\n",
                    "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
            System.out.println("---------------------------------------------------------------------");

            for (int i = 0; i < heights.length; i++) {
                double height = heights[i];
                double weight = weights[i];


                double bmi = weight / (height * height);
                String status = getBmiStatus(bmi);


                System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-15s\n",
                        (i + 1), height, weight, bmi, status);
            }
            System.out.println("=====================================================================");
        }


        public static String getBmiStatus(double bmi) {
            if (bmi < 18.5) {
                return "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                return "Normal";
            } else if (bmi >= 25.0 && bmi <= 29.9) {
                return "Overweight";
            } else {
                return "Obese";
            }
        }


}

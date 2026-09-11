package OOP_Fundamentals.class_problems;


    public class SeatingOptimizer {
        // Reusable private helper method computing exact row mean average
        private static double rowAverage(int[] row) {
            if (row.length == 0) return 0.0;
            double sum = 0;
            for (int val : row) {
                sum += val;
            }
            return sum / row.length;
        }

        public static String classifyRows(int[][] seatingScores, int threshold) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < seatingScores.length; i++) {
                // Fetch precise row average via our helper method
                double avg = rowAverage(seatingScores[i]);

                String status = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

                result.append("Row ").append(i).append(": ").append(status);
                if (i < seatingScores.length - 1) {
                    result.append(" | ");
                }
            }

            return result.toString();
        }

        public static void main(String[] args) {
            int[][] seating = {
                    {40, 50, 45},
                    {85, 90, 95},
                    {30, 20, 25}
            };
            int threshold = 60;
            System.out.println(classifyRows(seating, threshold));
            // Output: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
        }
    }



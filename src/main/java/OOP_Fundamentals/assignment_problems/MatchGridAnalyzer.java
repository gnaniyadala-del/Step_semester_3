package OOP_Fundamentals.assignment_problems;


    public class MatchGridAnalyzer {
        // Reusable private helper method computing exact row average
        private static double rowAverage(int[] row) {
            if (row.length == 0) return 0.0;
            double sum = 0;
            for (int val : row) {
                sum += val;
            }
            return sum / row.length;
        }

        public static String classifyMatches(int[][] runsPerOver, int threshold) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < runsPerOver.length; i++) {
                // Fetch precise row average via our helper method
                double avg = rowAverage(runsPerOver[i]);

                String status = (avg >= threshold) ? "Power Surge" : "Normal";

                result.append("Match ").append(i).append(": ").append(status);
                if (i < runsPerOver.length - 1) {
                    result.append(" | ");
                }
            }

            return result.toString();
        }

        public static void main(String[] args) {
            int[][] runs = {
                    {4, 6, 8},
                    {10, 12, 14},
                    {2, 3, 1}
            };
            int threshold = 8;
            System.out.println(classifyMatches(runs, threshold));
            // Output: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
        }
    }



package OOP_Fundamentals.class_problems;


    import java.util.Arrays;

    public class PodiumFinder {
        public static int[] findTopThreeScores(int[] scores) {
            // Initialize running tracking variables to the absolute minimum integer value
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            int third = Integer.MIN_VALUE;

            for (int score : scores) {
                // New absolute maximum score found
                if (score > first) {
                    third = second;
                    second = first;
                    first = score;
                }
                // Score falls between 1st and 2nd place
                else if (score > second) {
                    third = second;
                    second = score;
                }
                // Score falls between 2nd and 3rd place
                else if (score > third) {
                    third = score;
                }
            }

            return new int[]{first, second, third};
        }

        public static void main(String[] args) {
            int[] scores = {45, 82, 79, 90, 33, 90, 61};
            int[] topThree = findTopThreeScores(scores);
            System.out.println(Arrays.toString(topThree)); // Output: [90, 90, 82]
        }
    }



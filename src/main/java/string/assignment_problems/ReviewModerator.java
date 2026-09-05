package main.java.string.assignment_problems;


    public class ReviewModerator {

        public static void main(String[] args) {

            String sampleReview = "This movie was absolutely fantastic and thrilling";

            System.out.println("Testing Input: \"" + sampleReview + "\"");
            classifyWordLengths(sampleReview);
        }


        public static void classifyWordLengths(String review) {
            // Edge case: Handle empty or null strings safely
            if (review == null || review.trim().isEmpty()) {
                System.out.println("Short: 0 | Medium: 0 | Long: 0");
                return;
            }


            String[] words = review.split("\\s+");

            int shortCount = 0;
            int mediumCount = 0;
            int longCount = 0;


            for (String word : words) {
                int length = word.length();

                if (length >= 1 && length <= 4) {
                    shortCount++;
                } else if (length >= 5 && length <= 8) {
                    mediumCount++;
                } else if (length >= 9) {
                    longCount++;
                }
            }


            System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
        }
    }



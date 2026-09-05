package main.java.string.assignment_problems;

public class SpeedTestChecker {


        public static void main(String[] args) {

            String original1 = "hello world";
            String typed1 = "hello worlf";
            System.out.println("--- Test Case 1 ---");
            checkTypingAccuracy(original1, typed1);

            System.out.println("\n------------------------------------------------------------\n");


            String original2 = "coding";
            String typed2 = "coding";
            System.out.println("--- Test Case 2 ---");
            checkTypingAccuracy(original2, typed2);
        }


        public static void checkTypingAccuracy(String original, String typed) {
            int totalCharacters = original.length();
            int matchedCount = 0;
            int firstMismatchPosition = -1; // -1 acts as a flag indicating no mismatch found yet


            for (int i = 0; i < totalCharacters; i++) {
                char origChar = original.charAt(i);
                char typedChar = typed.charAt(i);

                if (origChar == typedChar) {
                    matchedCount++;
                } else {
                    // If it's the first mismatch, capture its 1-based position index
                    if (firstMismatchPosition == -1) {
                        firstMismatchPosition = i + 1;
                    }
                }
            }


            double accuracyPercentage = ((double) matchedCount / totalCharacters) * 100;


            System.out.print("Matched: " + matchedCount + "/" + totalCharacters + " | ");
            System.out.printf("Accuracy: %.2f%% | ", accuracyPercentage);

            if (firstMismatchPosition == -1) {
                System.out.println("No Mismatches");
            } else {

                int mismatchIdx = firstMismatchPosition - 1;
                System.out.println("First Mismatch at position " + firstMismatchPosition +
                        " ('" + original.charAt(mismatchIdx) + "' vs '" + typed.charAt(mismatchIdx) + "')");
            }
        }
    }



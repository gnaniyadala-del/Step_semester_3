package main.java.string.assignment_problems;


    public class TrafficSignalTracker {

        public static void main(String[] args) {
            // Test Case 1
            String log1 = "RRGGGYRR";
            System.out.println("Testing Input: \"" + log1 + "\"");
            findLongestStreak(log1);

            System.out.println("\n------------------------------------\n");

            // Test Case 2
            String log2 = "RRRRYYGG";
            System.out.println("Testing Input: \"" + log2 + "\"");
            findLongestStreak(log2);
        }


        public static void findLongestStreak(String signalLog) {
            // Edge case: Handle empty or null strings safely
            if (signalLog == null || signalLog.isEmpty()) {
                System.out.println("No signal data recorded.");
                return;
            }


            char longestColor = signalLog.charAt(0);
            int maxStreak = 1;


            char currentColor = signalLog.charAt(0);
            int currentStreak = 1;


            for (int i = 1; i < signalLog.length(); i++) {
                char nextColor = signalLog.charAt(i);

                if (nextColor == currentColor) {

                    currentStreak++;
                } else {

                    if (currentStreak > maxStreak) {
                        maxStreak = currentStreak;
                        longestColor = currentColor;
                    }
                    // Reset tracker for the new sequence
                    currentColor = nextColor;
                    currentStreak = 1;
                }
            }


            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                longestColor = currentColor;
            }


            System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxStreak + " times");
        }
    }



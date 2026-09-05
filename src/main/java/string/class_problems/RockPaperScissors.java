package main.java.string.class_problems;


    import java.util.Random;
    import java.util.Scanner;

    public class RockPaperScissors {

        // Main method to control the game flow
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int totalRounds = 5; // Suggested N = 5

            // Arrays to store history for the final summary table
            String[] playerMovesHistory = new String[totalRounds];
            String[] computerMovesHistory = new String[totalRounds];
            String[] resultsHistory = new String[totalRounds];

            // Valid choices for the computer
            String[] choices = {"Rock", "Paper", "Scissors"};

            // Counters for the final statistics
            int wins = 0;
            int losses = 0;
            int draws = 0;

            System.out.println("=== Welcome to the College Coding Arcade: Rock-Paper-Scissors ===");

            for (int i = 0; i < totalRounds; i++) {
                System.out.println("\n--- Round " + (i + 1) + " ---");

                // 1. Get validated Player Move
                String playerMove = "";
                while (true) {
                    System.out.print("Enter your move (Rock, Paper, Scissors): ");
                    playerMove = scanner.nextLine().trim();

                    // Capitalize first letter to match standard formatting
                    if (!playerMove.isEmpty()) {
                        playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();
                    }

                    if (playerMove.equals("Rock") || playerMove.equals("Paper") || playerMove.equals("Scissors")) {
                        break;
                    }
                    System.out.println("Invalid input! Please type Rock, Paper, or Scissors.");
                }

                // 2. Generate Random Computer Move
                int randomIndex = random.nextInt(3);
                String computerMove = choices[randomIndex];

                // 3. Play the round and evaluate the winner
                String result = playRound(playerMove, computerMove);
                System.out.println("Computer chose: " + computerMove);
                System.out.println("Result: " + result);

                // 4. Update stats counter
                if (result.equals("Player Wins")) {
                    wins++;
                } else if (result.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }

                // 5. Store data for final summary table
                playerMovesHistory[i] = playerMove;
                computerMovesHistory[i] = computerMove;
                resultsHistory[i] = result;
            }

            // 6. Print Final Summary Table
            System.out.println("\n========================================================");
            System.out.println("                     FINAL SUMMARY                      ");
            System.out.println("========================================================");
            System.out.printf("%-10s | %-12s | %-13s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
            System.out.println("--------------------------------------------------------");
            for (int i = 0; i < totalRounds; i++) {
                System.out.printf("Round %-4d | %-12s | %-13s | %-15s\n",
                        (i + 1), playerMovesHistory[i], computerMovesHistory[i], resultsHistory[i]);
            }
            System.out.println("--------------------------------------------------------");

            // 7. Calculate and display final statistics
            double winPercentage = ((double) wins / totalRounds) * 100;
            System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                    wins, losses, draws, winPercentage);
            System.out.println("========================================================");

            scanner.close();
        }

        /**
         * Determines the winner of a single round based on Rock-Paper-Scissors rules.
         * Matches the required method signature from the scenario.
         */
        public static String playRound(String playerMove, String computerMove) {
            if (playerMove.equals(computerMove)) {
                return "Draw";
            }

            // Logic checks for Player Winning conditions
            if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
                return "Player Wins";
            }

            // If it's not a tie and the player didn't win, the computer won
            return "Computer Wins";
        }
    }



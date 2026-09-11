package OOP_Fundamentals.assignment_problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Overloaded check 1: Matches-played-only rule for established players (Threshold >= 10)
        public static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Overloaded check 2: Combined matches-and-fitness rule for newer players
        public static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        // Comparable implementation for descending sort by batting average (fantasy points)
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        // Draft and rank players
        public static String draftAndRank(Player[] players) {
            List<Player> qualified = new ArrayList<>();

            for (Player p : players) {
                // Evaluates using the overloaded eligibility rules
                if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                    qualified.add(p);
                }
            }

            // Convert List back to a standard Array for sorting
            Player[] draftableArray = qualified.toArray(new Player[0]);

            // Arrays.sort automatically utilizes the compareTo method above
            Arrays.sort(draftableArray);

            // Build the requested string formatting output
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < draftableArray.length; i++) {
                sb.append(i + 1).append(". ").append(draftableArray[i].name);
                if (i < draftableArray.length - 1) {
                    sb.append(" | ");
                }
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            Player[] players = {
                    new Player("Virat", 15, 48.0, false),
                    new Player("Rahul", 7, 55.0, false),
                    new Player("Sameer", 3, 60.0, false),
                    new Player("Dev", 12, 20.0, true)
            };

            System.out.println(draftAndRank(players));
            // Output: 1. Rahul | 2. Virat | 3. Dev
        }
    }



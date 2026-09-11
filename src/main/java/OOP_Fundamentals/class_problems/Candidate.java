package OOP_Fundamentals.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    private double compositeScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Perfect formula match: CGPA weighted by 10, coding score weighted by 0.5
        this.compositeScore = (cgpa * 10) + (codingScore * 0.5);
    }

    // Overloaded check 1: CGPA-only filter (e.g., threshold >= 7.5)
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Overloaded check 2: Borderline filter (e.g., lower CGPA but high coding score)
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Comparable implementation for automatic descending sort by composite score
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }

    // Shortlist and rank candidates
    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> qualified = new ArrayList<>();

        for (Candidate c : candidates) {
            // Evaluates using the overloaded eligibility rules
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                qualified.add(c);
            }
        }

        // Convert List back to a standard Array for sorting
        Candidate[] shortlistedArray = qualified.toArray(new Candidate[0]);

        // Arrays.sort automatically utilizes the compareTo method above
        Arrays.sort(shortlistedArray);

        // Build the requested string format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            Candidate c = shortlistedArray[i];
            sb.append(i + 1).append(". ").append(c.name)
                    .append(" (").append(c.compositeScore).append(")");
            if (i < shortlistedArray.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    // Main driver program matching previous questions
    public static void main(String[] args) {
        Candidate[] batch = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        String rankingResult = shortlistAndRank(batch);
        System.out.println(rankingResult);
        // Output: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}



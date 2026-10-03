package main.java.OOP.practice_problems;


class Scorecard {
    private boolean[] results;
    private int count = 0;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
    }

    void recordAnswer(boolean answer) {
        if (count < results.length) {
            results[count++] = answer;
        } else {
            System.out.println("Cannot record more answers");
        }
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}
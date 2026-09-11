package OOP_Fundamentals.class_problems;


    import java.util.Arrays;

    public class ScoreBooster {
        public static void curveScores(int[] scores, int bonus) {

            for (int i = 0; i < scores.length; i++) {
                scores[i] += bonus;
            }
        }

        public static void main(String[] args) {
            int[] scores = {70, 85, 60};
            int bonus = 10;

            curveScores(scores, bonus);


            System.out.println(Arrays.toString(scores)); // Output: [80, 95, 70]
        }
    }



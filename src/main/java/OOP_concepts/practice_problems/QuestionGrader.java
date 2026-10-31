package main.java.OOP_concepts.practice_problems;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluateScore();
    public abstract String getQuestionType();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAns = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            String cleanKeyword = keyword.trim().toLowerCase();
            if (!cleanKeyword.isEmpty() && lowerStudentAns.contains(cleanKeyword)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();

            // Clean parsing to handle text strings enclosed inside double quotes
            String qText = parseQuotedString(scanner);
            String correctAns = parseQuotedString(scanner);
            String studentAns = parseQuotedString(scanner);
            double points = scanner.nextDouble();

            switch (type) {
                case "MCQ":
                    questions.add(new MCQQuestion(qText, correctAns, studentAns, points));
                    break;
                case "TF":
                    questions.add(new TFQuestion(qText, correctAns, studentAns, points));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(qText, correctAns, studentAns, points));
                    break;
            }
        }

        double overallScore = 0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            overallScore += score;
            System.out.printf("%s: %.2f\n", q.getQuestionType(), score);
        }

        System.out.printf("Total Score: %.2f\n", overallScore);
        scanner.close();
    }

    private static String parseQuotedString(Scanner scanner) {
        String token = scanner.findInLine("\"([^\"]*)\"");
        if (token != null) {
            return token.substring(1, token.length() - 1);
        }
        return scanner.next();
    }
}


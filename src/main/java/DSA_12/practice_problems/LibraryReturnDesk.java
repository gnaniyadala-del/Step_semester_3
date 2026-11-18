package main.java.DSA_12.practice_problems;

import java.util.Scanner;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;

        String line = sc.nextLine().trim();
        if (line.isEmpty()) return;

        // Supports comma-separated or newline-separated commands
        String[] commands = line.split("\\s*,\\s*");

        // Stack of size 3 for returned books
        String[] pile = new String[3];
        int top = -1;

        // Circular queue of size 3 for waiting students
        String[] queue = new String[3];
        int front = 0;
        int rear = 0;
        int queueSize = 0;

        for (String cmd : commands) {
            if (cmd.isEmpty()) continue;
            String[] parts = cmd.trim().split("\\s+");
            String action = parts[0];

            switch (action) {
                case "RETURN":
                    String book = parts[1];
                    if (top == 2) {
                        System.out.println(book + " rejected: pile is full");
                    } else {
                        pile[++top] = book;
                        System.out.println(book + " placed on pile");
                    }
                    break;

                case "SHELVE":
                    if (top == -1) {
                        System.out.println("pile is empty");
                    } else {
                        System.out.println("shelved " + pile[top--]);
                    }
                    break;

                case "WAIT":
                    String student = parts[1];
                    if (queueSize == 3) {
                        System.out.println(student + " rejected: line is full");
                    } else {
                        queue[rear] = student;
                        rear = (rear + 1) % 3;
                        queueSize++;
                        System.out.println(student + " joined the line");
                    }
                    break;

                case "SERVE":
                    if (queueSize == 0) {
                        System.out.println("no one waiting");
                    } else {
                        String servedStudent = queue[front];
                        front = (front + 1) % 3;
                        queueSize--;
                        System.out.println("served " + servedStudent);
                    }
                    break;
            }
        }
        sc.close();
    }
}

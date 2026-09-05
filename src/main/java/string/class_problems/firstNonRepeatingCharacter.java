package main.java.string.class_problems;

public class firstNonRepeatingCharacter {


        public static void main(String[] args) {

            String input1 = "swiss";
            System.out.println("Testing Input: \"" + input1 + "\"");
            displayFirstUnique(input1);

            System.out.println("\n----------------------------------------\n");


            String input2 = "aabbcc";
            System.out.println("Testing Input: \"" + input2 + "\"");
            displayFirstUnique(input2);
        }


        public static void displayFirstUnique(String text) {
            char result = findFirstNonRepeatingChar(text);


            if (result == '\0') {
                System.out.println("No Non-Repeating Character Found");
            } else {
                System.out.println("First Non-Repeating Character: '" + result + "'");
            }
        }


        public static char findFirstNonRepeatingChar(String text) {

            int[] frequency = new int[256];


            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                frequency[ch]++;
            }


            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                if (frequency[ch] == 1) {
                    return ch;
                }
            }

            return '\0';
        }


}

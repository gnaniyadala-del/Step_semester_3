package main.java.string.class_problems;

public class palindromeChecker {


        public static void main(String[] args) {

            String text1 = "madam";
            System.out.println("Testing Input: \"" + text1 + "\"");
            verifyText(text1);

            System.out.println("\n------------------------------------------------------------\n");


            String text2 = "hello";
            System.out.println("Testing Input: \"" + text2 + "\"");
            verifyText(text2);
        }


        public static void verifyText(String text) {
            boolean isIterative = isPalindromeIterative(text);
            boolean isRecursive = isPalindromeRecursive(text);
            boolean isArrayReversal = isPalindromeArrayReversal(text);


            String iterResult = isIterative ? "Palindrome" : "Not Palindrome";
            String recurResult = isRecursive ? "Palindrome" : "Not Palindrome";
            String revResult = isArrayReversal ? "Palindrome" : "Not Palindrome";

            System.out.println("Iterative: " + iterResult + " | " +
                    "Recursive: " + recurResult + " | " +
                    "Array Reversal: " + revResult);
        }


        public static boolean isPalindromeIterative(String text) {
            int left = 0;
            int right = text.length() - 1;

            while (left < right) {
                if (text.charAt(left) != text.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }


        public static boolean isPalindromeRecursive(String text) {

            if (text == null || text.length() <= 1) {
                return true;
            }


            if (text.charAt(0) == text.charAt(text.length() - 1)) {
                return isPalindromeRecursive(text.substring(1, text.length() - 1));
            }

            return false;
        }


        public static boolean isPalindromeArrayReversal(String text) {
            char[] originalChars = text.toCharArray();
            char[] reversedChars = new char[originalChars.length];


            for (int i = 0; i < originalChars.length; i++) {
                reversedChars[i] = originalChars[originalChars.length - 1 - i];
            }


            String reversedText = new String(reversedChars);
            return text.equals(reversedText);
        }


}

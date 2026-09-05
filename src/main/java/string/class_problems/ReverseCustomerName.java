package main.java.string.class_problems;

public class ReverseCustomerName {


        public static void main(String[] args) {

            String sampleName = "Sunil";


            String reversedName = reverseCustomerName(sampleName);


            System.out.println("Original Name: " + sampleName);
            System.out.println("Reversed Name: " + reversedName);
        }


        public static String reverseCustomerName(String customerName) {

            if (customerName == null || customerName.isEmpty()) {
                return customerName;
            }


            char[] chars = customerName.toCharArray();
            char[] reversedChars = new char[chars.length];


            for (int i = 0; i < chars.length; i++) {
                reversedChars[i] = chars[chars.length - 1 - i];
            }


            return new String(reversedChars);
        }



}

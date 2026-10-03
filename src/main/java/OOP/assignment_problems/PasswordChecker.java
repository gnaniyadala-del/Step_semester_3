package main.java.OOP.assignment_problems;


    public class PasswordChecker {

        private final String password;

        // Constructor
        public PasswordChecker(String password) {
            this.password = password;
        }

        // Check password strength
        public String getStrength() {

            int length = password.length();

            if (length < 6) {
                return "Weak";
            }
            else if (length <= 9) {
                return "Medium";
            }
            else {
                return "Strong";
            }
        }

        // Main method
        public static void main(String[] args) {

            PasswordChecker pc = new PasswordChecker("abcd");

            System.out.println("Password strength: " + pc.getStrength());

            PasswordChecker pc2 = new PasswordChecker("abcdefghij");

            System.out.println("Password strength: " + pc2.getStrength());
        }
    }


package main.java.OOP.practice_problems;


class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    boolean changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        if (l.changeCode("1234", "5678"))
            System.out.println("Code Changed");
        else
            System.out.println("Rejected");

        if (l.changeCode("0000", "9999"))
            System.out.println("Code Changed");
        else
            System.out.println("Rejected");
    }
}
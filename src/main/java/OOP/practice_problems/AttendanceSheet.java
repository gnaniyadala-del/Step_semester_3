package main.java.OOP.practice_problems;


class AttendanceSheet {
    private String[] students;
    private int count = 0;

    AttendanceSheet(int maxSize) {
        students = new String[maxSize];
    }

    void markPresent(String name) {
        if (!isPresent(name) && count < students.length) {
            students[count++] = name;
        }
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count = " + sheet.getPresentCount());
        System.out.println("Ben Present = " + sheet.isPresent("Ben"));
        System.out.println("Chen Present = " + sheet.isPresent("Chen"));
    }
}
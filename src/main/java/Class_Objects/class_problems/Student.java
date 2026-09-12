package main.java.Class_Objects.class_problems;


    class Student {

        String name;
        int attendance;


        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;


        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++; // Increment count every time a student is created
        }


        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public class MainM5 {
        public static void main(String[] args) {

            Student s1 = new Student("Amit", 85);
            Student s2 = new Student("Bhavana", 90);


            Student.printCollegeInfo();
        }
    }

}
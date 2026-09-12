package main.java.Class_Objects.assignment_problems;


    class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;


        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }


        public Employee(String empId, String empName) {
            this(empId, empName, 0); // Chains to 3-argument constructor
            this.isIntern = true;    // Updates intern flag afterwards
        }


        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public class MainM3 {
        public static void main(String[] args) {

            Employee permanent = new Employee("E-101", "Divya", 65000);


            Employee intern = new Employee("E-102", "Arjun");


            permanent.printProfile();
            intern.printProfile();
        }
    }



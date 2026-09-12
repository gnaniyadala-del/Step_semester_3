package main.java.Class_Objects.assignment_problems;


    class CompanyEmployee {

        String empName;
        double salary;


        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;


        public CompanyEmployee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }


        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public class MainM5 {
        public static void main(String[] args) {

            CompanyEmployee e1 = new CompanyEmployee("Rahul", 30000);
            CompanyEmployee e2 = new CompanyEmployee("Srinivas", 45000);
            CompanyEmployee e3 = new CompanyEmployee("Preethi", 50000);


            CompanyEmployee.printCompanyInfo();
        }
    }



public class JavaFundamentals{
    static class Employee {
        int empNo;
        String empName;
        String department;
        String designationCode;
        int basic;
        int hra;
        int it;

        Employee(int empNo, String empName, String department, String designationCode, int basic, int hra, int it) {
            this.empNo = empNo;
            this.empName = empName;
            this.department = department;
            this.designationCode = designationCode;
            this.basic = basic;
            this.hra = hra;
            this.it = it;
        }
    }

    static class Designation {
        String code;
        String name;
        int da;

        Designation(String code, String name, int da) {
            this.code = code;
            this.name = name;
            this.da = da;
        }
    }

    static Employee[] employees = {
        new Employee(1001, "Ashish",      "R&D",           "e", 20000, 8000, 3000),
        new Employee(1002, "Sushma",      "PM",            "c", 30000, 12000, 9000),
        new Employee(1003, "Rahul",       "Acct",          "k", 10000, 8000, 1000),
        new Employee(1004, "Chahat",      "Front Desk",    "r", 12000, 6000, 2000),
        new Employee(1005, "Ranjan",      "Engg",          "e", 50000, 20000, 20000),
        new Employee(1006, "Suman",       "Manufacturing", "m", 23000, 9000, 4400),
        new Employee(1007, "Tanmay",      "PM",            "c", 29000, 12000, 10000)
    };

    static Designation[] designations = {
        new Designation("e", "Engineer",      20000),
        new Designation("c", "Consultant",    32000),
        new Designation("k", "Clerk",         12000),
        new Designation("r", "Receptionist",  15000),
        new Designation("m", "Manager",       40000)
    };

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the employee id as a command-line argument.");
            return;
        }
        int searchId;
        try {
            searchId = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid empid format");
            return;
        }
        Employee emp = null;
        for (Employee e : employees) {
            if (e.empNo == searchId) {
                emp = e;
                break;
            }
        }

        if (emp == null) {
            System.out.println("There is no employee with empid : " + searchId);
            return;
        }

        String designation = "";
        int da = 0;
        switch (emp.designationCode) {
            case "e":
                designation = "Engineer";
                da = 20000;
                break;
            case "c":
                designation = "Consultant";
                da = 32000;
                break;
            case "k":
                designation = "Clerk";
                da = 12000;
                break;
            case "r":
                designation = "Receptionist";
                da = 15000;
                break;
            case "m":
                designation = "Manager";
                da = 40000;
                break;
            default:
                // Should not reach here for valid data
                break;
        }

        int salary = emp.basic + emp.hra + da - emp.it;

        System.out.println("Emp No.  Emp Name  Department  Designation  Salary");
        System.out.println(emp.empNo + "      " + emp.empName + "     " + emp.department + "      " + designation + "     " + salary);
    }
}

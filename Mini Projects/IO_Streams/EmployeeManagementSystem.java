package IO_Streams ;
import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + designation + " " + salary;
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");
            System.out.print("");

            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    System.out.println("Exiting the System");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option. Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner sc) {
        System.out.print("Enter Employee ID ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Employee Name ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Designation ");
        String designation = sc.nextLine();

        System.out.print("Enter Employee Salary ");
        double salary = sc.nextDouble();
        sc.nextLine();

        Employee emp = new Employee(id, name, designation, salary);

        List<Employee> list = readEmployeesFromFile();
        list.add(emp);
        writeEmployeesToFile(list);
    }

    private static void displayAll() {
        List<Employee> list = readEmployeesFromFile();
        if (list.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("----Report-----");
        for (Employee e : list) {
            System.out.println(e);
        }
        System.out.println("----End of Report-----");
    }

    private static List<Employee> readEmployeesFromFile() {
        List<Employee> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            list = (List<Employee>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File will be created when first employee is added
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employee file.");
        }
        return list;
    }

    private static void writeEmployeesToFile(List<Employee> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error writing employee file.");
        }
    }
}

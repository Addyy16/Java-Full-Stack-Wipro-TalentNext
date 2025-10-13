package Abstraction_Packages_ExceptionHandling.main;

import Abstraction_Packages_ExceptionHandling.service.Student;
import Abstraction_Packages_ExceptionHandling.service.StudentReport;
import Abstraction_Packages_ExceptionHandling.service.StudentService;

public class StudentMain {
    static Student[] data = new Student[4];

    public StudentMain() {
        data[0] = new Student("Sekar", new int[]{85, 75, 95});
        data[1] = new Student(null, new int[]{11, 22, 33});
        data[2] = null;
        data[3] = new Student("Manoj", null);
    }

    public static void main(String[] args) {
        StudentMain mainObj = new StudentMain();
        StudentReport report = new StudentReport();
        StudentService service = new StudentService();

        for (Student s : data) {
            try {
                String validation = report.validate(s);
                if ("VALID".equals(validation)) {
                    String grade = report.findGrades(s);
                    System.out.println("Grade: " + grade);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Number of null marks array: " + service.findNumberOfNullMarksArray(data));
        System.out.println("Number of null names: " + service.findNumberOfNullName(data));
        System.out.println("Number of null objects: " + service.findNumberOfNullObjects(data));
    }
}

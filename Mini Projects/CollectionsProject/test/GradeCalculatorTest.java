package CollectionsProject.test;

import CollectionsProject.exception.NullStudentException;
import CollectionsProject.exception.NullNameException;
import CollectionsProject.exception.NullMarksArrayException;
import CollectionsProject.student.GradeCalculator;
import CollectionsProject.student.Student;

public class GradeCalculatorTest {
    public static void main(String[] args) {
        GradeCalculator calculator = new GradeCalculator();

        runGradeTest(new Student("John", new int[]{90, 85, 88}), calculator, "A");
        runGradeTest(new Student("Jane", new int[]{40, 37, 35}), calculator, "D");
        runGradeTest(new Student("Joe", new int[]{20, 30, 25}), calculator, "F");
        runExceptionTest(null, calculator, NullStudentException.class);
        runExceptionTest(new Student(null, new int[]{50, 50, 50}), calculator, NullNameException.class);
        runExceptionTest(new Student("Mark", null), calculator, NullMarksArrayException.class);
    }

    private static void runGradeTest(Student student, GradeCalculator calculator, String expectedGrade) {
        try {
            String grade = calculator.validate(student);
            System.out.printf("Expected: %s, Actual: %s%n", expectedGrade, grade);
        } catch (Exception e) {
            System.out.printf("Unexpected exception: %s%n", e.getMessage());
        }
    }

    private static void runExceptionTest(Student student, GradeCalculator calculator, Class<? extends Exception> expected) {
        try {
            calculator.validate(student);
            System.out.printf("Expected exception: %s, but none thrown.%n", expected.getSimpleName());
        } catch (Exception e) {
            if (expected.isInstance(e)) {
                System.out.printf("Passed: Caught expected exception %s%n", e.getClass().getSimpleName());
            } else {
                System.out.printf("Failed: Expected %s but caught %s%n", expected.getSimpleName(), e.getClass().getSimpleName());
            }
        }
    }
}

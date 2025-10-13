package Abstraction_Packages_ExceptionHandling.service;

public class StudentReport {
    public String findGrades(Student studentObject) {
        int[] marks = studentObject.getMarks();
        for (int mark : marks) {
            if (mark < 35) {
                return "F";
            }
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        if (sum == 150) return "C";
        else if (sum == 200) return "B";
        else if (sum == 250) return "A";
        else return "A";
    }

    public String validate(Student s) throws NullStudentObjectException, NullNameException, NullMarksArrayException {
        if (s == null) {
            throw new NullStudentObjectException("Student object is null");
        }
        if (s.getName() == null) {
            throw new NullNameException("Student name is null");
        }
        if (s.getMarks() == null) {
            throw new NullMarksArrayException("Marks array is null");
        }
        return "VALID";
    }
}

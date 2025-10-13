package CollectionsProject.student;

import CollectionsProject.exception.NullMarksArrayException;
import CollectionsProject.exception.NullStudentException;
import CollectionsProject.exception.NullNameException;

public class GradeCalculator {
    public static final String GRADE_A = "A";
    public static final String GRADE_B = "B";
    public static final String GRADE_C = "C";
    public static final String GRADE_D = "D";
    public static final String GRADE_F = "F";

    public String validate(Student student) throws NullStudentException, NullNameException, NullMarksArrayException {
        if (student == null) {
            throw new NullStudentException();
        }
        if (student.getName() == null) {
            throw new NullNameException();
        }
        if (student.getMarks() == null) {
            throw new NullMarksArrayException();
        }
        return calculateGrade(student);
    }

    private String calculateGrade(Student student) {
        int[] marks = student.getMarks();
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        int average = total / marks.length;
        if (average >= 80) {
            return GRADE_A;
        } else if (average >= 60) {
            return GRADE_B;
        } else if (average >= 50) {
            return GRADE_C;
        } else if (average >= 35) {
            return GRADE_D;
        } else {
            return GRADE_F;
        }
    }
}

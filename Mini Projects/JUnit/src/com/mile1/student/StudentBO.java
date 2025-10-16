package JUnit.src.com.mile1.student;

import JUnit.src.com.mile1.student.NullStudentException;
import JUnit.src.com.mile1.student.NullNameException;
import JUnit.src.com.mile1.student.NullMarksArrayException;

public class StudentBO {

    public char findGrade(Student student) throws NullStudentException, NullNameException, NullMarksArrayException {
        if (student == null) {
            throw new NullStudentException();
        }
        if (student.getName() == null) {
            throw new NullNameException();
        }
        if (student.getMarks() == null) {
            throw new NullMarksArrayException();
        }

        int sum = 0;
        int[] marks = student.getMarks();
        for (int mark : marks) {
            sum += mark;
        }
        int avg = sum / marks.length;

        char grade = 'F';
        if (avg >= 80) {
            grade = 'A';
        } else if (avg >= 60) {
            grade = 'D';
        } 
        student.setGrade(grade);
        return grade;
    }
}

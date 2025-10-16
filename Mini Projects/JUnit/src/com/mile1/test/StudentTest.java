package JUnit.src.com.mile1.test;

import JUnit.src.com.mile1.student.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    StudentBO studentBO = new StudentBO();

    @Test
    public void testValidGradeA() throws Exception {
        Student s = new Student("John", new int[] {90, 95, 85});
        assertEquals('A', studentBO.findGrade(s));
    }

    @Test
    public void testValidGradeD() throws Exception {
        Student s = new Student("Mary", new int[] {65, 70, 60});
        assertEquals('D', studentBO.findGrade(s));
    }

    @Test
    public void testValidGradeF() throws Exception {
        Student s = new Student("Mike", new int[] {50, 40, 55});
        assertEquals('F', studentBO.findGrade(s));
    }

    @Test(expected = NullStudentException.class)
    public void testNullStudent() throws Exception {
        studentBO.findGrade(null);
    }

    @Test(expected = NullNameException.class)
    public void testNullName() throws Exception {
        Student s = new Student(null, new int[] {60, 70, 80});
        studentBO.findGrade(s);
    }

    @Test(expected = NullMarksArrayException.class)
    public void testNullMarks() throws Exception {
        Student s = new Student("Tom", null);
        studentBO.findGrade(s);
    }
    
    @Test
    public void testFindNumberOfNullNames() {
        StudentService service = new StudentService();
        Student[] students = {
            new Student(null, new int[] {50, 60}),
            new Student("Anna", new int[] {70, 80}),
            new Student(null, new int[] {30, 40})
        };
        assertEquals(2, service.findNumberOfNullNames(students));
    }

    @Test
    public void testFindNumberOfNullObjects() {
        StudentService service = new StudentService();
        Student[] students = {
            null,
            new Student("Anna", new int[] {70, 80}),
            null
        };
        assertEquals(2, service.findNumberOfNullObjects(students));
    }

    @Test
    public void testFindNumberOfNullMarks() {
        StudentService service = new StudentService();
        Student[] students = {
            new Student("John", null),
            new Student("Anna", new int[] {70, 80}),
            new Student("Mark", null)
        };
        assertEquals(2, service.findNumberOfNullMarks(students));
    }
}

package Abstraction_Packages_ExceptionHandling.service;

public class StudentService {
    public int findNumberOfNullMarksArray(Student[] students) {
        int count = 0;
        if (students != null) {
            for (Student s : students) {
                if (s != null && s.getMarks() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findNumberOfNullName(Student[] students) {
        int count = 0;
        if (students != null) {
            for (Student s : students) {
                if (s != null && s.getName() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findNumberOfNullObjects(Student[] students) {
        int count = 0;
        if (students != null) {
            for (Student s : students) {
                if (s == null) {
                    count++;
                }
            }
        }
        return count;
    }
}

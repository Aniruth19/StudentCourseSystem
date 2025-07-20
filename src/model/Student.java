package model;
import java.util.*;

public class Student {

    int studentId;
    String studentName;
    Set<Course> coursesEnrolled;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.studentName = name;
        this.coursesEnrolled = new HashSet<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return studentName;
    }

    public Set<Course> getCoursesEnrolled() {
        return this.coursesEnrolled;
    }
    @Override
    public String toString(){
        return studentName;
    }
}

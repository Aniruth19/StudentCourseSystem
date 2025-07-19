package model;
import java.util.*;

public class Student {
    int studentId;
    String name;
    Set<Course> coursesEnrolled;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.coursesEnrolled = new HashSet<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }

}

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

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public void addCourse(Set<Course>  coursesEnrolled,String courseName) {
        //
    }

    public Set<Course> getCoursesEnrolled() {
        return this.coursesEnrolled;
    }
    @Override
    public String toString(){
        return studentName;
    }
}

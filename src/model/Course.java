package model;

public class Course {
    String courseName;
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return courseName;
    }
    @Override
    public String toString() {
        return courseName;
    }

}

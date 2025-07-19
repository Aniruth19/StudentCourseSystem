package model;

public class Course {
    private static int CourseCount = 0;

    int courseCount;
    String courseName;

    public Course(String courseName) {
        CourseCount++;
        this.courseName = courseName;
    }


    public String getCourseName() {
        return courseName;
    }

    public int getCourseCount() {
        return CourseCount;
    }

    @Override
    public String toString() {
        return courseName;
    }

}

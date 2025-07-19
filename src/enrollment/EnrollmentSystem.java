package enrollment;
import model.Course;
import model.Student;
import java.util.*;

public class EnrollmentSystem {
    private static int studentIdCounter = 0;
    Scanner sc  = new Scanner(System.in);
    Map<Course, Set<Student>> enrollmentMap = new HashMap<>();
    Map<Integer, Student> studentMap = new HashMap<>();


    public void addStudent(){
        System.out.println("Enter the Student name : ");
        String studentName = sc.nextLine();
        Student currentstudent = new Student(studentIdCounter,studentName);
        studentMap.put(studentIdCounter, currentstudent);
        studentIdCounter++;
        System.out.println("Wanna enroll the student in any of the courses ? (Listed below)");

        System.out.println(enrollmentMap.keySet().toString());
        if(enrollmentMap.isEmpty()){
            System.out.println("No courses are available at the moment");
        }
        else{
            System.out.println("Enter any of the courses you want to enroll from the list above");
            System.out.println(enrollmentMap.keySet().toString());
        }
        System.out.println("Student has been added");
    }
    public void addCourse(){
        System.out.println("Enter the Course name that you'd wanna add: ");
        String courseName = sc.nextLine();
        Course currentCourse = new Course(courseName);
        if(enrollmentMap.containsKey(currentCourse)){
            System.out.println("Course already exists");
        }
        else{
            enrollmentMap.put(currentCourse, new HashSet<>());
        }
        System.out.println("Course has been added");
    }

    //     Map<Course, Set<Student>> enrollmentMap = new HashMap<>();
    //     Map<Integer, Student> studentMap = new HashMap<>();
    public void addEnrollment(){
        System.out.println("Enter the Student ID :");
        int studentId = sc.nextInt();
        System.out.println("Enter the Course name :");
        String courseName = sc.nextLine();


        if(studentMap.containsKey(studentId)){
            Student currentStudent = studentMap.get(studentId); // get my current student
            Set<Course> currentStudentCourses = currentStudent.getCoursesEnrolled();
            //if(currentStudentCourses.contains()){}

            //

            //
        }
        else{
            System.out.println("Student with the specified ID is not found");
        }
        System.out.println("Enrollment has been added");
    }

    public String listAllCourses() {
        if (enrollmentMap.isEmpty()) {
            return "No courses available.";
        }
        StringBuilder sb = new StringBuilder("Available Courses:\n");
        for (Course course : enrollmentMap.keySet()) {
            sb.append("- ").append(course.toString()).append("\n");
        }
        return sb.toString();
    }

    public void removeEnrollment(){

    }

    public void deleteStudent(){

    }
    public void deleteCourse(){

    }


    public void listAllCoursesStudentEnrolled(){
        System.out.println("Enter the Student ID : ");
        int studentId = sc.nextInt();
        sc.nextLine();
        if(studentMap.containsKey(studentId)){
            Student currentStudent = studentMap.get(studentId);
            Set<Course> currentStudentCourse = currentStudent.getCoursesEnrolled();
            System.out.println(currentStudentCourse.toString());
        }

    }

}

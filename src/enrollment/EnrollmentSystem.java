package enrollment;
import model.Course;
import model.Student;
import java.util.*;

public class EnrollmentSystem {
    private static int studentIdGenerator = 0;
    Scanner sc = new Scanner(System.in);
    Map<Course, Set<Student>> enrollmentMap = new HashMap<>();
    Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent() {
        System.out.println("Enter the Student name : ");
        String studentName = sc.nextLine();

        Student currentstudent = new Student(studentIdGenerator, studentName);
        studentMap.put(studentIdGenerator, currentstudent);
        System.out.println("Student has been added with ID: " + studentIdGenerator);
        studentIdGenerator++;

        if (enrollmentMap.isEmpty()) {
            System.out.println("No courses are available at the moment");
        } else {
            System.out.println("Do you want to enroll the student in any course? (Type exact course name or 'skip'):");
            for (Course c : enrollmentMap.keySet()) {
                System.out.println("- " + c.getCourseName());
            }
            String chosenCourse = sc.nextLine();
            if (!chosenCourse.equalsIgnoreCase("skip")) {
                for (Course course : enrollmentMap.keySet()) {
                    if (course.getCourseName().equalsIgnoreCase(chosenCourse)) {
                        currentstudent.getCoursesEnrolled().add(course);
                        enrollmentMap.get(course).add(currentstudent);
                        System.out.println("Student enrolled in: " + course.getCourseName());
                        break;
                    }
                }
            }
        }
    }

    public void addCourse() {
        System.out.println("Enter the Course name that you'd wanna add: ");
        String courseName = sc.nextLine();
        Course currentCourse = new Course(courseName);
        if (enrollmentMap.containsKey(currentCourse)) {
            System.out.println("Course already exists");
        } else {
            enrollmentMap.put(currentCourse, new HashSet<>());
            System.out.println("Course has been added");
        }
    }

    public void addEnrollment() {
        System.out.println("Enter the Student ID :");
        int studentId = sc.nextInt();
        sc.nextLine();  

        System.out.println("Enter the Course name :");
        String courseName = sc.nextLine();

        if (studentMap.containsKey(studentId)) {
            Student currentStudent = studentMap.get(studentId);
            boolean courseFound = false;

            for (Course course : enrollmentMap.keySet()) {
                if (course.getCourseName().equalsIgnoreCase(courseName)) {
                    if (currentStudent.getCoursesEnrolled().contains(course)) {
                        System.out.println("Student is already enrolled in this course.");
                    } else {
                        currentStudent.getCoursesEnrolled().add(course);
                        enrollmentMap.get(course).add(currentStudent);
                        System.out.println("Enrollment added successfully.");
                    }
                    courseFound = true;
                    break;
                }
            }

            if (!courseFound) {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("Student with the specified ID is not found");
        }
    }

    public void removeEnrollment() {
        System.out.println("Enter the Student ID:");
        int studentId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the Course name:");
        String courseName = sc.nextLine();

        if (studentMap.containsKey(studentId)) {
            Student student = studentMap.get(studentId);
            Course targetCourse = null;

            for (Course course : enrollmentMap.keySet()) {
                if (course.getCourseName().equalsIgnoreCase(courseName)) {
                    targetCourse = course;
                    break;
                }
            }

            if (targetCourse != null &&
                    enrollmentMap.get(targetCourse).contains(student) &&
                    student.getCoursesEnrolled().contains(targetCourse)) {
                enrollmentMap.get(targetCourse).remove(student);
                student.getCoursesEnrolled().remove(targetCourse);
                System.out.println("Enrollment removed successfully.");
            } else {
                System.out.println("Student is not enrolled in that course.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent() {
        System.out.println("Enter the Student ID to delete:");
        int studentId = sc.nextInt();
        sc.nextLine();

        if (studentMap.containsKey(studentId)) {
            Student student = studentMap.get(studentId);
            for (Course course : enrollmentMap.keySet()) {
                enrollmentMap.get(course).remove(student);
            }
            studentMap.remove(studentId);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteCourse() {
        System.out.println("Enter the Course name to delete:");
        String courseName = sc.nextLine();
        Course targetCourse = null;

        for (Course course : enrollmentMap.keySet()) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                targetCourse = course;
                break;
            }
        }

        if (targetCourse != null) {
            Set<Student> enrolledStudents = enrollmentMap.get(targetCourse);
            for (Student student : enrolledStudents) {
                student.getCoursesEnrolled().remove(targetCourse);
            }
            enrollmentMap.remove(targetCourse);
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void listAllStudentsInCourse() {
        System.out.println("Enter the Course name:");
        String courseName = sc.nextLine();

        Course targetCourse = null;
        for (Course course : enrollmentMap.keySet()) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                targetCourse = course;
                break;
            }
        }

        if (targetCourse == null) {
            System.out.println("Course not found.");
            return;
        }

        Set<Student> enrolledStudents = enrollmentMap.get(targetCourse);

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students are enrolled in this course.");
        } else {
            System.out.println("Students enrolled in " + courseName + ":");
            for (Student student : enrolledStudents) {
                System.out.println("- " + student.getName() + " (ID: " + student.getStudentId() + ")");
            }
        }
    }
    // Lists down all the courses that the student has enrolled


    public void listAllCoursesStudentEnrolled() {
        System.out.println("Enter the Student ID : ");
        int studentId = sc.nextInt();
        sc.nextLine();

        if (studentMap.containsKey(studentId)) {
            Student currentStudent = studentMap.get(studentId);
            Set<Course> currentStudentCourse = currentStudent.getCoursesEnrolled();

            if (currentStudentCourse.isEmpty()) {
                System.out.println("The student is not enrolled in any courses.");
            } else {
                System.out.println("Courses enrolled:");
                for (Course c : currentStudentCourse) {
                    System.out.println("- " + c.getCourseName());
                }
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}

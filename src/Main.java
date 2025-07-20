import enrollment.EnrollmentSystem;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();
        boolean exitProgram = false;
        while(!exitProgram) {
            System.out.println(" ** STUDENT COURSE MANAGEMENT SYSTEM **");
            System.out.println("1. Create a Student"); // addStudent
            System.out.println("2. Create a Course"); // addCourse
            System.out.println("3. Enroll into a Course"); // addEnrollment
            System.out.println("4. List all Students in a Course");
            System.out.println("5. List all the Courses a Student has enrolled in");
            System.out.println("6. Remove Enrollment from a Course");
            System.out.println("7. Delete a Student");
            System.out.println("8. Delete a Course");
            System.out.println("9. Exit \n");

            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    enrollmentSystem.addStudent();
                    break;
                case 2:
                    enrollmentSystem.addCourse();
                    break;
                case 3:
                    enrollmentSystem.addEnrollment();
                    break;
                case 4:
                    enrollmentSystem.listAllStudentsInCourse();
                    break;
                case 5:
                    enrollmentSystem.listAllCoursesStudentEnrolled();
                    break;

                case 6:
                    enrollmentSystem.removeEnrollment();
                    break;

                case 7:
                    enrollmentSystem.deleteStudent();
                    break;

                case 8:
                    enrollmentSystem.deleteCourse();
                    break;

                case 9:
                    exitProgram = true;
                    break;
            }
        }
    }
}

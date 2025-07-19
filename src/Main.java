import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;
        while(!exitProgram) {
            System.out.println(" ** STUDENT COURSE MANAGEMENT SYSTEM **");
            System.out.println("1. Create a Student");
            System.out.println("2. Create a Course");
            System.out.println("3. Enroll into a Course");
            System.out.println("4. List all Students in a Course");
            System.out.println("5. List all the Courses a Student has enrolled in");
            System.out.println("6. Remove Enrollment from a Course");
            System.out.println("7. Delete a Student");
            System.out.println("8. Delete a Course");
            System.out.println("9. Exit \n");

            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 9:
                    exitProgram = true;
                    break;
            }
        }
    }
}

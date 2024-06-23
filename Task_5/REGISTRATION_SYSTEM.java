package Task_5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class REGISTRATION_SYSTEM {
    private ArrayList<Course_Database> offerings;
    private ArrayList<Student> students;
    private Student currentStudent;

    public REGISTRATION_SYSTEM() {
        offerings = new ArrayList<>();
        students = new ArrayList<>();
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int input = scanner.nextInt();
                    return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }}

    public void addCourse(Course_Database course) {
        offerings.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void studentLogin(int studentID, String password) {
        for (Student student : students) {
            if (student.getStudentID() == studentID && student.getPassword().equals(password)) {
                currentStudent = student;
                System.out.println("Login successful for " + student.getFname() + " " + student.getLname());
                return;
            }
        }
        System.out.println("Invalid student ID or password.");
    }

    public void displayCourses() {
        for (Course_Database course : offerings) {
            System.out.println(course);
        }
    }

    public void displayRegisteredCourses() {
        if (currentStudent != null) {
            ArrayList<Course_Database> registeredCourses = currentStudent.getRegisteredCourses();
            if (registeredCourses.isEmpty()) {
                System.out.println("You are not registered for any courses.");
            } else {
                for (Course_Database course : registeredCourses) {
                    System.out.println(course);
                }
            }
        } else {
            System.out.println("Please log in first.");
        }
    }

    public void registerForCourse(String courseCode) {
        if (currentStudent != null) {
            for (Course_Database course : offerings) {
                if (course.getCourseCode().equals(courseCode)) {
                    if (currentStudent.isAlreadyRegistered(course)) {
                        System.out.println("You are already registered for this course.");
                    } else if (course.isFull()) {
                        System.out.println("Course is full. Cannot register.");
                    } else {
                        currentStudent.registerCourse(course);
                        course.decrementCapacity();
                        System.out.println("Course registered successfully.");
                    }
                    return;
                }
            }
            System.out.println("Course not found.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    public void dropCourse(String courseCode) {
        if (currentStudent != null) {
            for (Course_Database course : currentStudent.getRegisteredCourses()) {
                if (course.getCourseCode().equals(courseCode)) {
                    currentStudent.dropCourse(course);
                    System.out.println("Course dropped successfully.");
                    return;
                }
            }
            System.out.println("Course not found in your registered courses.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    public static void main(String[] args) {
        REGISTRATION_SYSTEM system = new REGISTRATION_SYSTEM();
       //testing
        ArrayList<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(LocalDateTime.of(2023, 6, 23, 9, 0), LocalDateTime.of(2023, 6, 23, 10, 0), "Monday"));
        Course_Database course1 = new Course_Database("CS101", "Introduction to Computer Science", 30, "Basic concepts of computer science", schedules);
        system.addCourse(course1);

        Student student1 = new Student(1, "John", "Doe", "password123");
        system.addStudent(student1);

        Scanner scanner = new Scanner(System.in);

        while (system.currentStudent == null) {
            System.out.println("Enter student ID:");
            int studentID = getIntInput(scanner);
            System.out.println("Enter password:");
            String password = scanner.next();
            system.studentLogin(studentID, password);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. View registered courses");
            System.out.println("5. Logout");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayCourses();
                    break;
                case 2:
                    System.out.println("Enter course code to register:");
                    String courseCodeToRegister = scanner.next();
                    system.registerForCourse(courseCodeToRegister);
                    break;
                case 3:
                    System.out.println("Enter course code to drop:");
                    String courseCodeToDrop = scanner.next();
                    system.dropCourse(courseCodeToDrop);
                    break;
                case 4:
                    system.displayRegisteredCourses();
                    break;
                case 5:
                    system.currentStudent = null;
                    System.out.println("Logged out successfully.");
                    while (system.currentStudent == null) {
                        System.out.println("Enter student ID:");
                       int studentID = getIntInput(scanner);
                        System.out.println("Enter password:");
                        String password = scanner.next();
                        system.studentLogin(studentID, password);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

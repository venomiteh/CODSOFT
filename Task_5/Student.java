package Task_5;

import java.util.ArrayList;

public class Student {
    private int studentID;
    private String Fname;
    private String Lname;
    private ArrayList<Course_Database> registeredCourses;
    private String password;


    public Student(int studentID, String Fname, String Lname, String password) {
        this.studentID = studentID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.password = password;
        this.registeredCourses = new ArrayList<>();
    }












    public int getStudentID() {
        return studentID;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public ArrayList<Course_Database> getRegisteredCourses() {
        return registeredCourses;
    }

    public String getPassword() {
        return password;
    }

    public void registerCourse(Course_Database course) {
        if (!registeredCourses.contains(course) && course.getCapacity() > registeredCourses.size()) {
            registeredCourses.add(course);
        }
    }

    public void dropCourse(Course_Database course) {
        registeredCourses.remove(course);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + Fname + " " + Lname + "\nRegistered Courses: " + registeredCourses;
    }
    public boolean isAlreadyRegistered(Course_Database course) {
        return registeredCourses.contains(course);
    }
}


















package Task_5;

import java.util.ArrayList;

public class Course_Database {

private String courseCode;
private String courseName;
private String courseDescription;
private int capacity;
private ArrayList<Schedule> schedules;



public Course_Database(String code,String courseName,int capacity,String courseDescription,ArrayList<Schedule> schedules){
    this.courseCode=code;
    this.courseName=courseName;
    this.capacity=capacity;
    this.courseDescription=courseDescription;
    this.schedules=new ArrayList<>(schedules);
}
    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }
    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getDescription() {
        return courseDescription;
    }
    public String getTitle() {
        return courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseCode(){
    return courseCode;
    }

    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + courseName + "\nDescription: " + courseDescription +
                "\nCapacity: " + capacity + "\nSchedules: " + schedules;
    }

    public boolean isFull() {
        return capacity <= 0;
    }

    public void decrementCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public void incrementCapacity() {
        capacity++;
    }
















}

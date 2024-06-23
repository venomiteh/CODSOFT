package Task_5;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Schedule {
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private String dayOfWeek;


    public Schedule(LocalDateTime startTime, LocalDateTime endTime, String dayOfWeek) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }





    public String toString() {
        return dayOfWeek + " " + startTime + " - " + endTime;
    }















}

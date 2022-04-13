package com.example.schedulemaker;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class Course {

    @PrimaryKey
    @NonNull
    public String courseName;

    public String courseDescription;
    public String dayOfWeek; // this will be a string from "Monday" -> "Sunday"
    public String startTime; // this will be a string in 24 hour time xx:xx
    public String endTime; // same as the previous variable

    public Course(String courseName, String courseDescription, String dayOfWeek, String startTime, String endTime) {

        this.courseDescription = courseDescription;
        this.courseName = courseName;
        this.dayOfWeek = dayOfWeek;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    @NonNull
    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}

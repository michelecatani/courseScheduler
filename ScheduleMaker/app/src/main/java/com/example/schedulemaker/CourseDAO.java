package com.example.schedulemaker;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Course course);

    @Query("Select * FROM course_table")
    LiveData<List<Course>> getAllCourses();


    @Query("Select * FROM course_table where dayOfWeek = :day")
    LiveData<List<Course>> getCourse(String day);


    @Query("DELETE FROM course_table")
    void deleteAll();
}

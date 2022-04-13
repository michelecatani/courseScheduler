package com.example.schedulemaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ViewSchedule extends AppCompatActivity {
    RecyclerView scheduleCourseListRecyclerView;
    TextView noCourseTextView;
//    List<Course> courseList = new ArrayList<>();

//    TextView courseDesc;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_schedule);
//
////        courseDesc = findViewById(R.id.courseDesc);
//        ArrayList<Course> courses = new ArrayList<>();
//        courses.add(new Course("COMP4200", "Mobile Dev", "thursday", "19:00", "22:00"));
//        courses.add(new Course("COMP3150", "DBMS", "thursday", "11:30", "12:50"));
//        courses.add(new Course("COMP1400", "Intro to Prog", "monday", "08:00", "09:50"));
//
//
//        String dayOfWeek = getIntent().getStringExtra("day");
//
//
//        for (Course c : courses) {
//            if (c.dayOfWeek.equals(dayOfWeek)) {
//                courseDesc.append(c.courseName + ": " + c.courseDescription + "\nDay: " + c.dayOfWeek + "\nTime: From " + c.startTime + " to " + c.endTime + "\n\n\n");
//            }
//        }
//
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ArrayList<String> names = FileHandler.readData(ViewSchedule.this);

        List<Course> courseList;
        courseList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);
        scheduleCourseListRecyclerView = findViewById(R.id.schedulerRecyclerView);
        noCourseTextView = findViewById(R.id.noCourseTextView);

//        CourseViewModel mCourseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);
//
//        mCourseViewModel.getAllCourses().observe(this, courses -> {
//            courseList = (ArrayList<Course>) courses;
//        });
        CourseViewModel mCourseViewModel;
        mCourseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);

//        mCourseViewModel.getAllCourses().observe(this, courseList);

        mCourseViewModel.getAllCourses().observe(this, courses -> {
            Boolean showView = false;

////            adapter.submitList(courses);
////            this.courseList = new ArrayList<Course>(courses);
            for (Course c : courses) {
                if (getIntent().getStringExtra("day").equals(c.dayOfWeek) && names.contains(c.courseName)) {
                    courseList.add(new Course(c.courseName, c.courseDescription, c.dayOfWeek, c.startTime, c.endTime));
                    Log.d("nis", names + " names");
                    showView = true;
                }
            }
//            Log.d("nis", courseList.toString() + " ed");
//            Log.d("nis", courseList.size() + " in observer courseList size");

            if (showView) {
//                noCourseTextView.setVisibility(View.GONE);
                noCourseTextView.setText("");
                ScheduleRecyclerAdapter adapter = new ScheduleRecyclerAdapter(ViewSchedule.this, (ArrayList<Course>) courseList);
                scheduleCourseListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                scheduleCourseListRecyclerView.setAdapter(adapter);
                showView = false;
            } else {
                noCourseTextView.setText("No Scheduled Courses");
//                noCourseTextView.setVisibility(View.VISIBLE);
            }
        });


//
//        mCourseViewModel = new ViewModelProvider(this).get(CourseViewModel.class);
//        mCourseViewModel.getAllCourses().observe(this, courses -> {
//            adapter.submitList(courses);
//            Log.d("ekjotm", courses.size() + "");
//        });


    }


}

//class getDatas implements Observer {
//    private Course course;
//
//    //    @Override
//    public void update(Observable observable, Course c) {
//
//    }
//}

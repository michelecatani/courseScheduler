package com.example.schedulemaker;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseViewHolder extends RecyclerView.ViewHolder {
    TextView courseName;
    TextView courseDescription;
    TextView dayOfWeek;
    TextView startTime;
    TextView endTime;
    Button addCourseButton;
//    ArrayList<String> courseList;

    public CourseViewHolder(View itemView) {
        super(itemView);
        courseName = itemView.findViewById(R.id.courseNameTextView);
        courseDescription = itemView.findViewById(R.id.courseDescriptionTextView);
        dayOfWeek = itemView.findViewById(R.id.dayOfWeekTextView);
        startTime = itemView.findViewById(R.id.startTimeTextView);
        endTime = itemView.findViewById(R.id.endTimeTextView);
        addCourseButton = itemView.findViewById(R.id.addCourseButton);

//        courseList = FileHandler.readData(itemView.getContext());
        if (FileHandler.readData(itemView.getContext()) == null) {
            Log.d("nis", "NULL file");
        } else {

            Log.d("nis", "NOT NULL file");
        }
        String name = courseName.getText().toString();

//        if(courseList.contains(name)) {
//            addCourseButton.setText("Already registered!");
//            addCourseButton.setClickable(false);
//        }

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // uncomment below line if u wanna test to ensure that the correct courseName being shown
//                if (courseList == null) {
//                    Log.d("nis", "NULL");
//                } else {
//
//                    Log.d("nis", "NOT NULL");
//                }

                Toast.makeText(itemView.getContext(), courseName.getText().toString() + "in onclick", Toast.LENGTH_LONG).show();
//                courseList.add(name);
//                addCourseButton.setText("Already registered!");
//                addCourseButton.setClickable(false);
//                FileHandler.writeData(itemView.getContext(), courseList);
            }
        });
    }

    public void bind(String bcourseName, String bcourseDescription, String bdayOfWeek, String bstartTime, String bendTime) {
        courseName.setText(bcourseName);
        courseDescription.setText(bcourseDescription);
        dayOfWeek.setText(bdayOfWeek);
        startTime.setText(bstartTime);
        endTime.setText(bendTime);
    }

    static CourseViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_layout, parent, false);
        return new CourseViewHolder(view);
    }
}

//package com.example.schedulemaker;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//public class CourseViewHolder extends RecyclerView.ViewHolder {
//    TextView courseName;
//    TextView courseDescription;
//    TextView dayOfWeek;
//    TextView startTime;
//    TextView endTime;
//    Button addCourseButton;
//    ArrayList<Course> courseList;
//
//    public CourseViewHolder(View itemView) {
//        super(itemView);
//        courseName = itemView.findViewById(R.id.courseNameTextView);
//        courseDescription = itemView.findViewById(R.id.courseDescriptionTextView);
//        dayOfWeek = itemView.findViewById(R.id.dayOfWeekTextView);
//        startTime = itemView.findViewById(R.id.startTimeTextView);
//        endTime = itemView.findViewById(R.id.endTimeTextView);
//        addCourseButton = itemView.findViewById(R.id.addCourseButton);
//
//        courseList = FileHandler.readData(itemView.getContext());
//
////        String name = courseName.getText().toString();
////
////        if(courseList.contains(name)) {
////            addCourseButton.setText("Already registered!");
////            addCourseButton.setClickable(false);
////        }
//
//        addCourseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // uncomment below line if u wanna test to ensure that the correct courseName being shown
//                // Toast.makeText(itemView.getContext(), courseName.getText().toString(), Toast.LENGTH_LONG).show();
//                courseList.add(new Course(courseName.toString(), courseDescription.toString(), dayOfWeek.toString(), startTime.toString(), endTime.toString()));
//                Toast.makeText(view.getContext(), "" + courseName.toString(), Toast.LENGTH_SHORT).show();
//                FileHandler.writeData(itemView.getContext(), courseList);
////                addCourseButton.setText("Already registered!");
////                addCourseButton.setClickable(false);
//            }
//        });
//    }
//
//    public void bind(String bcourseName, String bcourseDescription, String bdayOfWeek, String bstartTime, String bendTime) {
//        courseName.setText(bcourseName);
//        courseDescription.setText(bcourseDescription);
//        dayOfWeek.setText(bdayOfWeek);
//        startTime.setText(bstartTime);
//        endTime.setText(bendTime);
//    }
//
//    static CourseViewHolder create(ViewGroup parent) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.course_layout, parent, false);
//        return new CourseViewHolder(view);
//    }
//}
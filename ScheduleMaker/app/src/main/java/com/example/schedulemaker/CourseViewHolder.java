package com.example.schedulemaker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseViewHolder extends RecyclerView.ViewHolder{
    TextView courseName;
    TextView courseDescription;
    TextView dayOfWeek;
    TextView startTime;
    TextView endTime;
    Button addCourseButton;

    public CourseViewHolder(View itemView) {
        super(itemView);
        courseName = itemView.findViewById(R.id.courseNameTextView);
        courseDescription = itemView.findViewById(R.id.courseDescriptionTextView);
        dayOfWeek = itemView.findViewById(R.id.dayOfWeekTextView);
        startTime = itemView.findViewById(R.id.startTimeTextView);
        endTime = itemView.findViewById(R.id.endTimeTextView);
        addCourseButton = itemView.findViewById(R.id.addCourseButton);
    }

    public void bind(String bcourseName, String bcourseDescription, String bdayOfWeek, String bstartTime, String bendTime){
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

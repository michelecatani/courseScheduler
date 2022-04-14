package com.example.schedulemaker;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;

public class RecyclerAdapter extends ListAdapter<Course, CourseViewHolder> {

    ArrayList<String> courseList;

    public RecyclerAdapter(@NonNull DiffUtil.ItemCallback<Course> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CourseViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course current = getItem(position);
        holder.bind(current.courseName, current.courseDescription, current.dayOfWeek, current.startTime, current.endTime);
        courseList = FileHandler.readData(holder.itemView.getContext());

        if (courseList.contains(current.courseName)) {
            Log.d("nis", holder.courseName.getText().toString() + "  in RecyclerAdapter.java in contain");
            holder.addCourseButton.setText("Already registered!");
            holder.addCourseButton.setClickable(false);
            holder.addCourseButton.setEnabled(false);
            holder.cardView.setCardBackgroundColor(Color.parseColor("#a3c4bc"));
        }

        holder.addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("nis", holder.courseName.getText().toString() + "  in RecyclerAdapter.java");
                // uncomment below line if u wanna test to ensure that the correct courseName being shown
                Toast.makeText(view.getContext(), holder.courseName.getText().toString() + " added successfully!", Toast.LENGTH_SHORT).show();
                courseList.add(current.courseName);
                FileHandler.writeData(holder.itemView.getContext(), courseList);
                holder.addCourseButton.setText("Already registered!");
                holder.addCourseButton.setClickable(false);
                holder.addCourseButton.setEnabled(false);
                holder.cardView.setCardBackgroundColor(Color.parseColor("#a3c4bc"));
//                holder.cardView.setCardBackgroundColor("black");
            }
        });
    }

    static class CourseDiff extends DiffUtil.ItemCallback<Course> {

        @Override
        public boolean areItemsTheSame(@NonNull Course oldItem, @NonNull Course newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Course oldItem, @NonNull Course newItem) { // this really only checks if course names are the same, should be enough for our purposes although it isnt exhaustive in a real world context
            return oldItem.courseName.equals(newItem.courseName);
        }
    }

}
package com.example.schedulemaker;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class RecyclerAdapter extends ListAdapter<Course, CourseViewHolder> {

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

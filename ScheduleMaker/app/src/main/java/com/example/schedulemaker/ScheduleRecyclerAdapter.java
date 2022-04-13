package com.example.schedulemaker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ScheduleRecyclerAdapter extends RecyclerView.Adapter<ScheduleRecyclerAdapter.ItemViewHolder> {
    Context context;
    ArrayList<Course> courseList;

    public ScheduleRecyclerAdapter(Context context, ArrayList<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_course_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.scheduleCourseNameTextView.setText(courseList.get(position).courseName);
        holder.scheduleDayOfWeekTextView.setText(courseList.get(position).dayOfWeek);
        holder.scheduleStartTimeTextView.setText(courseList.get(position).startTime);
        holder.scheduleEndTimeTextView.setText(courseList.get(position).endTime);
        holder.scheduleCourseDescriptionTextView.setText(courseList.get(position).courseDescription);

        holder.dropCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("nis", holder.scheduleCourseNameTextView.getText().toString() + " holder course Name");


                ArrayList<String> temp = FileHandler.readData(view.getContext());
                Log.d("nis", temp.size() + " read data size temp");

                Log.d("nis", temp.toString() + " read data from file temp");
                Log.d("nis", holder.getAdapterPosition() + " getHolder position");
//                String courseName = temp.get(holder.getAdapterPosition());
//                Log.d("nis", courseName + " courseName");

                for (int i = 0; i < temp.size(); i++) {
                    if (holder.scheduleCourseNameTextView.getText().equals(temp.get(i))) {
                        holder.dropCourseButton.setEnabled(false);
                        holder.dropCourseButton.setText("Dropped");
                        Log.d("nis", i + " temp index");
                        Log.d("nis", temp.get(i) + " temp");
                        temp.remove(i);
                        FileHandler.writeData(view.getContext(), temp);
                        Toast.makeText(view.getContext(), "!!" + holder.scheduleCourseNameTextView.getText().toString() + " dropped!!", Toast.LENGTH_SHORT).show();
//                        view.getContext().
//                        view.getContext().startActivity(new Intent(view.getContext(), CalendarListActivity.class));
                        break;
                    }
                }

//                for (int i = 0; i < temp.size(); i++) {
//                    if (courseName.equals(temp.get(i))) {
//                        Log.d("nis", i + " temp index");
//                        Log.d("nis", temp.get(i) + " temp");
//                        temp.remove(i);
//                        FileHandler.writeData(view.getContext(), temp);
//                        Toast.makeText(view.getContext(), "!!" + courseName + " dropped!!", Toast.LENGTH_LONG).show();
//                        break;
//                    }
//                }

//                temp.remove(holder.getAdapterPosition());
//                FileHandler.writeData(view.getContext(), temp);
            }
        });

    }

    @Override
    public int getItemCount() {

        return courseList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView scheduleCardView;
        TextView scheduleCourseNameTextView, scheduleDayOfWeekTextView, scheduleStartTimeTextView, scheduleEndTimeTextView, scheduleCourseDescriptionTextView;
        RecyclerView schedulerRecyclerView;
        Button dropCourseButton;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            dropCourseButton = itemView.findViewById(R.id.dropCourseButton);
            scheduleCourseNameTextView = itemView.findViewById(R.id.scheduleCourseNameTextView);
            scheduleDayOfWeekTextView = itemView.findViewById(R.id.scheduleDayOfWeekTextView);
            scheduleStartTimeTextView = itemView.findViewById(R.id.scheduleStartTimeTextView);
            scheduleEndTimeTextView = itemView.findViewById(R.id.scheduleEndTimeTextView);
            scheduleCourseDescriptionTextView = itemView.findViewById(R.id.scheduleCourseDescriptionTextView);
            scheduleCardView = itemView.findViewById(R.id.scheduleCardView);
        }
    }
}
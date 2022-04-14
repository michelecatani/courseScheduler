package com.example.schedulemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalendarListActivity extends AppCompatActivity {

    Button mondayButton, tuesdayButton, wednesdayButton, thursdayButton, allCoursesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_list);

        mondayButton = findViewById(R.id.mondayButton);
        tuesdayButton = findViewById(R.id.tuesdayButton);
        wednesdayButton = findViewById(R.id.wednesdayButton);
        thursdayButton = findViewById(R.id.thursdayButton);
        allCoursesButton = findViewById(R.id.allCoursesButton);

        mondayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarListActivity.this, ViewSchedule.class);
                intent.putExtra("day", "Monday");
                startActivity(intent);
            }
        });
        tuesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarListActivity.this, ViewSchedule.class);
                intent.putExtra("day", "Tuesday");
                startActivity(intent);
            }
        });
        wednesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarListActivity.this, ViewSchedule.class);
                intent.putExtra("day", "Wednesday");
                startActivity(intent);
            }
        });
        thursdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarListActivity.this, ViewSchedule.class);
                intent.putExtra("day", "Thursday");
                startActivity(intent);
            }
        });

        allCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarListActivity.this, ViewSchedule.class);
                intent.putExtra("day", "All");
                startActivity(intent);
            }
        });


    }
}
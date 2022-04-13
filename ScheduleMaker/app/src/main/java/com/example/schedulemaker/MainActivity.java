package com.example.schedulemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button selectCoursesButton, viewScheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewScheduleButton = findViewById(R.id.viewScheduleButton);
        selectCoursesButton = findViewById(R.id.selectClassesButton);
        selectCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectCoursesIntent = new Intent(MainActivity.this, ClassListActivity.class);
                startActivity(selectCoursesIntent);
            }
        });
        viewScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarListActivity.class);
                startActivity(intent);

            }
        });
        //startActivity(nextIntent);
    }
}
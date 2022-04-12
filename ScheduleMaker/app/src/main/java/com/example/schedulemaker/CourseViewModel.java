package com.example.schedulemaker;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private CourseRepository mRepository;

    private final LiveData<List<Course>> mAllCourses;

    public CourseViewModel (Application application) {
        super(application);
        mRepository = new CourseRepository(application);
        mAllCourses = mRepository.getAllCourses();
    }

    LiveData<List<Course>> getAllCourses() { return mAllCourses; }

    public void insert(Course course) { mRepository.insert(course); }
}

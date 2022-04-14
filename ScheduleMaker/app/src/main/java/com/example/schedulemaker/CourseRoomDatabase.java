package com.example.schedulemaker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Course.class}, version = 1, exportSchema = false)
public abstract class CourseRoomDatabase extends RoomDatabase {

    public abstract CourseDAO courseDAO();

    private static volatile CourseRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CourseRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CourseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CourseRoomDatabase.class, "course_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                CourseDAO dao = INSTANCE.courseDAO();
                dao.deleteAll();

//                Course course = new Course("COMP4200", "Mobile Development in Android using Java", "Thursday", "19:00", "22:00");
//                dao.insert(course);
//                course = new Course("COMP3150", "Databases and stuff", "Tuesday", "11:30", "12:50");
//                dao.insert(course);
//                course = new Course("COMP2310", "hell", "Wednesday", "13:00", "14:50");
//                dao.insert(course);
//                course = new Course("COMP1000", "Key Concepts in Computer Science", "Monday", "08:00", "09:50");
//                dao.insert(course);
//                course = new Course("COMP1400", "Intro to Programming", "Tuesday", "08:00", "09:50");
//                dao.insert(course);
//

                Course course;
                course = new Course("COMP4200", "Mobile Development in Android using Java", "Thursday", "19:00", "22:00");
                dao.insert(course);
                course = new Course("COMP3150", "Database Management System", "Tuesday", "11:30", "12:50");
                dao.insert(course);
                course = new Course("COMP2310", "Theoretical Foundations of Computer Science", "Wednesday", "13:00", "14:50");
                dao.insert(course);
                course = new Course("COMP1000", "Key Concepts in Computer Science", "Monday", "08:00", "09:50");
                dao.insert(course);
                course = new Course("COMP1400", "Intro to Programming", "Tuesday", "08:00", "09:50");
                dao.insert(course);
                course = new Course("COMP2120", "Intro to OOJ using Java", "Wednesday", "19:00", "21:50");
                dao.insert(course);
                course = new Course("COMP4250", "Data Analysis and Machine Learning", "Wednesday", "19:00", "21:50");
                dao.insert(course);
                course = new Course("COMP3400", "Advanced Object Oriented Programming in C++", "Monday", "19:00", "21:50");
                dao.insert(course);
                course = new Course("COMP2540", "Data Structures and Algorithms", "Tuesday", "13:00", "14:20");
                dao.insert(course);
                course = new Course("COMP2660", "Microprocessor Programming", "Tuesday", "19:00", "21:50");
//                dao.insert(course);
            });
        }
    };

}

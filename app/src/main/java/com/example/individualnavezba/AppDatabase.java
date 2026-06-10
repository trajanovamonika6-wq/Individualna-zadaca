package com.example.individualnavezba;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Company.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CompanyDao companyDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "business_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
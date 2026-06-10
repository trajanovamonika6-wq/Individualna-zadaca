package com.example.individualnavezba;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "companies")
public class Company {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String address;
    public double latitude;
    public double longitude;
    public String email;
    public String phone;
    public String website;
    public String category;
}

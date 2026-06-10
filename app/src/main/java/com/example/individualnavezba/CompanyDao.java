package com.example.individualnavezba;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CompanyDao {
    @Insert
    void insert(Company company);

    @Query("SELECT * FROM companies WHERE category LIKE '%' || :category || '%' AND name LIKE '%' || :search || '%'")
    List<Company> getByCategory(String category, String search);
}
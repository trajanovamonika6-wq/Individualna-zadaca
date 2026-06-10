package com.example.individualnavezba;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class AddCompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);

        EditText etName = findViewById(R.id.etName);
        EditText etAddress = findViewById(R.id.etAddress);
        EditText etLatitude = findViewById(R.id.etLatitude);
        EditText etLongitude = findViewById(R.id.etLongitude);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etWebsite = findViewById(R.id.etWebsite);
        CheckBox cbIndustry = findViewById(R.id.cbIndustry);
        CheckBox cbFun = findViewById(R.id.cbFun);
        CheckBox cbEducation = findViewById(R.id.cbEducation);
        CheckBox cbServices = findViewById(R.id.cbServices);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            Company company = new Company();
            company.name = etName.getText().toString();
            company.address = etAddress.getText().toString();
            company.email = etEmail.getText().toString();
            company.phone = etPhone.getText().toString();
            company.website = etWebsite.getText().toString();

            try {
                company.latitude = Double.parseDouble(etLatitude.getText().toString());
                company.longitude = Double.parseDouble(etLongitude.getText().toString());
            } catch (NumberFormatException e) {
                company.latitude = 0;
                company.longitude = 0;
            }

            List<String> categories = new ArrayList<>();
            if (cbIndustry.isChecked()) categories.add("Industry");
            if (cbFun.isChecked()) categories.add("Fun");
            if (cbEducation.isChecked()) categories.add("Education");
            if (cbServices.isChecked()) categories.add("Services");
            company.category = String.join(",", categories);

            AppDatabase.getInstance(this).companyDao().insert(company);
            Toast.makeText(this, "Company saved!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
package com.example.mokpo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GradeActivity extends AppCompatActivity {

    Button btn_Humanities;
    Button btn_socialscience;
    Button btn_bio;
    Button btn_engineering;
    Button btn_business;
    Button btn_humanecology;
    Button btn_education;
    Button btn_pharmacy;
    Button btn_future;
    Button btn_direct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);

        btn_Humanities = findViewById(R.id.Humanities);
        btn_socialscience = findViewById(R.id.Socialscience);
        btn_bio = findViewById(R.id.Bio);
        btn_engineering = findViewById(R.id.Engineering);
        btn_business = findViewById(R.id.Business);
        btn_humanecology = findViewById(R.id.Humanecology);
        btn_education = findViewById(R.id.Education);
        btn_pharmacy = findViewById(R.id.Pharmacy);
        btn_future = findViewById(R.id.Future);
        btn_direct = findViewById(R.id.direct);

        btn_Humanities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, HumanitiesActivity.class);
                startActivity(intent);
            }
        });

        btn_socialscience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, SocialScienceActivity.class);
                startActivity(intent);
            }
        });

        btn_bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, BioActivity.class);
                startActivity(intent);
            }
        });

        btn_engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, EngineeringActivity.class);
                startActivity(intent);
            }
        });

        btn_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, BusinessActivity.class);
                startActivity(intent);
            }
        });

        btn_humanecology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, HumanEcologyActivity.class);
                startActivity(intent);
            }
        });

        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, EducationActivity.class);
                startActivity(intent);
            }
        });

        btn_pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, PharmacyActivity.class);
                startActivity(intent);
            }
        });

        btn_future.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, FutureActivity.class);
                startActivity(intent);
            }
        });

        btn_direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeActivity.this, DirectActivity.class);
                startActivity(intent);
            }
        });
    }
}

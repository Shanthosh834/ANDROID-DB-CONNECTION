package com.example.day25combinecomposhrumam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    TextView name2, your, skills, edu, ref, work, exp;
    String name2S, yourS, skillsS, eduS, refS, workS, expS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        name2 = findViewById(R.id.name2);
        your = findViewById(R.id.your);
        skills = findViewById(R.id.skills);
        edu = findViewById(R.id.edu);
        ref = findViewById(R.id.ref);
        work = findViewById(R.id.work);
        exp = findViewById(R.id.exp);

        name2S = name2.getText().toString();
        yourS = your.getText().toString();
        skillsS = skills.getText().toString();
        eduS = edu.getText().toString();
        refS = ref.getText().toString();
        workS = work.getText().toString();
        expS = exp.getText().toString();

        Intent in=getIntent();
        name2S = in.getStringExtra("name_key");
        yourS = in.getStringExtra("your_key");
        skillsS = in.getStringExtra("skills_key");
        eduS = in.getStringExtra("edu_key");
        refS = in.getStringExtra("ref_key");
        workS = in.getStringExtra("work_key");
        expS = in.getStringExtra("exp_key");


        name2.setText(name2S);
        your.setText(yourS);
        skills.setText(skillsS);
        edu.setText(eduS);
        ref.setText(refS);
        work.setText(workS);
        exp.setText(expS);
    }
}
package com.example.day25combinecomposhrumam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    EditText name, your, skills, edu, ref, work, exp;

    String nameS, yourS, skillsS, eduS, refS, workS, expS;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        name = findViewById(R.id.name);
        your = findViewById(R.id.your);
        skills = findViewById(R.id.skills);
        edu = findViewById(R.id.edu);
        ref = findViewById(R.id.ref);
        work = findViewById(R.id.work);
        exp = findViewById(R.id.exp);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameS = name.getText().toString();
                yourS = your.getText().toString();
                skillsS = skills.getText().toString();
                eduS = edu.getText().toString();
                refS = ref.getText().toString();
                workS = work.getText().toString();
                expS = exp.getText().toString();

                if (nameS.equals(""))
                {
                    Toast.makeText(MainActivity4.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                }

                else if (yourS.equals(""))
                {
                    Toast.makeText(MainActivity4.this, "Enter About Yourself", Toast.LENGTH_SHORT).show();
                }

                else if (skillsS.equals(""))
                {
                    Toast.makeText(MainActivity4.this, "Enter Your Skills", Toast.LENGTH_SHORT).show();
                }

                else if (eduS.equals(""))
                {
                    Toast.makeText(MainActivity4.this, "Enter Your Education", Toast.LENGTH_SHORT).show();
                }

                else if (refS.equals(""))
                {
                    Toast.makeText(MainActivity4.this, "Enter Your Reference", Toast.LENGTH_SHORT).show();
                }

                else if (workS.equals(""))
                {
                    Toast.makeText(MainActivity4.this, "Enter Your Work History", Toast.LENGTH_SHORT).show();
                }

                else if (expS.equals(""))
                {
                    Toast.makeText(MainActivity4.this, "Enter Your Work Experience", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent i = new Intent(MainActivity4.this, MainActivity5.class);
                    i.putExtra("name_key", nameS);
                    i.putExtra("your_key", yourS);
                    i.putExtra("skills_key", skillsS);
                    i.putExtra("edu_key", eduS);
                    i.putExtra("ref_key", refS);
                    i.putExtra("work_key", workS);
                    i.putExtra("exp_key", expS);
                    startActivity(i);
                }
            }
        });
    }
}
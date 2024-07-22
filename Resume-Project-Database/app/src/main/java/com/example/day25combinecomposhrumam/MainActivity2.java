package com.example.day25combinecomposhrumam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btn;
    EditText name, email, age, address, bg3, pass;
    String nameS, emailS, ageS, addressS, bg3S, rgs, passS;
    String namedb, maildb, passdb;
    RadioButton gender;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        address = findViewById(R.id.address);
        bg3 = findViewById(R.id.bg3);
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);
        pass = findViewById(R.id.pass);

        Database db = new Database(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameS = name.getText().toString();
                namedb = name.getText().toString();
                emailS = email.getText().toString();
                maildb = email.getText().toString();
                ageS = age.getText().toString();
                addressS = address.getText().toString();
                bg3S = bg3.getText().toString();
                passdb = pass.getText().toString();
                passS = pass.getText().toString();

                int select = rg.getCheckedRadioButtonId();
                gender = findViewById(select);
                if (gender != null) {
                    rgs = gender.getText().toString();
                } else {
                    rgs = "";
                }

                if (nameS.equals("") || emailS.equals("") || ageS.equals("") || addressS.equals("") || bg3S.equals("") || passS.equals("") || select == -1) {
                    Toast.makeText(MainActivity2.this, "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean check = db.insert(maildb, passdb);
                    if (check) {
                        Toast.makeText(MainActivity2.this, "Register success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity2.this, MainActivity.class);
                        i.putExtra("email_key", emailS);
                        i.putExtra("pass_key", passS);
                        startActivity(i);
                        Toast.makeText(MainActivity2.this, "Register success", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity2.this, "register fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
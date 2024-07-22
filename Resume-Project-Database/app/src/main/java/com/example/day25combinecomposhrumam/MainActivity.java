package com.example.day25combinecomposhrumam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mail, pass;
    String mailS, passS;
    Button login, signup;

    Database db = new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailS = mail.getText().toString();
                passS = pass.getText().toString();

                    if (mailS.equals("") || passS.equals("")) {
                        Toast.makeText(MainActivity.this, "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        Boolean checkUser = db.checkUserPass(mailS, passS);
                        if (checkUser==true) {

                            Intent i = new Intent(MainActivity.this, MainActivity5.class);
                            startActivity(i);
                            Toast.makeText(MainActivity.this, "Logged In successfully", Toast.LENGTH_SHORT).show();

                        }

                        else {
                            Toast.makeText(MainActivity.this, "user not exist ", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(ii);
            }
        });
    }
}
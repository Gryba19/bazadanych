package com.example.bazadanych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button wroc;
    Button wprowadz;
    EditText imie;
    EditText nazwiko;
    EditText haslo;
    EditText rhaslo;
    MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        wroc=findViewById(R.id.back);
        wprowadz=findViewById(R.id.register);
        imie=findViewById(R.id.name);
        nazwiko=findViewById(R.id.surname);
        haslo=findViewById(R.id.password);
        rhaslo=findViewById(R.id.repeatpassword);
        database= new MyDatabase(this,"people", null,1);
        wprowadz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= String.valueOf(imie.getText().toString());
                String Surname=String.valueOf(nazwiko.getText().toString());
                String Password=String.valueOf(haslo.getText().toString());
                String rePassword=String.valueOf(rhaslo.getText().toString());
                if(Password.length()>0 &&rePassword.length()>0 && Name.length()>0 && Surname.length()>0) {
                    database.registerPerson(String.valueOf(Name), String.valueOf(Surname), String.valueOf(Password),0);
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "jakieś pole jest puste", Toast.LENGTH_SHORT).show();
                }
            }
        });
        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
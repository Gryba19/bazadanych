package com.example.bazadanych;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDatabase database;
    EditText login;
    EditText password;
    Button log_in;
    Button register;
    TextView tekst;
   // Button pokaz;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database= new MyDatabase(this,"people", null,1);
        login=findViewById(R.id.imie);
        password=findViewById(R.id.haslo);
        log_in=findViewById(R.id.zaloguj);
        tekst=findViewById(R.id.zalogujInfo);
        /*pokaz=findViewById(R.id.pokaz);
        pokaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LoggedActivity.class);
                startActivity(intent);
            }
        });*/
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= String.valueOf(login.getText().toString());
                String Password=String.valueOf(password.getText().toString());
                 StringBuilder builder = new StringBuilder();
                Cursor cursor = database.checkPerson(Name, Password);
               if(cursor.moveToFirst()) {
                    builder.append("\nImie:" + cursor.getString(0));
                    builder.append("\nAdmin:" + cursor.getString(1));
                    builder.append("\n---------------------");
                   tekst.setText(builder.toString());
                   if (cursor.getInt(1)==1)
                   {
                       Intent intent = new Intent(MainActivity.this, LoggedAdmin.class);
                       startActivity(intent);
                   }
                   else
                   {
                       Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
                       startActivity(intent);
                   }

               }
                else{
                   tekst.setText("pusto");
               }

            }
        });
        register=findViewById(R.id.rejestruj);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
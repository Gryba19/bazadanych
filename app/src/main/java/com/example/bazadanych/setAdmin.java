package com.example.bazadanych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class setAdmin extends AppCompatActivity {
    Button wroc;
    Button ustaw;
    EditText id;
    MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_admin);
        wroc=findViewById(R.id.powrot);
        ustaw=findViewById(R.id.set);
        id=findViewById(R.id.podaj_id);
        database= new MyDatabase(this, "cars",null,1);
        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setAdmin.this, LoggedAdmin.class);
                startActivity(intent);

            }
        });
        ustaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numer=id.getText().toString();
                database.updateUser(1,numer);
                Intent intent = new Intent(setAdmin.this, LoggedAdmin.class);
                startActivity(intent);

            }
        });
    }
}
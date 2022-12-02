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
    EditText id2;

    Button zabierz;
    MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_admin);
        wroc=findViewById(R.id.cofnij);
        ustaw=findViewById(R.id.set);
        id2=findViewById(R.id.id_take);
        zabierz=findViewById(R.id.take);
        id=findViewById(R.id.podaj_id);
        database= new MyDatabase(this, "people",null,1);
        zabierz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numer2=id2.getText().toString();
                database.takeAdmin(0,numer2);
                Intent intent = new Intent(setAdmin.this, LoggedAdmin.class);
                startActivity(intent);
            }
        });
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
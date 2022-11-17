package com.example.bazadanych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedAdmin extends AppCompatActivity {

    MyDatabase database;
    TextView users;
    Button wroc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_admin);
        database= new MyDatabase(this, "people",null,1);
        users=findViewById(R.id.allPeople);
        wroc=findViewById(R.id.wroc);
        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoggedAdmin.this,MainActivity.class);
                startActivity(intent);
            }
        });
        refreshActivity();
    }
    public void refreshActivity() {
        StringBuilder builder = new StringBuilder();
        Cursor cursor = database.getAllPeople();
        while (cursor.moveToNext()) {
            builder.append("\nId:" + cursor.getString(0));
            builder.append("\nimie:" + cursor.getString(1));
            builder.append("\nnazwisko:" + cursor.getString(2));
            builder.append("\nadmin:" + cursor.getInt(3));
            builder.append("\nhaslo:" + cursor.getString(4));
            builder.append("\n---------------------");
        }
        users.setText(builder.toString());
    }
}
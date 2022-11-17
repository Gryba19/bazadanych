package com.example.bazadanych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedActivity extends AppCompatActivity {

    MyDatabase database;
    TextView pokaz;
    Button powrot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        database= new MyDatabase(this, "people",null,1);
        pokaz=findViewById(R.id.pokaz2);
        powrot=findViewById(R.id.back2);
        powrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        refreshActivity();
    }
    public void refreshActivity() {
        StringBuilder builder = new StringBuilder();
        Cursor cursor = database.getAllPeopleUser();
        while (cursor.moveToNext()) {
            builder.append("\nId:" + cursor.getString(0));
            builder.append("\nimie:" + cursor.getString(1));
            builder.append("\nnazwisko:" + cursor.getString(2));
            builder.append("\nadmin:" + cursor.getInt(3));
            builder.append("\n---------------------");
        }
        pokaz.setText(builder.toString());
    }
}
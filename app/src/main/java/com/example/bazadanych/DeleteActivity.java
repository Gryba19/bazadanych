package com.example.bazadanych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeleteActivity extends AppCompatActivity {

    MyDatabase database;
    EditText podaj;
    Button usun;
    TextView info;
    Button wroc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        podaj=findViewById(R.id.podajId);
        wroc=findViewById(R.id.powrot);
        usun=findViewById(R.id.delete);
        database= new MyDatabase(this, "cars",null,1);
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numer=podaj.getText().toString();
                //public int delete("cars", numer, null);
                database.deletePerson(numer);
                Intent intent = new Intent(DeleteActivity.this, LoggedAdmin.class);
                startActivity(intent);
            }
        });
        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteActivity.this, LoggedAdmin.class);
                startActivity(intent);
            }
        });
    }
}
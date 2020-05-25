package com.example.uniduevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class KoncertiActivity extends AppCompatActivity {
    TextView TextView;
    String tekst = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koncerti);

        TextView = (TextView) findViewById(R.id.textView);


        DatabaseHelper db = new DatabaseHelper(this);

        List<Koncerti> koncerti = db.getAllKoncerti();


        for(Koncerti k : koncerti){

            String log = "NAZIV: " + k.getNaziv() + ", DATUM: " +k.getDatum() + ", VRIJEME: " +k.getVrijeme()+"\n";
            tekst = tekst + log;
        }
        TextView.setText(tekst);
    }
}

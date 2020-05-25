package com.example.uniduevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SportActivity extends AppCompatActivity {
    TextView TextView;
    String tekst = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        TextView = (TextView) findViewById(R.id.textView);


        DatabaseHelper db = new DatabaseHelper(this);

        List<Sportovi> sportovi = db.getAllSportovi();


        for(Sportovi s : sportovi){

            String log = "NAZIV: " + s.getNaziv() + ", DATUM: " +s.getDatum() + ", VRIJEME: " +s.getVrijeme()+"\n";
            tekst = tekst + log;
        }
        TextView.setText(tekst);
    }
}

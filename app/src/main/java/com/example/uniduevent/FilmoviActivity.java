package com.example.uniduevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FilmoviActivity extends AppCompatActivity {
    TextView TextView;
    String tekst = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmovi);

        TextView = (TextView) findViewById(R.id.textView);

        DatabaseHelper db = new DatabaseHelper(this);



        //unosenje filmova
        //db.addFilm(new Filmovi(1,"naziv1", "05.10.2019", "19:00"));
        //db.addFilm(new Filmovi(2,"naziv2", "06.10.2019", "20:00"));
        //db.addFilm(new Filmovi(3,"naziv3", "07.10.2019", "21:00"));
        //db.addFilm(new Filmovi(4,"naziv4", "08.10.2019", "23:00"));

        //citanje i prikaz svih filmova

        List<Filmovi> filmovi = db.getAllFilmovi();


        for(Filmovi f : filmovi){
            
            String log = "NAZIV: " + f.getNaziv() + ", DATUM: " +f.getDatum() + ", VRIJEME: " +f.getVrijeme()+"\n";
            tekst = tekst + log;
        }
        TextView.setText(tekst);




    }
}

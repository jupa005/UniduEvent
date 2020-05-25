package com.example.uniduevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("UniduEvent");
    }

    public void pozoviFilmove(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVraca
        Intent i = new Intent(this, FilmoviActivity.class);
        // Šalje se 1 parametar - String s ključem "poruka" i vrijednošću "Dobar dan!"
        // Ako se drugoj aktivnosti ne šalju parametri, ovaj redak nije potreban

        // Poziv aktivnosti koja ništa ne vraća pozivatelju
        startActivity(i);
    }

    public void unosFilma(View v){
        Intent i = new Intent(this, UnosFilmaActivity.class);
        startActivity(i);
    }

    public void unosKoncerta(View v){
        Intent i = new Intent(this, UnosKoncertaActivity.class);
        startActivity(i);
    }

    public void unosSporta(View v){
        Intent i = new Intent(this, UnosSportaActivity.class);
        startActivity(i);
    }

    public void pozoviKoncerte(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVraca
        Intent i = new Intent(this, KoncertiActivity.class);
        // Šalje se 1 parametar - String s ključem "poruka" i vrijednošću "Dobar dan!"
        // Ako se drugoj aktivnosti ne šalju parametri, ovaj redak nije potreban

        // Poziv aktivnosti koja ništa ne vraća pozivatelju
        startActivity(i);
    }

    public void pozoviSportove(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVraca
        Intent i = new Intent(this, SportActivity.class);
        // Šalje se 1 parametar - String s ključem "poruka" i vrijednošću "Dobar dan!"
        // Ako se drugoj aktivnosti ne šalju parametri, ovaj redak nije potreban

        // Poziv aktivnosti koja ništa ne vraća pozivatelju
        startActivity(i);
    }
}

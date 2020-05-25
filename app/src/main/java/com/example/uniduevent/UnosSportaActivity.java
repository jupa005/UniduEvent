package com.example.uniduevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UnosSportaActivity extends AppCompatActivity {
    EditText naziv,datum,vrijeme;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unos_sporta);
    }

    public void unos(View v){
        naziv = (EditText) findViewById(R.id.naziv);
        datum = (EditText) findViewById(R.id.datum);
        vrijeme = (EditText) findViewById(R.id.vrijeme);
        if (naziv.getText().toString().length()<1 || datum.getText().toString().length()<1 || vrijeme.getText().toString().length()<1){
            Toast.makeText(this,"Morate unijeti sve podatke!",Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseHelper db = new DatabaseHelper(this);
        db.addSport(new Sportovi(naziv.getText().toString(),datum.getText().toString(),vrijeme.getText().toString()));
        Toast.makeText(this,"Unos uspješan!", Toast.LENGTH_SHORT).show();
    }

    public void brisanje(View v){
        naziv = (EditText) findViewById(R.id.naziv);
        if (naziv.getText().toString().length()<1){
            Toast.makeText(this,"Morate unijeti naziv sportskog događaja!",Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseHelper db = new DatabaseHelper(this);
        List<Sportovi> sportovi = db.getAllSportovi();
        for(Sportovi s : sportovi){

            if(s.getNaziv().equals(naziv.getText().toString())){
                db.deleteSport(s);
                a=1;
                Toast.makeText(this,"Sportski događaj izbrisan!",Toast.LENGTH_SHORT).show();
            }
        }
        if(a==0){
            Toast.makeText(this,"Sportski događaj s tim nazivom ne postoji!",Toast.LENGTH_SHORT).show();

        }
        else{
            a=0;
        }
    }
}

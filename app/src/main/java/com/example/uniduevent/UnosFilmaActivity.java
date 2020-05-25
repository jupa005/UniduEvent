package com.example.uniduevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UnosFilmaActivity extends AppCompatActivity {
    EditText naziv,datum,vrijeme;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unos_filma);
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
        db.addFilm(new Filmovi(naziv.getText().toString(),datum.getText().toString(),vrijeme.getText().toString()));
        Toast.makeText(this,"Unos uspješan!", Toast.LENGTH_SHORT).show();
    }

    public void brisanje(View v){
        naziv = (EditText) findViewById(R.id.naziv);
        if (naziv.getText().toString().length()<1){
            Toast.makeText(this,"Morate unijeti naziv filma!",Toast.LENGTH_SHORT).show();
            return;
        }
        DatabaseHelper db = new DatabaseHelper(this);
        List<Filmovi> filmovi = db.getAllFilmovi();
        for(Filmovi f : filmovi){

            if(f.getNaziv().equals(naziv.getText().toString())){
                db.deleteFilm(f);
                a=1;
                Toast.makeText(this,"Film izbrisan!",Toast.LENGTH_SHORT).show();
            }
        }
        if(a==0){
            Toast.makeText(this,"Film s tim nazivom ne postoji!",Toast.LENGTH_SHORT).show();

        }
        else{
            a=0;
        }
    }
}

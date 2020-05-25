package com.example.uniduevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UnosKoncertaActivity extends AppCompatActivity {
    EditText naziv,datum,vrijeme;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unos_koncerta);
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
        db.addKoncert(new Koncerti(naziv.getText().toString(),datum.getText().toString(),vrijeme.getText().toString()));
        Toast.makeText(this,"Unos uspješan!", Toast.LENGTH_SHORT).show();
    }

    public void brisanje(View v){
        naziv = (EditText) findViewById(R.id.naziv);
        if (naziv.getText().toString().length()<1){
            Toast.makeText(this,"Morate unijeti naziv koncerta!",Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseHelper db = new DatabaseHelper(this);
        List<Koncerti> koncerti = db.getAllKoncerti();
        for(Koncerti k : koncerti){

            if(k.getNaziv().equals(naziv.getText().toString())){
                db.deleteKoncert(k);
                a=1;
                Toast.makeText(this,"Koncert izbrisan!",Toast.LENGTH_SHORT).show();
            }
        }
        if(a==0){
            Toast.makeText(this,"Koncert s tim nazivom ne postoji!",Toast.LENGTH_SHORT).show();

        }
        else{
            a=0;
        }
    }

}

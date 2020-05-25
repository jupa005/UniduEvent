package com.example.uniduevent;

public class Filmovi {
    int id;
    String naziv;
    String datum;
    String vrijeme;

    public Filmovi(){

    }

    public Filmovi(String naziv, String datum, String vrijeme){
        this.naziv=naziv;
        this.datum=datum;
        this.vrijeme=vrijeme;

    }

    public Filmovi(int id, String naziv, String datum, String vrijeme){
        this.id=id;
        this.naziv=naziv;
        this.datum=datum;
        this.vrijeme=vrijeme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }
}

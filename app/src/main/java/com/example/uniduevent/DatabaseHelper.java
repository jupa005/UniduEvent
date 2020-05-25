package com.example.uniduevent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "uniduevent";
    private static final String TABLE_FILMOVI = "filmovi";
    private static final String TABLE_KONCERTI = "koncerti";
    private static final String TABLE_SPORTOVI = "sportovi";
    private static final String KEY_ID = "id";
    private static final String KEY_NAZIV = "naziv";
    private static final String KEY_DATUM = "datum";
    private static final String KEY_VRIJEME = "vrijeme";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FILMOVI_TABLE = "CREATE TABLE " + TABLE_FILMOVI + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAZIV+" TEXT," + KEY_DATUM+" TEXT," + KEY_VRIJEME+" TEXT" +")";
        String CREATE_KONCERTI_TABLE = "CREATE TABLE " + TABLE_KONCERTI + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAZIV+" TEXT," + KEY_DATUM+" TEXT," + KEY_VRIJEME+" TEXT" +")";
        String CREATE_SPORTOVI_TABLE = "CREATE TABLE " + TABLE_SPORTOVI + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAZIV+" TEXT," + KEY_DATUM+" TEXT," + KEY_VRIJEME+" TEXT" +")";
        db.execSQL(CREATE_FILMOVI_TABLE);
        db.execSQL(CREATE_KONCERTI_TABLE);
        db.execSQL(CREATE_SPORTOVI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FILMOVI );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KONCERTI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPORTOVI);
        onCreate(db);
    }

    void addFilm(Filmovi filmovi){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAZIV, filmovi.getNaziv());
        values.put(KEY_DATUM, filmovi.getDatum());
        values.put(KEY_VRIJEME, filmovi.getVrijeme());

        db.insert(TABLE_FILMOVI, null, values);
        db.close();


    }

    void addKoncert(Koncerti koncerti){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAZIV, koncerti.getNaziv());
        values.put(KEY_DATUM, koncerti.getDatum());
        values.put(KEY_VRIJEME, koncerti.getVrijeme());

        db.insert(TABLE_KONCERTI, null, values);
        db.close();

    }

    void addSport(Sportovi sportovi){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAZIV, sportovi.getNaziv());
        values.put(KEY_DATUM, sportovi.getDatum());
        values.put(KEY_VRIJEME, sportovi.getVrijeme());

        db.insert(TABLE_SPORTOVI, null, values);
        db.close();
    }

    Filmovi getFilm(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FILMOVI, new String[] {KEY_ID, KEY_NAZIV, KEY_DATUM, KEY_VRIJEME}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }

        Filmovi filmovi = new Filmovi(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return filmovi;

    }

    public List<Filmovi> getAllFilmovi(){
        List<Filmovi> filmoviList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_FILMOVI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Filmovi filmovi = new Filmovi();
                filmovi.setId(Integer.parseInt(cursor.getString(0)));
                filmovi.setNaziv(cursor.getString(1));
                filmovi.setDatum(cursor.getString(2));
                filmovi.setVrijeme(cursor.getString(3));

                filmoviList.add(filmovi);
            } while (cursor.moveToNext());

        }

        return filmoviList;
    }

    public List<Koncerti> getAllKoncerti(){
        List<Koncerti> koncertiList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_KONCERTI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Koncerti koncerti = new Koncerti();
                koncerti.setId(Integer.parseInt(cursor.getString(0)));
                koncerti.setNaziv(cursor.getString(1));
                koncerti.setDatum(cursor.getString(2));
                koncerti.setVrijeme(cursor.getString(3));

                koncertiList.add(koncerti);
            } while (cursor.moveToNext());

        }

        return koncertiList;
    }

    public List<Sportovi> getAllSportovi(){
        List<Sportovi> sportoviList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_SPORTOVI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                Sportovi sportovi = new Sportovi();
                sportovi.setId(Integer.parseInt(cursor.getString(0)));
                sportovi.setNaziv(cursor.getString(1));
                sportovi.setDatum(cursor.getString(2));
                sportovi.setVrijeme(cursor.getString(3));

                sportoviList.add(sportovi);
            } while (cursor.moveToNext());

        }

        return sportoviList;
    }

    public int updateFilmovi(Filmovi filmovi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAZIV, filmovi.getNaziv());
        values.put(KEY_DATUM, filmovi.getDatum());
        values.put(KEY_VRIJEME, filmovi.getVrijeme());

        return db.update(TABLE_FILMOVI, values, KEY_ID + "=?",
                new String[]{String.valueOf(filmovi.getId())});

    }

    public void deleteFilm(Filmovi filmovi){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FILMOVI, KEY_ID + "=?",
                new String[]{String.valueOf(filmovi.getId())});
        db.close();
    }

    public void deleteKoncert(Koncerti koncerti){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_KONCERTI, KEY_ID + "=?",
                new String[]{String.valueOf(koncerti.getId())});
        db.close();
    }

    public void deleteSport(Sportovi sportovi){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SPORTOVI, KEY_ID + "=?",
                new String[]{String.valueOf(sportovi.getId())});
        db.close();
    }

    public int getFilmoviCount(){
        String countQuerry = "SELECT * FROM " + TABLE_FILMOVI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuerry,null);
        cursor.close();

        return cursor.getCount();
    }


}

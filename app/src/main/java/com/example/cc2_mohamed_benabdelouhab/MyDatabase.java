package com.example.cc2_mohamed_benabdelouhab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    public static String DB_NAME="enterprises.db";
    public static String TABLE_NAME="Entreprise";
    public static String COL1="ID";
    public static String COL2="Raison";
    public static String COL3="adresse";
    public static String COL4="Capitale";


    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TABLE_NAME + "("+COL1+" integer primary key autoincrement,"+COL2+" TEXT,"+COL3+" TEXT,"+COL4+" double)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }



    public static long AddEntreprise(SQLiteDatabase db, Entreprise e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getRaison());
        cv.put(COL3,e.getAdresse());
        cv.put(COL4,e.getCapitale());
        return db.insert(TABLE_NAME,null,cv);
    }


    public static long UpdateEntreprise(SQLiteDatabase db, Entreprise e){
        ContentValues cv = new ContentValues();
        cv.put(COL2,e.getRaison());
        cv.put(COL3,e.getAdresse());
        cv.put(COL4,e.getCapitale());
        return db.update(TABLE_NAME,cv,"id="+e.getId(),null);
    }


    public  static long DeleteEntreprise(SQLiteDatabase db, int id){
        return db.delete(TABLE_NAME,"id="+id,null);
    }


    public static ArrayList<Entreprise> getAllEntreprise(SQLiteDatabase db){
        ArrayList<Entreprise> entrs = new ArrayList<>();

        Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        while(cur.moveToNext()){
            Entreprise e = new Entreprise();
            e.setId(cur.getInt(0));
            e.setRaison(cur.getString(1));
            e.setAdresse(cur.getString(2));
            e.setCapitale(cur.getDouble(3));
            entrs.add(e);
        }

        return entrs;
    }

    public static Entreprise getOneprod(SQLiteDatabase sqLiteDatabase, int id){
        Entreprise e = null;

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id,null);

        if(cur.moveToNext()){
            e = new Entreprise();
            e.setId(cur.getInt(0));
            e.setRaison(cur.getString(1));
            e.setAdresse(cur.getString(2));
            e.setCapitale(cur.getDouble(3));
        }

        return e;
    }
}

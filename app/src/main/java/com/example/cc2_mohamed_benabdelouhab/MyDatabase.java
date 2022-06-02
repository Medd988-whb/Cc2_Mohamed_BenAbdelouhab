package com.example.cc2_mohamed_benabdelouhab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}

package com.example.cc2_mohamed_benabdelouhab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class List_Entr extends AppCompatActivity {

    ListView lst;
    MyDatabase db;
    ArrayList<Entreprise> ents;
    MyAdapter ad;
    TextView t1;
    TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_entr);

        db = new MyDatabase(this);
        lst = findViewById(R.id.lst);

        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);

        ents = db.getAllEntreprise(db.getReadableDatabase());




        ad = new MyAdapter( getApplicationContext ( ) , ents);



        lst.setAdapter(ad);
    }


    public class MyAdapter extends BaseAdapter {
        Context c;
        ArrayList<Entreprise> liste_arr;
        public MyAdapter(Context c, ArrayList<Entreprise> liste) {
            this.c = c;
            this. liste_arr = liste_arr;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Entreprise getItem(int position) {
            Entreprise e= new Entreprise();
            return e;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent) {

            LayoutInflater li = getLayoutInflater();
            View v = li.inflate(R.layout.lstex12, null);
            t1.setText(liste_arr.get(position).getRaison());
            t2.setText(String.valueOf(liste_arr.get(position).getCapitale()));

            return v;
        }
    }

}

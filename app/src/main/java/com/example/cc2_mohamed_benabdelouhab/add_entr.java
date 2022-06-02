package com.example.cc2_mohamed_benabdelouhab;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class add_entr extends AppCompatActivity {


    EditText ed1,ed2,ed3;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entr);

        db = new MyDatabase(this);
        ed1 = findViewById(R.id.addRais);
        ed2 = findViewById(R.id.addAdr);
        ed3 = findViewById(R.id.addCap);


    }

    public void annuler(View view){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void ajouter(View view){
        if(ed1.getText().toString().isEmpty()){
            Toast.makeText(this, "la zone de Raison social vide", Toast.LENGTH_SHORT).show();
            ed1.requestFocus();
            return;
        }
        if(ed2.getText().toString().isEmpty()){
            Toast.makeText(this, "la zone d'Adresse vide", Toast.LENGTH_SHORT).show();
            ed2.requestFocus();
            return;
        }
        if(ed3.getText().toString().isEmpty()){
            Toast.makeText(this, "la zone de Capital vide", Toast.LENGTH_SHORT).show();
            ed3.requestFocus();
            return;
        }

        Entreprise e = new Entreprise();

        e.setRaison(ed1.getText().toString());
        e.setAdresse(ed2.getText().toString());
        e.setCapitale(Double.parseDouble(ed3.getText().toString()));

        if(db.AddEntreprise(db.getWritableDatabase(),e)==-1)
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion reussie", Toast.LENGTH_SHORT).show();


    }
}

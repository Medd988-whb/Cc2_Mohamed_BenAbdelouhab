package com.example.cc2_mohamed_benabdelouhab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;



public class Edit_Entr extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    MyDatabase db;
    Spinner sp;
    ArrayList<Entreprise> ents;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_entr);

        db = new MyDatabase(this);
        ed1 = findViewById(R.id.addRais);
        ed2 = findViewById(R.id.addAdr);
        ed3 = findViewById(R.id.addCap);
        sp= findViewById(R.id.sp);

        ents = db.getAllEntreprise(db.getReadableDatabase());

        ArrayList<String> idsEntr = new ArrayList<>();
        for(Entreprise es: ents)
            idsEntr.add(String.valueOf(es.getId()));

        ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,idsEntr);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Entreprise e = ents.get(i);
                ed1.setText(e.getRaison());
                ed2.setText(e.getAdresse());
                ed3.setText(String.format("%f",e.getCapitale()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    public void edit(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(Edit_Entr.this);
        alert.setTitle("Modification Entrprise");
        alert.setMessage("Voulez-vous modifier ce Entrprise ?");

        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int position = sp.getSelectedItemPosition();
                Entreprise e = ents.get(position);

                e.setRaison(ed1.getText().toString());
                e.setAdresse(ed2.getText().toString());
                e.setCapitale(Double.parseDouble(ed3.getText().toString()));



                if(db.UpdateEntreprise(db.getWritableDatabase(),e)==-1)
                    Toast.makeText(Edit_Entr.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(Edit_Entr.this, "Modification reussie", Toast.LENGTH_SHORT).show();
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Edit_Entr.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }


    public void delete(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(Edit_Entr.this);
        alert.setTitle("Suppression Entrprise");
        alert.setMessage("Voulez-vous supprimer ce Entrprise ?");
        alert.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Entreprise e = ents.get(sp.getSelectedItemPosition());

                if(db.DeleteEntreprise(db.getWritableDatabase(),e.getId())==-1)
                    Toast.makeText(Edit_Entr.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(Edit_Entr.this, "Suppression reussie", Toast.LENGTH_SHORT).show();
                    ad.remove(String.valueOf(e.getId()));
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Edit_Entr.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}

package com.example.cc2_mohamed_benabdelouhab;

import java.io.Serializable;

public class Entreprise implements Serializable {

    private int id;
    private String Raison;
    private String Adresse;
    private double Capitale;


    public Entreprise(){}

    public Entreprise(int id, String Raison, String Adresse, double Capitale) {
        this.id = id;
        this.Raison = Raison;
        this.Adresse = Adresse;
        this.Capitale = Capitale;
    }




    public int getId() {
        return id;
    }

    public String getRaison() {
        return Raison;
    }

    public String getAdresse() {
        return Adresse;
    }

    public double getCapitale() {
        return Capitale;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRaison(String raison) {
        Raison = raison;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public void setCapitale(double capitale) {
        Capitale = capitale;
    }



}

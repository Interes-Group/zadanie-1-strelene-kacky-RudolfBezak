package sk.stuba.fei.uim.oop.hra;


import sk.stuba.fei.uim.oop.karty.Karta;

public class Hrac {
    //hrac si chrani kacky ktore maju cislo svojho id
    int id;
    Karta[] ruka;
    int zivot;

    public Hrac(int i) {
        this.id = i;
        this.ruka = new Karta[3];
        this.zivot = 5;
    }

    public void odoberZivot(){
        this.zivot--;
    }

    public Karta[] getRuka() {
        return ruka;
    }

    public void setRuka(Karta[] ruka) {
        this.ruka = ruka;
    }

    public int getZivot() {
        return zivot;
    }
}
package sk.stuba.fei.uim.oop.karty;


import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.hra.Obraz;

import javax.swing.*;

public class Karta {

    String meno;
    ImageIcon obrazok;

    public Karta() {
    }

    public String getMeno() {
        return meno;
    }

    public boolean viemZahrat(Jazero jazero, Kacky balikKaciek){
        return true;
    }

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac, Obraz obraz){
        return false;

    }
    public ImageIcon getObrazok() {
        return obrazok;
    }
}


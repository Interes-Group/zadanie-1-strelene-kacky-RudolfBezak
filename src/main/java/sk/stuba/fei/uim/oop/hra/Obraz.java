package sk.stuba.fei.uim.oop.hra;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sk.stuba.fei.uim.oop.karty.Karta;
import sk.stuba.fei.uim.oop.karty.ZamierKarta;

import javax.swing.*;

public class Obraz {
    JFrame okno;
    JButton tlacitko0;
    JButton tlacitko1;
    JButton tlacitko2;
    JLabel[] vypisNaKarty;
    JLabel[] hraciLabely;
    String[] farbyHracov;
    JLabel[] farbyHracovLabel;
    JLabel hracNaRade;
    int posledneTlacitko;
    JLabel vypis;

    JButton[] kacice;


    public Obraz() {
        //vykreslovanie
        okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setTitle("Strelene kacice");

        okno.setSize(1280,720);
        okno.getContentPane().setBackground(new Color(100,180,130));


        okno.setLayout(null);


        //nacitaj obrazky
        //kacka0
        ImageIcon kacka0 = new ImageIcon("obrazky\\kacka0.png");
        Image zamierImage = kacka0.getImage();
        zamierImage = zamierImage.getScaledInstance(10*16,10*24,Image.SCALE_DEFAULT);
        kacka0.setImage(zamierImage);



        //hod tam 3 tlacitka
        tlacitko0 = new JButton();
        tlacitko0.setBounds(350,430,10*16,10*24);
        okno.add(tlacitko0);
        tlacitko0.setIcon(kacka0);
        tlacitko0.addActionListener(e -> posledneTlacitko = 7);

        tlacitko1 = new JButton();
        tlacitko1.setBounds(550,430,10*16,10*24);
        okno.add(tlacitko1);
        tlacitko1.setIcon(kacka0);
        tlacitko1.addActionListener(e -> posledneTlacitko = 8);

        tlacitko2 = new JButton();
        tlacitko2.setBounds(750,430,10*16,10*24);
        okno.add(tlacitko2);
        tlacitko2.setIcon(kacka0);
        tlacitko2.addActionListener(e -> posledneTlacitko = 9);

        //hod tam 6 miest na kacice
        kacice = new JButton[6];
        for (int i = 0; i < 6; i++){
            kacice[i] = new JButton(kacka0);
            kacice[i].setBounds(50+200*i,10,10*16,10*24);
            okno.add(kacice[i]);
        }
        //pridaj actionlistenery
        kacice[0].addActionListener(e -> posledneTlacitko = 1);
        //pridaj actionlistenery
        kacice[1].addActionListener(e -> posledneTlacitko = 2);
        //pridaj actionlistenery
        kacice[2].addActionListener(e -> posledneTlacitko = 3);
        //pridaj actionlistenery
        kacice[3].addActionListener(e -> posledneTlacitko = 4);
        //pridaj actionlistenery
        kacice[4].addActionListener(e -> posledneTlacitko = 5);
        //pridaj actionlistenery
        kacice[5].addActionListener(e -> posledneTlacitko = 6);


        //hod tam miesto na vypis
        hraciLabely = new JLabel[6];
        hraciLabely[0] = new JLabel("kolko hracov?");
        hraciLabely[0].setBounds(70,170,360,180);
        okno.add(hraciLabely[0]);

        for (int i = 1; i < hraciLabely.length; i++){
            hraciLabely[i] = new JLabel(""+(i+1));
            hraciLabely[i].setBounds(130+200*i,170,360,180);
            okno.add(hraciLabely[i]);
        }

        vypisNaKarty = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            vypisNaKarty[i] = new JLabel("");
            okno.add(vypisNaKarty[i]);
        }
        vypisNaKarty[0].setBounds(370, 300, 10 * 16, 10 * 24);
        vypisNaKarty[1].setBounds(570, 300, 10 * 16, 10 * 24);
        vypisNaKarty[2].setBounds(770, 300, 10 * 16, 10 * 24);

        farbyHracovLabel = new JLabel[6];
        farbyHracov = new String[6];
        for (int i = 0; i < farbyHracovLabel.length;i++){
            farbyHracovLabel[i] = new JLabel();
        }
        hracNaRade = new JLabel();
        hracNaRade.setBounds(370,280,16*10,10*24);
        okno.add(hracNaRade);

        vypis = new JLabel();
        vypis.setBounds(950, 330, 10 * 16, 10 * 24);
        okno.add(vypis);






        okno.setVisible(true);
    }
    //funkcie na zmenu obrazkov
    public void zmenRuku(Karta[] karty){
        this.tlacitko0.setIcon(karty[0].getObrazok());
        this.tlacitko1.setIcon(karty[1].getObrazok());
        this.tlacitko2.setIcon(karty[2].getObrazok());
        for (int i = 0; i < 3; i++){
        this.vypisNaKarty[i].setText(karty[i].getMeno());
        }
    }

    public void zmenJazero(Jazero jazero){
        int[] kackyVJazere = jazero.getJazero();
        int[] zameriavaci = jazero.getZameriavaci();
        ImageIcon[] fotkyKaciek = jazero.getObrazokKaciek();
        for (int i = 0; i < 6; i++){
            this.kacice[i].setIcon(fotkyKaciek[(2*kackyVJazere[i])+zameriavaci[i]]);
        }
    }
    public void deleteLabely(){
        for (JLabel jLabel : this.hraciLabely) {
            jLabel.setText("");
        }
    }
    public void legendaFariebZivot(Hrac[] hraci, int pocetHracov){
        //legenda farieb

        farbyHracov[0] = "Hrac 1 je modry";
        farbyHracov[1] = "Hrac 2 je cerveny";
        farbyHracov[2] = "Hrac 3 je zeleny";
        farbyHracov[3] = "Hrac 4 je zlty";
        farbyHracov[4] = "Hrac 5 je tyrkysovy";
        farbyHracov[5] = "Hrac 6 je fialovy";

        for (int i = 0; i < pocetHracov;i++) {
            farbyHracovLabel[i].setText((farbyHracov[i])+" a ma "+(hraci[i].getZivot())+" kaciek");
            farbyHracovLabel[i].setBounds(10, 490+i*30, 300, 30);
            this.okno.add(farbyHracovLabel[i]);
            //okno.validate();
            SwingUtilities.updateComponentTreeUI(okno);
        }
    }
    public void napisHraca(Hrac hrac){
        this.hracNaRade.setText("Na rade je hrac "+hrac.getId());
    }

    public int getPosledneTlacitko() {
        return posledneTlacitko;
    }

    public void setPosledneTlacitko(int posledneTlacitko) {
        this.posledneTlacitko = posledneTlacitko;
    }

    public void setVypis(String string){
        vypis.setText(string);
    }
}

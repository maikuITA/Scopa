package scopa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tavolo {
    private ArrayList<Carta> coperte;
    private ArrayList<Carta> scoperte;
    private Giocatore[] giocatori;

    public Tavolo(){
        coperte = new ArrayList<Carta>();
        scoperte = new ArrayList<Carta>();
        giocatori = new Giocatore[4];
    }

    public void setCoperte(ArrayList<Carta> coperte) {
        this.coperte = coperte;
    }

    public void setScoperte(ArrayList<Carta> scoperte) {
        this.scoperte = scoperte;
    }

    public void setGiocatori(Giocatore[] giocatori) {
        this.giocatori = giocatori;
    }

    public ArrayList<Carta> getCoperte() {
        return coperte;
    }

    public ArrayList<Carta> getScoperte() {
        return scoperte;
    }

    public Giocatore[] getGiocatori() {
        return giocatori;
    }

    // Creiamo un mazzo da 40 carte, 10 per seme
    public void creaMazzo() {
        String[] semi = new String[] {"spade", "bastoni", "coppe", "denari"};
        for(String seme : semi) {
            for(int i = 0; i < 10; i++) {
                this.coperte.add(new Carta(i+1, seme));
            }
        }
    }

    public void mischiaMazzo() {
        Collections.shuffle(coperte);
    }

    public boolean scopri() {
        for(int i = 0; i < 4; i++) {
            int x = (int) (Math.random() * coperte.size());
            this.scoperte.add(this.coperte.get(x));
            this.coperte.remove(this.coperte.get(x));
        }
        return true;
    }

    public void daiCarte() {
        for(Giocatore giocatore : giocatori){
            for (int i = 0; i < 3; i++) {
                int x = (int) (Math.random() * coperte.size());
                giocatore.addMano(this.coperte.get(x));
                this.coperte.remove(this.coperte.get(x));
            }
        }
    }

    public void giocata(){
        // Per ogni giocatore
        for(Giocatore giocatore : giocatori){
            Carta giocata = giocatore.gioca();
            // Controllo se la giocata prende delle carte
            boolean giocataOK = false;
            for(Carta scoperta : scoperte) {
                // Se la giocata prende delle carte
                if (giocata.getNumber() == scoperta.getNumber()) {
                    Carta coppia = scoperta;
                    // Aggiungo al mazzetto del giocatore la coppia
                    giocatore.addMazzetto(giocata);
                    giocatore.addMazzetto(coppia);
                    scoperte.remove(coppia);
                    giocatore.delMano(giocata);
                    // Se non rimangono carte scoperte il giocatore ha fatto scopa
                    if (scoperte.size() == 0) {
                        // Aggiungo un punto per la scopa
                        giocatore.addPunto();
                    }
                    giocataOK = true;
                    break;
                }
            }
            if(!giocataOK) {
                giocatore.delMano(giocata);
                scoperte.add(giocata);
            }
        }
    }

}

// maiku.
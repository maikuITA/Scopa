package scopa;

import java.util.ArrayList;
import java.util.Random;

public class Giocatore {
    private String nome;
    private ArrayList<Carta> mano;
    private ArrayList<Carta> mazzetto;
    private int punteggio;

    public Giocatore(String nome) {
        this.nome = nome;
        mano = new ArrayList<Carta>();
        mazzetto = new ArrayList<Carta>();
        punteggio = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public void addMano(Carta carta) {
        this.mano.add(carta);
    }

    public void delMano(Carta carta) {
        this.mano.remove(carta);
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public ArrayList<Carta> getMazzetto() {
        return mazzetto;
    }

    public void addMazzetto(Carta carta) {
        this.mazzetto.add(carta);
    }

    public void delMazzetto(Carta carta) {
        this.mazzetto.remove(carta);
    }

    public void addPunto(){
        this.punteggio += 1;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public Carta gioca() {
        int x;
        x = (int) (Math.random() * mano.size());
        // TESTING System.out.println(mano.size());
        Carta giocata = this.mano.get(x);
        this.mano.remove(x);
        return giocata;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " - Mano: " + this.mano + " - Mazzetto: " + this.mazzetto + " - Punteggio: " + this.punteggio;
    }
}

// maiku.
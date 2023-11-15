package scopa;

import java.util.ArrayList;

public class Mazzo {
    private ArrayList<Carta> mazzo;

    public Mazzo(){
        mazzo = new ArrayList<Carta>();
    }

    public void setMazzo(ArrayList<Carta> mazzo) {
        this.mazzo = mazzo;
    }

    public ArrayList<Carta> getMazzo() {
        return mazzo;
    }

    public void addCarta(Carta carta) {
        mazzo.add(carta);
    }

    public void delCarta(Carta carta) {
        mazzo.remove(carta);
    }

    @Override
    public String toString() {
        return mazzo.toString();
    }
}

// maiku.
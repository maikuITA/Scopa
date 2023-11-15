package scopa;

public class Carta {
    private int number;
    private String seme;

    public Carta(int number, String seme) {
        this.number = number;
        this.seme = seme;
    }

    public int getNumber() {
        return number;
    }

    public String getSeme() {
        return seme;
    }

    @Override
    public String toString() {
        return number + " " + seme;
    }
}

// maiku.
package scopa;

public class App {
    public static void main(String[] args){

        // Tavolo del gioco
        Tavolo tavolo = new Tavolo();

        // Giocatori
        Giocatore g1 = new Giocatore("1");
        Giocatore g2 = new Giocatore("2");
        Giocatore g3 = new Giocatore("3");
        Giocatore g4 = new Giocatore("4");

        // Aggiungo i giocatori al tavolo
        tavolo.setGiocatori(new Giocatore[]{g1, g2, g3, g4});

        // Creo il mazzo del tavolo e lo mischio
        tavolo.creaMazzo();
        // TESTING System.out.println(tavolo.getCoperte());
        tavolo.mischiaMazzo();
        // TESTING System.out.println(tavolo.getCoperte());

        boolean inizio = false;
        while(tavolo.getCoperte().size() > 0) {

            System.out.println("\n################################################################################################################################################################################################\n");

            // TESTING
            System.out.println("Coperte: " + tavolo.getCoperte().size());

            // Scopro 3 carte per iniziare il turno
            if(!inizio) {
                inizio = tavolo.scopri();
            }

            // Diamo 3 carte a ogni giocatore, 3 alla volta.
            tavolo.daiCarte();

            // TESTING
            for(Giocatore giocatore : tavolo.getGiocatori()) {
                System.out.println(giocatore);
            }

            // TESTING
            System.out.println("Scoperte: " + tavolo.getScoperte());

            // Giochiamo finchè ogni giocatore non finisce le carte in mano.
            int carteInMano = 1;
            int turno = 1;
            while(carteInMano > 0){
                // Numero del turno
                System.out.println("\nTurno: " + turno);

                // Giochiamo
                tavolo.giocata();

                // TESTING
                for(Giocatore giocatore : tavolo.getGiocatori()) {
                    System.out.println(giocatore);
                }
                System.out.println("Scoperte: " + tavolo.getScoperte());
                // Ricalcoliamo il numero di carte in mano
                carteInMano = 0;
                for(Giocatore giocatore : tavolo.getGiocatori()){
                    carteInMano += giocatore.getMano().size();
                }

                // Aumento il numero del turno
                turno++;
            }

            // Ordine di giocata fisso: g1 -> g2 -> g3 -> g4

        }

    }
}

// maiku.
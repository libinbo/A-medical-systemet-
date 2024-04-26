class Vanedannende extends Legemiddel { // denne er subklasse av Legemiddel og arver alle egenskaper superklassen har
    private int styrke; // men den har også et egen variabel som ikke superklassen har, styrke som også
                        // må være med i kontruktøren

    public Vanedannende(String navn, int pris, double virkestoff, int styrke) { // legger til alle egenskaper
                                                                                // superklassen har, og styrke
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    @Override
    public String toString() { // må override Legemiddel, slikt at stryke også er med
        String skrivutskift = super.toString();
        skrivutskift += " styrken " + styrke; // legger stryke til i i toStringen
        return skrivutskift; // returner toStringen
    }
}

class Narkotisk extends Legemiddel { // lsub av legemiddel klassen
    private int styrke; // tar inn stryke som er særegenet for Narkotisk og vannedannende

    public Narkotisk(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff); // henter egensakene i suberklassen
        this.styrke = styrke; // i tilegg til å hente stryken til narkotisk som ikke er med i Leggemidel
    }

    @Override
    public String toString() { // overrider Tostringen fra legemiddel og legger til stryke
        String skrivutskift = super.toString();
        skrivutskift += " styrken " + styrke;
        return skrivutskift;
    }
}

abstract class Resept { // en abstarct klasse som ikke kan lage et objekt
    protected Legemiddel legemiddel;// setter protected slikt at alle subklasser har instans variablene tilgjenelig
    protected Lege utskrivendeLege;
    protected Pasient pasient;
    protected int reit;
    public final int ID;
    public static int IDteller;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) { // setter inn alle
                                                                                            // egenskaper som Resept
                                                                                            // har
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
        this.ID = IDteller;
        IDteller++;
    }

    public int hentId() { // retuner Resepten Id
        return ID;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel; // returner Legemiddle
    }

    public Lege hentLege() {
        return utskrivendeLege; // retuner Legen
    }

    public Pasient hentPasientId() {
        return pasient; // returners pasientes id
    }

    public int hentReit() {
        return reit; // returner reit
    }

    public boolean bruk() { // lager denne metoden for at det ikke skal være mulig å ha negativ reit
        if (this.reit == 0) {
            return true;
        } else if (this.reit > 0) {
            this.reit -= 1;
            return false;
        }
        return false;

    }

    @Override // lager en tostring som skal kunne printe ut all informasjon om respeten
    public String toString() {
        return ("resepten sin id :" + ID + " /n Leggemiddel :" + legemiddel.toString() + "/n utskrivendelege: "
                + utskrivendeLege.toString() + "/n pasientes id :" + pasient + "/n Reit :" + reit + "\n");
    }

    abstract public String farge();// blir brukt senere for å kunne sjekke om det er blå respet eller hvit

    abstract public int prisAaBetale(); // blir også brukt senere for å kunne se hvilken pris man betaler
}
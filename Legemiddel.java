abstract class Legemiddel { // den skal ikke lage obejkter av denne klassen
    public final String navn; // navnet på legemiddle
    public int pris; // heltall for prisen
    public final int ID; // står i oppgaven at den er en final int
    public final double virkestoff; // virkestoffet er en double
    public static int IDteller; // mens tellern skal være en statict int variabbel

    public Legemiddel(String navn, int pris, double virkestoff) { // klassen legemiddel har disse egenskapene som
                                                                  // subklassene arver
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.ID = IDteller;
        IDteller++;
    }

    public int hentPris() { // henter pristen
        return pris;
    }

    public String hentNavn() {
        return navn;
    }

    public void settNyPris(int nypris) { // lager en nypris
        this.pris += nypris;
    }

    @Override
    public String toString() { // overrider slikt at vi får ut alt informasjon for alle legeminlers subklasser
        String utskrift = "Navnet på legemiddle:  " + navn +".";
        utskrift += " Prisen på legemiddel :" + pris + ".";
        utskrift += " virkestoffet : " + virkestoff + ".";
        return utskrift;
    
    }
}

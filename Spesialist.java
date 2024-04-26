class Spesialist extends Lege implements Godkjenningsfritak { // Spes er en subklasse av Lege og den implemntner
                                                                     // interface
    private String kontrollId; // Legger til kontollId

    public Spesialist(String navn, String kontrollId) { // den har navn fra Lege og KontrollId som er særegent for Spes
                                                        // klassen
        super(navn);
        this.kontrollId = kontrollId;
    }

    public String hentKontrollkode() { // overrider fra Godkjenningsfritak Med samme metodenavn slikt at man får brukt
                                       // interface
        return kontrollId; // returner Spes Legen Kontrollid
    }

    @Override
    public String toString() { // overrider fra Lege klassen
        String utskrift = super.toString();
        utskrift += " kontrollId " + kontrollId; // legger til Kontollid
        return utskrift; // returner hele Tostringen
    }
    @Override // 
    public Resept SkrivBlaaRespept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        BlaaResept blaa= new BlaaResept(legemiddel,this, pasient,reit);
        listeresept.leggTil(blaa);
        return blaa;
    }
}

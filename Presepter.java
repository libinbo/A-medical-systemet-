class Presepter extends HvitResept {// presepter er en subklasse av Hvitrespet som igjen er en sub av resepter
    public Presepter(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) { // arver alle egensakper
                                                                                             // fra hvit respet
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public int prisAaBetale() { // denne metoden har som funskjun å kunen lage en rabatt, man får 108 kronner i
                                // rabbet hvis man kjøper P resepter
        int rabatt = 108;
        int prisFørRabatt = legemiddel.hentPris();// henter prisen til Presept
        if (prisFørRabatt > rabatt) { // skal kunne ungå negative verdier
            return prisFørRabatt - rabatt;
        } else {
            return 0; // hvis ikke returnes det 0
        }
    }
}

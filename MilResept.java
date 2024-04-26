class MilResept extends HvitResept { // Milresp er en sub av Hvit resep
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, 3); // setter reiten til å være 3
    }
}
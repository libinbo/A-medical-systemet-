class HvitResept extends Resept { // er en subklasse av respet
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit); // arver alle egenskaper fra respet
    }

    @Override
    public String farge() { // overrider fargen
        return "hvit"; // slikt at den returner hvit
    }

    @Override
    public int prisAaBetale() {
        return 0; // setter prisen til å være null, slikt at Mil repset skal kunne få 100% rabbat
    }
}
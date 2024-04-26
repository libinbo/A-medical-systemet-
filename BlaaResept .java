class BlaaResept extends Resept { // er en sub klasse av respet
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit); // arver alle egenskaper til resept

    }

    @Override
    public String farge() {
        return "blaa"; // overrider slikt at fargen blir blaa
    }

    @Override
    public int prisAaBetale() { // leger alle blå resept legemiddel skal gi 75 prosnet rabbat
        int prisførrabbat = legemiddel.hentPris();
        int rabbatpris = (int) Math.round(prisførrabbat * 0.25);
        return rabbatpris; // returner en egenandel på 25%
    }
}

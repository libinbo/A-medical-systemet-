class Vanlig extends Legemiddel { // denne er en sub av Legemiddel
    public Vanlig(String navn, int pris, double virkestoff) {
        super(navn, pris, virkestoff); // og den arver alle egenskaper fra Legemiddel klassen
    }
}
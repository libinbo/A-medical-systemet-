class Stabel<E> extends Lenkeliste<E> {

    @Override
    public void leggTil(E x) { // metode for å legge til 
        Node nynode = new Node(x);
        if (start == null) { // hvis starten er null er den nynode start og slutten 
            start = nynode;
            slutt = nynode;
        } else {
            nynode.neste = start; // hvis ikke har den noden er start 
            start.forrige = nynode; // den forrige er nynode 
            start = nynode;
        }
    }
}

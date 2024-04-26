import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.crypto.Data;

abstract class Lenkeliste<E> implements Liste<E> {
    protected Node start = null; // lager en start og slutt node 
    protected Node slutt = null;

    protected class Node {
        E data; 
        Node neste = null; // er den første så ingen neste eller forrige 
        Node forrige = null;

        public Node(E data) {
            this.data = data;
        }
    }

    protected class LenkelisteIterator implements Iterator<E> {
        Node peker = start; // peker blir starten vår 

        @Override
        public boolean hasNext() {
            return (peker.neste != null); // hvis den har none neste 
        }

        @Override
        public E next() {
            if (peker.neste == null) throw new NoSuchElementException("next");
            E data = peker.neste.data; 
            peker= peker.neste; // pekern får en neste  som er pekerns neste 
            return data; // return den 

        }

    }

    public Iterator<E> iterator() {
        return new LenkelisteIterator();
    }

    public int stoerrelse() { // metode for å få støttrelsen 
        int teller = 0; // starter med null som teller 
        Node peker = start; // pekern er starten 
        while (peker != null) { // hvis den ikke er tom 
            teller++; // øker telern 
            peker = peker.neste; // dermed blir peker, pekers neste 
        }
        return teller;
    }

    public void leggTil(E x) {
        Node nynode = new Node(x); // nynode 
        if (start == null) { // den har ingen start 
            start = nynode;
            slutt = nynode; // elger ingen slutt 
        } else {
            Node peker = start; // hvsi den har en start 
            while (peker.neste != null) { // har den også en nest e
                peker = peker.neste; // demred bir peker, den sin netse 
            }
            peker.neste = nynode;// pejer. neste er den nyenoden 
            nynode.forrige = peker; // den forrige er pejer 
            nynode.neste = null; // og den har ingen neste siden den er den som ble lagt til sist 
        }
    }

    public E hent() throws UgyldigListeindeks { // kaster uglygde eroor hvsi vi ikka her en start 
        if (start == null) { 
            throw new UgyldigListeindeks(0);
        }
        return start.data;
    }

    public E fjern() throws UgyldigListeindeks {
        if (start == null) { // ikke fjerne hvis det er kun en node 
            throw new UgyldigListeindeks(0);
        }

        E data = start.data;
        start = start.neste;
        return data;
    }

    @Override
    public String toString() { // skriver ut all informasjjon 
        String informasjon = "";
        Node peker = start;
        while (peker != null) {
            informasjon += peker;
            peker = peker.neste;
        }
        return (informasjon);
    }
}

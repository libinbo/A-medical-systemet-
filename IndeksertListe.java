class IndeksertListe<E> extends Lenkeliste<E> {
    public void leggTil(int pos, E x) throws UgyldigListeindeks {
        Node nynode = new Node(x);
        if (pos == 0) {
            nynode.neste = start;
            nynode.forrige = null;
            start = nynode;

        } else if (pos == stoerrelse()) {
            leggTil(x);

        } else if (stoerrelse() < pos || pos < 0) {
            throw new UgyldigListeindeks(pos);
        } else if (start == null) {
            start = nynode;

        } else {
            Node peker = start;
            for (int i = 0; i < pos - 1; i++) {
                peker = peker.neste;
            }
            nynode.forrige = peker;
            nynode.neste = peker.neste;
            peker.neste = nynode;
        }

    }

    public void sett(int pos, E x) throws UgyldigListeindeks {
        Node peker = start;
        if (pos == 0) {
            start.data = x;
        } else if (start == null) {
            leggTil(x);
        } else if (pos >= stoerrelse() || pos < 0) {
            ;
            throw new UgyldigListeindeks(pos);
        } else if (pos > 0 && pos < stoerrelse()) {
            for (int i = 0; i < pos; i++) {
                peker = peker.neste;
            }
            peker.data = x;

        }

    }

    public E hent(int pos) throws UgyldigListeindeks {
        Node peker = start;
        if (pos < 0 || pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        } else if (start == null) {
            throw new UgyldigListeindeks(0);
        }
        for (int i = 0; i < pos; i++)
            peker = peker.neste;
        return peker.data;
    }

    public E fjern(int pos) {
        Node kaste = null;
        Node peker = start;
        if (pos < 0 || pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        } else if (start == null) {
            throw new UgyldigListeindeks(pos);
        } else if (pos == 0) {
            kaste = peker;
            peker.neste.forrige = null;
            start = peker.neste;
            peker.neste = null;
        }

        for (int i = 0; i < pos; i++) {
            peker = peker.neste;

        }
        kaste = peker;

        if (peker.neste == null) {
            peker.forrige.neste = null;
            peker.forrige = slutt;
            peker.forrige = null;
        }

        else {

            peker.neste.forrige = peker.forrige;
            peker.forrige.neste = peker.neste;
            peker.forrige = null;
            peker.neste = null;
        }

        return kaste.data;
    }

}

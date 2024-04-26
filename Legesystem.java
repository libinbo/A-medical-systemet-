import java.util.Scanner;

import javax.swing.text.NavigationFilter;

import java.io.File;
import java.io.FileNotFoundException;

class Legesystem { // bruker indeksert liste for å holde på objektene
    static IndeksertListe<Lege> sortListelege = new IndeksertListe<Lege>();
    static IndeksertListe<Pasient> pasientliste = new IndeksertListe<Pasient>();
    static IndeksertListe<Resept> reseptliste = new IndeksertListe<Resept>();
    static IndeksertListe<Legemiddel> legemiddelliste = new IndeksertListe<Legemiddel>();
    static IndeksertListe<Lege> Legeliste = new IndeksertListe<Lege>();

    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        System.out.print("skriv inn filen du vil skal leses: "); // skriver riktig fil
        String filnavn = tastatur.nextLine();

        leseFil(filnavn);

        int valg = 0; // brukes for komdoøkonne
        Scanner bruker = new Scanner(System.in);
        System.out.println(" "); // komandoløkken ne mine
        System.out.println("trykk 1 for kunne skriv ut fulloversikft: ");
        System.out.println("trykk 2 for å legge til nye elementer i systmet: ");
        System.out.println("trykk 3 for å kunne bruke en respet fra listen til en pasinet: ");
        System.out.println("trykk 4 for å skrive alle statestik : ");
        System.out.println("trykk 5 for å kunne skive alle data til fil: ");
        valg = Integer.parseInt(bruker.nextLine());

        if (valg == 1) {
            skriveUtalt(); // kaler på metoden skriv ut alt som skriver ut den fulle overskift

        }

        else if (valg == 2) {
            leggtil(); // kaller på valg to som skal la brukern lege til objetketer
        }

    }

    public static void skriveUtalt() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("valg1: fulloversikt:");
        System.out.println(" ");
        System.out.println(" ");

        // skrive ut pasineten fra paisnetlista

        for (int i = 0; i < pasientliste.stoerrelse(); i++) { // skrice

            System.out.println(pasientliste.hent(i));
        }
        System.out.println(" ");
        System.out.println(" ");

        // skrive ut legemiddel fra legemiddel lista
        for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

            System.out.println(legemiddelliste.hent(i));
        }
        System.out.println(" ");
        System.out.println(" ");

        // skrive ut resept fra respt lista
        for (int i = 0; i < reseptliste.stoerrelse(); i++) {

            System.out.println(reseptliste.hent(i));
        }
        System.out.println(" ");
        System.out.println(" ");

        // skrive ut leger
        for (int a = 0; a < Legeliste.stoerrelse(); a++) {
            boolean legenavn = false;

            // skal kunne føre til at leger blir sortet riktig
            for (int i = 0; i < sortListelege.stoerrelse(); i++) {
                if (Legeliste.hent(a).hentNavn().toLowerCase()
                        .compareTo(sortListelege.hent(i).hentNavn().toLowerCase()) == 0) {
                    legenavn = true;
                    break;
                }
            }
            if (legenavn == false) {
                int i = 0;
                while (i < sortListelege.stoerrelse() && Legeliste.hent(a).hentNavn().toLowerCase()
                        .compareTo(sortListelege.hent(i).hentNavn().toLowerCase()) > 0) {
                    i++;
                }
                sortListelege.leggTil(i, Legeliste.hent(a));

            }

        }
        // skal hente spesialistene

        for (int i = 0; i < sortListelege.stoerrelse(); i++) {
            if (sortListelege.hent(i) instanceof Spesialist) {
                System.out.println(sortListelege.hent(i));
            }

            else {
                System.out.println(sortListelege.hent(i));
            }
        }

    }

    // legge til metoden som legger til objekter
    public static void leggtil() {
        // gir brukere ulike valgmuligheter
        Scanner bruker = new Scanner(System.in);
        System.out.println(
                "Her er valgene du har, vil du Legge til en pasient trykk 1 , legemiddel trykk 2,  , eller en lege trykk 3, eller Legge til en respet trykk 4 ");
        int valg = 0;
        valg = Integer.parseInt(bruker.nextLine());
        // pasinet
        // lager pasinet obejketert
        if (valg == 1) {
            Scanner input = new Scanner(System.in);
            System.out.println("Skriv inn navnet til pasinet du vil skal legges til: ");
            String navn = input.nextLine();

            Scanner input2 = new Scanner(System.in);
            System.out.println("Skriv inn fodselsnr til pasinet: ");
            String fodselsnr = input2.nextLine();

            Pasient nyPasient = new Pasient(navn, fodselsnr);
            pasientliste.leggTil(nyPasient); // legger til pasientet til pasientlista

        }
        // lege objketet lages her
        if (valg == 3) {
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            System.out.println(" Valg:Legg til lege/ spes"); // skal kunne lage enten en lege objeket eller et spesalist
                                                             // objekt
            System.out.println("skriv navnet til legen");
            System.out.println("er dette en spes/ eller en Lege?: Trykk 1 for Lege, Trykk 2 for spes");
            String Legenavn = input.nextLine();
            int profesjon = input.nextInt();
            if (profesjon == 1) { // hvis det er en lages det en lege
                Lege nylLege = new Lege(Legenavn);
                Legeliste.leggTil(nylLege);
            } else if (profesjon == 2) { // hvis det er 2 lages det en spesialist med kontoll id
                System.out.println("skriv inn en kontroll id i str format");
                Scanner input3 = new Scanner(System.in);
                String KID = input3.nextLine();
                Spesialist spes1 = new Spesialist(Legenavn, KID);
                Legeliste.leggTil(spes1);
            }

        }
        // legemiddler
        // lager legemiddler her
        if (valg == 2) {
            Scanner input = new Scanner(System.in);
            System.out.println(" Valg:Legge til legemiddel");
            System.out.println("skriv inn Legemiddelnavn");
            String navn = input.nextLine();
            System.out.println("skriv inn en pris ");
            int pris = input.nextInt();
            System.out.println("skriv inn virkestoff som en double");
            double virkestoff = input.nextDouble();
            System.out.println("skriv inn en type for legemiddle");
            String type = input.nextLine();
            // skal kunne skille mellom de ulike legemidnle ved if else if løkker
            if (type == "vanlig") {
                Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
                legemiddelliste.leggTil(vanlig); // legger vanlig til leggemidellista
            } else if (type == "Vanedannende") {
                System.out.println("skriv inn en styrke i int format");
                Scanner input5 = new Scanner(System.in);
                int styrke = input5.nextInt();
                Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
                legemiddelliste.leggTil(vanedannende); // vannedannes legges til legemidelista
            } else if (type == "Narkotisk") {
                System.out.println("skriv inn en styrke i int format");
                Scanner input6 = new Scanner(System.in);
                int styrke = input6.nextInt();
                Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
                legemiddelliste.leggTil(narkotisk);
            }

        }

        if (valg == 4) { // lage respeter

            Scanner input = new Scanner(System.in);
            System.out.println(" Valg:Legge til legemiddel");
            System.out.println("skriv inn Legemiddelnavn");
            String navn = input.nextLine();
            System.out.println("skriv inn en pris ");
            int pris = input.nextInt();
            System.out.println("skriv inn virkestoff som en double");
            double virkestoff = input.nextDouble();
            System.out.println("skriv inn en type for legemiddle");
            String type = input.nextLine();

            if (type == "vanlig") {
                Vanlig vanlig = new Vanlig(navn, pris, virkestoff);
                legemiddelliste.leggTil(vanlig);
            } else if (type == "Vanedannende") {
                System.out.println("skriv inn en styrke i int format");
                Scanner input5 = new Scanner(System.in);
                int styrke = input5.nextInt();
                Vanedannende vanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
                legemiddelliste.leggTil(vanedannende);
            } else if (type == "Narkotisk") {
                System.out.println("skriv inn en styrke i int format");
                Scanner input6 = new Scanner(System.in);
                int styrke = input6.nextInt();
                Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
                legemiddelliste.leggTil(narkotisk);
            }

            Scanner input8 = new Scanner(System.in);

            System.out.println("nå skal vi lage respeten");
            System.out.println("skriv inn respet, er den hvit, p, militaer, blaa");
            String respettype = input.nextLine();
            System.out
                    .println("skriv inn hvilken type Legemiddel det er, er det narkotisk, vanlig eller vannedannende");
            String legemiddelstype = input.nextLine();
            System.out.println("skriv inn et Legemiddel");
            String legemiddel = input.nextLine();
            System.out.println("skriv reiten for respten ");
            int reit = input.nextInt();
            System.out.println("Skriv inn en lege som skal skrive ut respeten, det er legen oppgit i filen");
            String legenavn = input.nextLine();

            System.out.println("skriv inn  navn på pasient som skal få respeten");
            String pasient = input.nextLine();

            System.out.println("skriv in fødselsnummer for pasient");
            String fdr = input.nextLine();

            Pasient nyPasient = new Pasient(pasient, fdr);
            pasientliste.leggTil(nyPasient);
            if (legemiddelstype.equals("vannedanned")) {
                Vanedannende bvanne = new Vanedannende(legenavn, pris, virkestoff, reit);

                if (respettype.equals("hvit")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept resp= Legeliste.SkrivHvitResept(bvanne,nyPasient,reit);
                            // Metoden SkrivHvitrespet lar meg ikke lage nye respter

                        }

                    }

                } else if (respettype.equals("blaa")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept vResept= Legeliste.SkrivBlaaRespept(bvanne,nyPasient,reit);
                            // Metoden Skrivblaarespet lar meg ikke lage nye respter

                        }

                    }

                } else if (respettype.equals(" militaer")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept mResept= Legeliste.SkrivmilResept(bvanne,nyPasient,reit);
                            // Metoden SkrivmilResept lar meg ikke lage nye respter

                        }

                    }

                } else if (respettype.equals(" p")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept pResept= Legeliste.skrivpResept(bvanne,nyPasient,reit);
                            // Metoden lar meg ikke lage nye respter

                        }

                    }

                }

            } else if (legemiddelstype.equals("vanlig")) {
                Vanlig vanglig = new Vanlig(legenavn, pris, reit);

                if (respettype.equals("blaa")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept rv= Legeliste.SkrivBlaarespet(vanglig,nyPasient,reit);
                            // Metoden lar meg ikke lage nye respter

                        }

                    }

                } else if (respettype.equals("hvit")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept vanResept =Legeliste.SkrivHvitResept(vanglig,nyPasient,reit);
                            // Metoden lar meg ikke lage nye respter

                        }

                    }

                } else if (respettype.equals("milater")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept mvResept =Legeliste.SkrivmilResept(vanglig,nyPasient,reit);
                            // Metoden lar meg ikke lage nye respter

                        }

                    }

                } else if (respettype.equals("p")) {
                    for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                        if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                            // Resept n2= Legeliste.skrivpResept(vanglig,nyPasient,reit);
                            // Metoden lar meg ikke lage nye respter

                        }

                    }

                }

            } else if (legemiddelstype.equals("narkotisk")) {
                Narkotisk narkotisk = new Narkotisk(legenavn, pris, virkestoff, reit);

            }
            if (respettype.equals("blaa")) {
                for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                    if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                        // Resept n1= Legeliste.SkrivBlaarespet(n1,nyPasient,reit);
                        // Metoden lar meg ikke lage nye respter

                    }

                }

            } else if (respettype.equals("hvit")) {
                for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                    if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                        // Resept n2 =Legeliste.SkrivHvitResept(n2,nyPasient,reit);
                        // Metoden lar meg ikke lage nye respter

                    }

                }

            } else if (respettype.equals("milater")) {
                for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                    if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                        // Resept mnrResept =Legeliste.SkrivmilResept(narkotisk,nyPasient,reit);
                        // Metoden lar meg ikke lage nye respter

                    }

                }

            } else if (respettype.equals("p")) {
                for (int i = 0; i < legemiddelliste.stoerrelse(); i++) {

                    if (legenavn.equals(Legeliste.hent(i).hentNavn())) {

                        // Resept Pr Legeliste.skrivpResept(vanglig,nyPasient,reit);
                        // Metoden lar meg ikke lage nye respter

                    }

                }

            }

        }
    }

    public static void leseFil(String filnavn) throws ArrayIndexOutOfBoundsException { // skal kunne forhindre Array
                                                                                       // index out of bound feil
                                                                                       // meldinger
        int teller = 0; // skal gjøre fil lesningen enklere

        Scanner fil = null;

        try {
            fil = new Scanner(new File(filnavn)); // ha en try catch for å kunne fange filen

        } catch (FileNotFoundException e) {
            System.out.println("finner ikke filen");
            System.exit(-1);
        }

        while (fil.hasNextLine()) { // løkke som leser av filen
            String linje = fil.nextLine();
            if (linje.charAt(0) == '#') { // så lenge linjen har en hasttag økes den pg v går til neste linje
                teller++;
            } else if (teller == 1) {
                //System.out.println("pasienter"); // lager pasineter
                String[] biter = linje.split(",");
                String navn = biter[0];
                String fdr = biter[1];
                // lager et pasient objekt
                Pasient pas1 = new Pasient(navn, fdr);
                pasientliste.leggTil(pas1);

            } else if (teller == 2) {
                // lager legemiidler ved å lese av filen
                String[] biter = linje.split(",");
                String navn = biter[0];
                String type = biter[1];
                int pris = Integer.parseInt(biter[2].trim());
                double virkestoff = Double.parseDouble(biter[3].trim());
                // lager narkotisk legemiderl

                if (type.equals("narkotisk")) {
                    int stryke = Integer.parseInt(biter[4].trim());
                    Narkotisk narkotisk1 = new Narkotisk(navn, pris, virkestoff, stryke);
                    legemiddelliste.leggTil(narkotisk1);
                    // vanne dannedne

                } else if (type.equals("vanedannende")) {
                    int stryke = Integer.parseInt(biter[4].trim());
                    Vanedannende vanedannende1 = new Vanedannende(navn, pris, virkestoff, stryke);
                    legemiddelliste.leggTil(vanedannende1);
                } else if (type.equals("vanlig")) {
                    Vanlig vanlig1 = new Vanlig(navn, pris, virkestoff);
                    legemiddelliste.leggTil(vanlig1);

                }
                // leser av lege fra filen og lager en objeket

            } else if (teller == 3) {
                String[] biter = linje.split(",");
                String navn = biter[0];
                String kontrollid = biter[1];
                // veldig viktig å se o legen har 0, 1 som kontroll ide for å lage de to ulike
                // lege objekten
                if (kontrollid.equals("0")) {
                    Lege lege1 = new Lege(navn);
                    Legeliste.leggTil(lege1);
                } else {
                    Spesialist Spes1 = new Spesialist(navn, kontrollid);
                    Legeliste.leggTil(Spes1);
                }

            } else if (teller == 4) { // respetne

                String[] biter = linje.split(",");
                int legemiddelNummer = Integer.parseInt(biter[0]);
                String legenavn = biter[1];
                int pasientID = Integer.parseInt(biter[2]);

                String type = biter[3];

                Legemiddel legemiddel = legemiddelliste.hent(legemiddelNummer);
                Pasient pas = pasientliste.hent(pasientID);

                // System.out.println(type);

                for (int i = 0; i < Legeliste.stoerrelse(); i++) {
                    System.out.println(Legeliste.hent(i).hentNavn());

                    // sjkker om legen skal lage utskrift hvis ikke får man ulovlig utskrift
                    if (Legeliste.hent(i).hentNavn().equals(legenavn)) {
                        try {
                            // hvis typen er hvis
                            if (type.equals("hvit")) {

                                int reit = Integer.parseInt(biter[4]);
                                Resept resept = Legeliste.hent(i).SkrivHvitResept(legemiddel, pas, reit);
                                reseptliste.leggTil(resept);
                                pas.Leggtil(resept);
                                // lgges til resp listen

                            }
                            if (type.equals("blaa")) {
                                // hvis den er blaa, legges til resptlisten

                                int reit = Integer.parseInt(biter[4]); // har en reit
                                Resept resept = Legeliste.hent(i).SkrivBlaaRespept(legemiddel, pas, reit);
                                reseptliste.leggTil(resept);
                                pas.Leggtil(resept);

                            }
                            // sjekker om den er p
                            else if (type.equals("p")) {
                                int reit = Integer.parseInt(biter[4]); // fprdi den har en reit
                                Resept resept = Legeliste.hent(i).skrivpResept(legemiddel, pas, reit);
                                reseptliste.leggTil(resept);
                                pas.Leggtil(resept);

                            } else if (type.equals("militaer")) {
                                Resept resept = Legeliste.hent(i).SkrivmilResept(legemiddel, pas, 3); // reiten skal
                                                                                                      // alltid være 3
                                reseptliste.leggTil(resept);
                                pas.Leggtil(resept);

                            } else { // ingen type
                                System.out.println("har ingen type");

                            }
                            // catchene mine

                        } catch (UlovligUtskrift u) {
                            System.out.println("Ulovlig utskrift");
                        } catch (UgyldigListeindeks u) {
                            System.out.println("Ugyldig indeks");
                        }
                    }

                }

            } else if (teller > 4) {
                System.out.println("kunne ikke lese av filen riktig " + filnavn);
                System.exit(-1);
            }
        }
        while (!(fil.hasNextLine())) {
            System.out.println("SLUTT");
            break;

        }
    }
}

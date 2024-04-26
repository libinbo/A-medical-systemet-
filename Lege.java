class Lege extends IndeksertListe<Resept> implements Comparable<Lege> { // lager klassen lege
    protected String navn; // den tar inn et string navn
    public IndeksertListe<Resept> listeresept = new IndeksertListe<>(); //

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {
        return navn; // returner navnet
    }

    @Override
    public String toString() {
        return " Navn på Legen " + navn; // overrider slikt at vi får ut informasjon om legen
    }

    @Override
    public int compareTo(Lege nylege) {
        return this.navn.compareTo(nylege.hentNavn());
    }
    
    // Usikker om jeg SKal ha Respet eller ikke
    public Resept SkrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        HvitResept Hr = new HvitResept (legemiddel, this, pasient, reit);
           if( legemiddel instanceof Narkotisk ){
               throw new UlovligUtskrift(this,legemiddel);
           }
           
           else {
               listeresept.leggTil(Hr);
           }
           

       return Hr;
   }// det er viktig at blaarepset klassen er åpen samtidig hvis ikke blir det en error.
   public Resept SkrivBlaaRespept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
       BlaaResept blaa= new BlaaResept(legemiddel,this, pasient,reit);
       if( legemiddel instanceof Narkotisk ){
           throw new UlovligUtskrift(this,legemiddel);
       }
       
       else {
           listeresept.leggTil(blaa);
       }
       
       
       return blaa;
   }
   // metode for å skrive de ulike reseptene 
   public Resept SkrivmilResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
       MilResept mila= new MilResept(legemiddel, this, pasient,reit);
       if( legemiddel instanceof Narkotisk ){
           throw new UlovligUtskrift(this,legemiddel);
       }
       
       else {
           listeresept.leggTil(mila);
       }
       
       return mila;
       
   }
   public Resept skrivpResept(Legemiddel legemiddel,Pasient pasient,int reit) throws UlovligUtskrift{
       Presepter presp= new Presepter(legemiddel, this, pasient, reit);
       if( legemiddel instanceof Narkotisk ){
           throw new UlovligUtskrift(this,legemiddel);
       }
       
       else {
           listeresept.leggTil(presp);
       }
       
       return presp;
   }


}

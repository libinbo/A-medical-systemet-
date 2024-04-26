class Pasient { // lager klassen pasinet 
    protected Koe<Resept> listeresept = new Koe<>(); // som tar en liste objket 
    protected String navn; // tar et navn 
    protected String foodselesnr; // fdr nummer 
    protected Pasient pasient; // pasinet 
    public int ID; // id 
    public static int IDteller;

    public Pasient(String navn, String foodselesnr) {
        this.navn = navn; 
        this.foodselesnr = foodselesnr;
        this.ID = IDteller++;

    }
    
    public void Leggtil(Resept x) {
        listeresept.leggTil(x); // legger til i listretsnet 
    }
    @Override // skriver ut alt infromasjon
    public String toString(){
        String utskrift= "navnet til pasinetet: " + navn + ".";
        utskrift += " Fodselsnr:" + foodselesnr;
        return utskrift;
    }


}

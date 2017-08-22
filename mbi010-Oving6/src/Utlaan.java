/**
 * Created by Mikkel on 16.11.2016.
 */
public class Utlaan {
    private Bok bok;
    private String laanersNavn;

    public Utlaan(Bok bok, String laanersNavn){
        this.bok = bok;
        this.laanersNavn = laanersNavn;
    }

    public Bok hentBok(){
        return bok;
    }
    public String hentLaanersNavn(){
        return laanersNavn;
    }
    public String toString(){
        return "Utlaan[utlaantBok=" + bok + "laanersNavn=" + laanersNavn + "]";
    }
}

/**
 * Created by Mikkel on 16.11.2016.
 */
public class Bok implements Comparable<Bok>{
    private String ISBN;
    private String forfatter;
    private String tittel;
    private int antallEksemplarer;
    private int antallUtlaant;

    public Bok(String ISBN, String forfatter, String tittel, int antallEksemplarer) {
        this.ISBN = ISBN;
        this.forfatter = forfatter;
        this.tittel = tittel;
        settAntallEksemplarer(antallEksemplarer);
        antallUtlaant = 0;

    }
    //Metode som brukes for aa sortere listen over boeker
    //Denne metoden sammenligner 2 strenger, og gir tall 1,0 eller -1 alt ettersom hvilken av strengene som skal foerst
    public int compareTo(Bok annen){
        if (hentForfatter().compareTo(annen.hentForfatter()) > 0){
            return 1;
        }
        else if (hentForfatter().compareTo(annen.hentForfatter()) < 0){
            return -1;
        }
        else if (hentTittel().compareTo(annen.hentTittel()) > 0){
            return 1;
        }
        else if (hentTittel().compareTo(annen.hentTittel()) < 0){
            return -1;
        }
        else if (hentISBN().compareTo(annen.hentISBN()) > 0){
            return 1;
        }
        else if (hentISBN().compareTo(annen.hentISBN()) < 0){
            return -1;
        }
        else
            return 0;
    }
    //Metode som lager en lang streng over alle verdiene
    public String toString(){
        return "Bok[ISBN=" + this.ISBN + ",forfatterNavn=" + this.forfatter + ", bokTittel=" + this.tittel +
                ", antallEksemplarer=" + this.antallEksemplarer + ", antall utlaant=" + this.antallUtlaant + "]";
    }

    //Metoder som henter ut info om variabler
    public String hentISBN() {
        return ISBN;
    }

    public String hentForfatter() {
        return forfatter;
    }

    public String hentTittel() {
        return tittel;
    }

    public int hentAntallEksemplarer() {
        return antallEksemplarer;
    }
    public int hentAntallUtlaant(){
        return antallUtlaant;
    }

    public void settAntallUtlaan(int antallUtlaant){
        this.antallUtlaant = antallUtlaant;
    }

    //Metode som passer paa at antall eksemplarer ikke settes som mindre enn 1
    public void settAntallEksemplarer(int antallEksemplarer) {
        if (antallEksemplarer <= 0) {
            IllegalArgumentException unntak
                    = new IllegalArgumentException("Antall eksemplarer kan ikke vaere mindre enn 1.");
            throw unntak;
        }
        this.antallEksemplarer = antallEksemplarer;
    }
}

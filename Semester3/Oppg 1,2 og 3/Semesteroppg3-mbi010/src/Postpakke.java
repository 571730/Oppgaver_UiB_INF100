/**
 * Created by Mikkel on 09.11.2016.
 */
public class Postpakke {
    private String navn;
    private String adresse;
    private int postNummer;
    private double vekt;

    //Konstruktoer som tar i mot info og lagrer den under riktig variabel
    public Postpakke(String navn, String adresse, int postNummer, double vekt) {
        this.navn = navn;
        this.adresse = adresse;
        this.postNummer = postNummer;
        this.vekt = vekt;
    }
    //Metoder som henter ut info under variabler
    public String hentNavn() {
        return navn;
    }

    public String hentAdresse() {
        return adresse;
    }
    public int hentPostNummer(){
        return postNummer;
    }
    public double hentVekt(){
        return vekt;
    }
}

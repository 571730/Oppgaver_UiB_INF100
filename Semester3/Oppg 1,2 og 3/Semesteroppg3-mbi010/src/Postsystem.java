import java.util.Scanner;

/**
 * Created by Mikkel on 09.11.2016.
 */
public class Postsystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hvor mange postpakker skal registreres?");
        int antallPakker = sc.nextInt();

        //Deklarere variabler
        String motNavn;
        String motAdresse;
        int motPostNummer;
        double motVekt;

        //Liste brukt for aa hente ut riktig info om pakker
        Postpakke[] pakker = new Postpakke[antallPakker];

        //Loekke som henter inn info om pakkene og sender dem til Postpakke klassen for lagring
        for (int i = 0; i < antallPakker; i++) {
            System.out.println("Pakke " + (i + 1));
            System.out.println("Oppgi mottakers navn:");
            sc.nextLine();
            motNavn = sc.nextLine();
            System.out.println("Oppgi mottakers adresse:");
            motAdresse = sc.nextLine();
            System.out.println("Oppgi mottakers postnummer:");
            motPostNummer = sc.nextInt();
            System.out.println("Oppgi pakkens vekt:");
            motVekt = sc.nextDouble();

            Postpakke pakke = new Postpakke(motNavn, motAdresse, motPostNummer, motVekt);
            pakker[i] = pakke;
        }

        System.out.println("Pakker:");
        //Printer ut alle registrerte pakker og info om dem
        for (int i = 0; i < antallPakker; i++) {
            System.out.println("Pakke " + (i + 1));
            System.out.println("Mottakers navn: " + pakker[i].hentNavn());
            System.out.println("Mottakers adresse: " + pakker[i].hentAdresse());
            System.out.println("Mottakers postnummer: " + pakker[i].hentPostNummer());
            System.out.println("Pakkens vekt: " + pakker[i].hentVekt() + "kg");
        }
    }
}

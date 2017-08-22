import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Mikkel on 16.11.2016.
 */
public class Bibliotek {
    public static void main(String[] args){
        boolean avslutt = false;
        Scanner sc = new Scanner(System.in);
        //Liste over boeker som er regisrert, og liste over utlaan
        ArrayList<Bok> boeker = new ArrayList<>();
        ArrayList<Utlaan> utlaante = new ArrayList<>();

        //Loop som holder programmet gaaende til brukeren stopper det
        while (!avslutt){
            System.out.println(" ");
            System.out.println("-------------------");
            System.out.println("Velkommen til biblioteket.");
            System.out.println("-------------------");
            System.out.println(" ");
            System.out.println("Skriv 0 for aa avslutte.");
            System.out.println("Skriv 1 for aa registrere en bok.");
            System.out.println("Skriv 2 for aa fjerne en bok.");
            System.out.println("Skriv 3 for aa skrive ut liste av boeker.");
            System.out.println("Skriv 4 for aa registrere utlaan.");
            System.out.println("Skriv 5 for aa skrive ut liste av utlaan.");
            System.out.println(" ");

            String brukerValg = sc.nextLine();

            //Switch som kjoeres ut i fra brukerens valg
            switch (brukerValg){
                //Avslutter programmet
                case "0": avslutt = true;
                    System.out.println("Avslutter programmet.");
                    break;
                //Regisrerer boeker
                case "1":
                    String bokBrukt = "";
                    System.out.println("Skriv ISBN:");
                    //sc.nextLine();
                    String innISBN = sc.nextLine();
                    //Bruker for aa iterer over alle boeker i listen
                    Iterator<Bok> listeBoeker = boeker.iterator();

                    //Sjekker om ISBN er brukt av en annen bok
                    while (listeBoeker.hasNext()){
                        Bok tempBok = listeBoeker.next();

                        if (tempBok.hentISBN().equals(innISBN)){
                            System.out.println("Dette ISBN er allerede brukt av en annen bok.");
                            bokBrukt = "Brukt";
                            break;

                        }
                    }
                    if (bokBrukt.equals("Brukt")){
                        break;
                    }

                    System.out.println("Skriv forfatterens navn:");
                    String innForfatter = sc.nextLine();
                    System.out.println("Skriv bokens tittel:");
                    String innTittel = sc.nextLine();
                    System.out.println("Skriv antall eksemplarer (heltall stoerre enn 0):");
                    int innEksemplarer = sc.nextInt();

                    //Legger til bok med brukeren gitte verdier
                    Bok bok = new Bok(innISBN, innForfatter, innTittel, innEksemplarer);
                    boeker.add(bok);

                    System.out.println("Boken ble registrert: " + bok.toString());

                    break;
                //Sletter boeker fra listen
                case "2":
                    System.out.println("Skriv ISBN:");
                    String fjerneBok = sc.nextLine();
                    boolean fantBok = false;

                    Iterator<Bok> alleBoeker = boeker.iterator();
                    //Finner boken bruker oensker slette
                    while (alleBoeker.hasNext()){
                        Bok tempBok = alleBoeker.next();

                        //Sletter bok om den ble funnet
                        if (tempBok.hentISBN().equals(fjerneBok)){
                            System.out.println("Fjerner bok: " + tempBok.toString());
                            alleBoeker.remove();
                            fantBok = true;

                        }
                    }
                    if (!fantBok){
                        System.out.println("Finner ikke boken du oensker aa fjerne.");
                    }

                    break;
                //Printer ut liste over alle boeker, sortert alfabetisk
                case "3":
                    Collections.sort(boeker);
                    System.out.println("Liste over registrerte boeker:");
                    //Gaar gjennom alle elementer i ArrayListen og printer ut info om boekene
                    for (Bok element : boeker)
                        System.out.println(element.toString());

                    break;
                //Registrerer utlaan av bok
                case "4":
                    System.out.println("Skriv ISBN:");
                    String utlaanBokISBN = sc.nextLine();
                    System.out.println("Skriv laaners navn:");
                    String laanersNavn = sc.nextLine();

                    boolean fantBokUtlaan = false;

                    Iterator<Bok> alleBoekerUtlaan = boeker.iterator();

                    //Loekke som brukes til aa lete etter boken som skal leies ut
                    while (alleBoekerUtlaan.hasNext()){
                        Bok tempBok = alleBoekerUtlaan.next();

                        //Leier ut boken om den ble funnet og det er flere eksemplarer igjen
                        if (tempBok.hentISBN().equals(utlaanBokISBN)){
                            if (tempBok.hentAntallUtlaant() < tempBok.hentAntallEksemplarer()){
                                tempBok.settAntallUtlaan(tempBok.hentAntallUtlaant() + 1);
                                Utlaan utlaan = new Utlaan(tempBok, laanersNavn);
                                utlaante.add(utlaan);
                                System.out.println("Boken ble utlaant:" + utlaan.toString());
                                fantBokUtlaan = true;
                                break;

                            }
                            else
                                System.out.println("Alle eksemplarer er laant ut.");


                            fantBokUtlaan = true;

                        }
                    }
                    //Om loopen ikke finner boken:
                    if (!fantBokUtlaan){
                        System.out.println("Finner ikke boken du oensker aa leie.");
                    }

                    break;
                //Printer ut liste over utlaante boeker
                case "5":
                    System.out.println("Liste over utlaante boeker:");
                    for (Utlaan utlaant : utlaante)
                        System.out.println(utlaant.toString());
                    break;

                //Gir beskjed om bruker prøver en ugyldig input
                default:
                    System.out.println("Ugyldig valg, proev igjen.");
                    break;
            }


        }

    }
}

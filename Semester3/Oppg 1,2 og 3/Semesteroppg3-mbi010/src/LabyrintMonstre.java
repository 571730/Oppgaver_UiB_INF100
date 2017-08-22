import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by mikkel on 11/7/16.
 */
public class LabyrintMonstre {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi filen som labyrinten skal leses fra:");
        String innfil = sc.nextLine();
        char [][] labyrint = lesLabyrintFraTil(innfil);
        int antallGullIgjen = 0;
        int antallGull = 0;


        //Deklarerer kooridnater for spillerposisjon i liste, finner 's'
        int[] spillerPosisjon = new int[2];
        for (int i = 0; i < labyrint.length; i++){
            for (int y = 0; y < labyrint.length; y++){
                if (labyrint[i][y]=='s'){
                    spillerPosisjon[0] = i;
                    spillerPosisjon[1] = y;
                }
                //Teller antall gull i labyrinten
                else if(labyrint[i][y]=='g'){
                    antallGullIgjen++;
                }
            }
        }

        boolean avslutt = false;

        //loop som gaar helt til bruker skriver inn 'avslutt'
        while (!avslutt){
            System.out.println("Du har samlet " + antallGull + " gull.");
            System.out.println("Det er " + antallGullIgjen + " igjen.");
            //Printer ut slik labyrinten ser ut
            System.out.println("Labyrint:");
            for (char[] character : labyrint){
                System.out.println(character);
            }

            //Avslutter spillet naar det ikke er mer gull igjen
            if (antallGullIgjen==0){
                System.out.println("-----------------");
                System.out.println("");
                System.out.println("=====   Gratulerer! Du samlet alt gullet i labyrinten   ======");
                System.out.println("Etter det harde eventyret staar du igjen med " + antallGull + " gull!");
                avslutt = true;
                break;
            }

            System.out.println("Hvor vil du gaa? Skriv nord, soer, vest eller oest for aa gaa i respektiv\n" +
                    "retning, eller avslutt for aa avslutte.");

            String brukerValg = sc.nextLine();

            if (brukerValg.equals("avslutt")){
                avslutt = true;
            }
            if (brukerValg.equals("nord")){
                //Genererer midlertidig ny posisjon for spiller, denne tests for aa sjekke om det er en vegg eller ikke
                spillerPosisjon[0] = spillerPosisjon[0] - 1;
                boolean nordOk = false;
                nordOk = kanGaaTil(labyrint,spillerPosisjon);
                if (nordOk){
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='g'){
                        antallGull++;
                        antallGullIgjen--;
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]+1][spillerPosisjon[1]] = ' ';
                    }
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='m'){
                        System.out.println("Et monster blokkerer veien din, og utfordrer deg til aa kaste" +
                                "hoyest terning.");
                        System.out.println("Du og monsteret kaster terninger.");
                        int dinTerning;
                        int monsterTerning;

                        do {
                            dinTerning = terningkast();
                            monsterTerning = terningkast();
                            System.out.println("Du kastet " + dinTerning);
                            System.out.println("Monsteret kastet " + monsterTerning);
                            if (dinTerning > monsterTerning){
                                System.out.println("Du kastet hoyere enn monstret og kan dermed passere.");
                            }
                            if (dinTerning == monsterTerning){
                                System.out.println("Dere kastet likt, og det blir omkamp.");
                            }
                            if (dinTerning < monsterTerning){
                                System.out.println("Monsteret kastet hoyere enn deg.");
                                if (antallGull == 0){
                                    System.out.println("Du har ikke mer gull igjen, og blir spist.");
                                    System.exit(1);
                                }
                                else {
                                    System.out.println("Du bestikker monsteret med en gull, og det blir omkamp");
                                    antallGull--;
                                    dinTerning = monsterTerning;
                                }
                            }

                        } while (dinTerning == monsterTerning);
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0] + 1][spillerPosisjon[1]] = ' ';
                    }
                    else {
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0] + 1][spillerPosisjon[1]] = ' ';
                    }
                }
                else {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Veien er blokkert!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");

                    //passer paa at spillerposisjon forblir lik som foer forsoek paa forflyttning
                    spillerPosisjon[0] = spillerPosisjon[0] + 1;
                }
            }
            if (brukerValg.equals("soer")){
                spillerPosisjon[0] = spillerPosisjon[0] + 1;
                boolean soerOk = false;
                soerOk = kanGaaTil(labyrint,spillerPosisjon);
                if (soerOk){
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='g'){
                        antallGull++;
                        antallGullIgjen--;
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]-1][spillerPosisjon[1]] = ' ';
                    }
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='m'){
                        System.out.println("Et monster blokkerer veien din, og utfordrer deg til aa kaste" +
                                "hoyest terning.");
                        System.out.println("Du og monsteret kaster terninger.");
                        int dinTerning;
                        int monsterTerning;

                        do {
                            dinTerning = terningkast();
                            monsterTerning = terningkast();
                            System.out.println("Du kastet " + dinTerning);
                            System.out.println("Monsteret kastet " + monsterTerning);
                            if (dinTerning > monsterTerning){
                                System.out.println("Du kastet hoyere enn monstret og kan dermed passere.");
                            }
                            if (dinTerning == monsterTerning){
                                System.out.println("Dere kastet likt, og det blir omkamp.");
                            }
                            if (dinTerning < monsterTerning){
                                System.out.println("Monsteret kastet hoyere enn deg.");
                                if (antallGull == 0){
                                    System.out.println("Du har ikke mer gull igjen, og blir spist.");
                                    System.exit(1);
                                }
                                else {
                                    System.out.println("Du bestikker monsteret med en gull, og det blir omkamp");
                                    antallGull--;
                                    dinTerning = monsterTerning;
                                }
                            }

                        } while (dinTerning == monsterTerning);
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0] - 1][spillerPosisjon[1]] = ' ';
                    }
                    else {
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0] - 1][spillerPosisjon[1]] = ' ';
                    }

                }
                else {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Veien er blokkert!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");
                    //passer paa at spillerposisjon forblir lik som foer forsoek paa forflyttning
                    spillerPosisjon[0] = spillerPosisjon[0] - 1;
                }
            }
            if (brukerValg.equals("oest")) {
                spillerPosisjon[1] = spillerPosisjon[1] + 1;
                boolean oestOk = false;
                oestOk = kanGaaTil(labyrint, spillerPosisjon);
                if (oestOk) {
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='g'){
                        antallGull++;
                        antallGullIgjen--;
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]-1] = ' ';
                    }
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='m'){
                        System.out.println("Et monster blokkerer veien din, og utfordrer deg til aa kaste" +
                                " hoyest terning.");
                        System.out.println("Du og monsteret kaster terninger.");
                        int dinTerning;
                        int monsterTerning;

                        do {
                            dinTerning = terningkast();
                            monsterTerning = terningkast();
                            System.out.println("Du kastet " + dinTerning);
                            System.out.println("Monsteret kastet " + monsterTerning);
                            if (dinTerning > monsterTerning){
                                System.out.println("Du kastet hoyere enn monstret og kan dermed passere.");
                            }
                            if (dinTerning == monsterTerning){
                                System.out.println("Dere kastet likt, og det blir omkamp.");
                            }
                            if (dinTerning < monsterTerning){
                                System.out.println("Monsteret kastet hoyere enn deg.");
                                if (antallGull == 0){
                                    System.out.println("Du har ikke mer gull igjen, og blir spist.");
                                    System.exit(1);
                                }
                                else {
                                    System.out.println("Du bestikker monsteret med en gull, og det blir omkamp");
                                    antallGull--;
                                    dinTerning = monsterTerning;
                                }
                            }

                        } while (dinTerning == monsterTerning);
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]-1] = ' ';
                    }
                    else {
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]-1] = ' ';
                    }

                } else {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Veien er blokkert!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");
                    //passer paa at spillerposisjon forblir lik som foer forsoek paa forflyttning
                    spillerPosisjon[1] = spillerPosisjon[1] - 1;
                }
            }
            if (brukerValg.equals("vest")){
                spillerPosisjon[1] = spillerPosisjon[1] - 1;
                boolean vestOk = false;
                vestOk = kanGaaTil(labyrint,spillerPosisjon);
                if (vestOk){
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='g'){
                        antallGull++;
                        antallGullIgjen--;
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]+1] = ' ';
                    }
                    if (labyrint[spillerPosisjon[0]][spillerPosisjon[1]]=='m'){
                        System.out.println("Et monster blokkerer veien din, og utfordrer deg til aa kaste" +
                                "hoyest terning.");
                        System.out.println("Du og monsteret kaster terninger.");
                        int dinTerning;
                        int monsterTerning;

                        do {
                            dinTerning = terningkast();
                            monsterTerning = terningkast();
                            System.out.println("Du kastet " + dinTerning);
                            System.out.println("Monsteret kastet " + monsterTerning);
                            if (dinTerning > monsterTerning){
                                System.out.println("Du kastet hoyere enn monstret og kan dermed passere.");
                            }
                            if (dinTerning == monsterTerning){
                                System.out.println("Dere kastet likt, og det blir omkamp.");
                            }
                            if (dinTerning < monsterTerning){
                                System.out.println("Monsteret kastet hoyere enn deg.");
                                if (antallGull == 0){
                                    System.out.println("Du har ikke mer gull igjen, og blir spist.");
                                    System.exit(1);
                                }
                                else {
                                    System.out.println("Du bestikker monsteret med en gull, og det blir omkamp");
                                    antallGull--;
                                    dinTerning = monsterTerning;
                                }
                            }

                        } while (dinTerning == monsterTerning);
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]+1] = ' ';
                    }
                    else {
                        //Oppdaterer posisjon til spiller
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                        labyrint[spillerPosisjon[0]][spillerPosisjon[1]+1] = ' ';
                    }

                }
                else {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Veien er blokkert!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");
                    //passer paa at spillerposisjon forblir lik som foer forsoek paa forflyttning
                    spillerPosisjon[1] = spillerPosisjon[1] + 1;
                }
            }
        }
    }
    //Metode som sjekker om den nye valgte ruten består av en vegg, eller om den er aapen
    private static boolean kanGaaTil(char[][] labyrintListe, int[] posisjon){
        //Sjekker om ruten er populert av *
        if (Character.toString(labyrintListe[posisjon[0]][posisjon[1]]).equals("*")){
            return false;
        }
        else {
            return true;
        }

    }
    private static int terningkast(){
        int terning = (int)(Math.random()*6+1);
        return terning;
    }

    private static char[][] lesLabyrintFraTil(String filNavn){
        int labyrintBredde = 0;
        int labyrintHoyede = 0;
        try {
            //Oppgitt fil hentes og leses
            File fil = new File(filNavn);
            Scanner inn = new Scanner(fil);
            labyrintBredde = inn.nextInt();
            labyrintHoyede = inn.nextInt();
            //Sjekker om oppgitte parametre er gyldige
            if (labyrintBredde < 1){
                System.out.println("Bredden paa filen er mindre enn 1.");
                inn.close();
                System.exit(1);
            }
            if (labyrintHoyede < 1){
                System.out.println("Hoyeden paa filen er mindre enn 1.");
                inn.close();
                System.exit(1);
            }


        }
        catch (FileNotFoundException e){
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
        catch (NoSuchElementException e){
            System.err.println("NoSuchElementException: " + e.getMessage());
        }


        char[][] labyrintListe = new char[labyrintHoyede][labyrintBredde];

        try {
            File fil = new File(filNavn);
            Scanner inn = new Scanner(fil);
            int antallRader = 0;
            //Hopper over de to foerste radene
            inn.nextLine();
            inn.nextLine();

            //leser av tegn på fil og setter inn i arraylisten
            while (inn.hasNextLine()) {
                String rad = inn.nextLine();
                char[] radTegn = rad.toCharArray();
                int antallRadTegn = 0;
                for (char tegn : radTegn) {
                    labyrintListe[antallRader][antallRadTegn] = tegn;
                    antallRadTegn++;
                }
                if (antallRadTegn != labyrintBredde) {
                    System.out.println("Lengen paa raden stemmer ikke med oppgitt bredde paa rad");
                    System.exit(1);
                }
                antallRader++;

            }

        }
        catch (FileNotFoundException e){
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
        catch (NoSuchElementException e){
            System.err.println("NoSuchElementException: " + e.getMessage());
        }

        return labyrintListe;

    }
}

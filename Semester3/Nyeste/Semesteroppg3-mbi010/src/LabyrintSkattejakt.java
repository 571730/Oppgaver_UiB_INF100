import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mikkel on 03.11.2016.
 */
public class LabyrintSkattejakt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi filen som labyrinten skal leses fra:");
        String innfil = sc.nextLine();
        int labyrintBredde = 0;
        int labyrintHoyede = 0;


        //Deklarerer kooridnater for spillerposisjon i liste
        int[] spillerPosisjon = new int[2];
        //Koordinat for hoyede
        spillerPosisjon[0] = 3;
        //Koordinat for bredde
        spillerPosisjon[1] = 1;
        boolean avslutt = false;

        //loop som gaar helt til bruker skriver inn 'avslutt'
        while (!avslutt){
            //Printer ut slik labyrinten ser ut
            System.out.println("Labyrint:");
            for (int hoyede=0; hoyede < labyrintHoyede; hoyede++){
                for (int bredde=0; bredde < labyrintBredde; bredde++){
                    System.out.print(labyrint[hoyede][bredde]);
                }
                System.out.println("");
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
                    //Oppdaterer posisjon til spiller
                    labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                    labyrint[spillerPosisjon[0]+1][spillerPosisjon[1]] = ' ';
                }
                else {
                    System.out.println("Veien er blokkert!");
                    //passer paa at spillerposisjon forblir lik som foer forsoek paa forflyttning
                    spillerPosisjon[0] = spillerPosisjon[0] + 1;
                }
            }
            if (brukerValg.equals("soer")){
                spillerPosisjon[0] = spillerPosisjon[0] + 1;
                boolean soerOk = false;
                soerOk = kanGaaTil(labyrint,spillerPosisjon);
                if (soerOk){
                    //Oppdaterer posisjon til spiller
                    labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                    labyrint[spillerPosisjon[0]-1][spillerPosisjon[1]] = ' ';

                }
                else {
                    System.out.println("Veien er blokkert!");
                    //passer paa at spillerposisjon forblir lik som foer forsoek paa forflyttning
                    spillerPosisjon[0] = spillerPosisjon[0] - 1;
                }
            }
            if (brukerValg.equals("oest")) {
                spillerPosisjon[1] = spillerPosisjon[1] + 1;
                boolean oestOk = false;
                oestOk = kanGaaTil(labyrint, spillerPosisjon);
                if (oestOk) {
                    //Oppdaterer posisjon til spiller
                    labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                    labyrint[spillerPosisjon[0]][spillerPosisjon[1] - 1] = ' ';

                } else {
                    System.out.println("Veien er blokkert!");
                    //passer paa at spillerposisjon forblir lik som foer forsoek paa forflyttning
                    spillerPosisjon[1] = spillerPosisjon[1] - 1;
                }
            }
            if (brukerValg.equals("vest")){
                spillerPosisjon[1] = spillerPosisjon[1] - 1;
                boolean vestOk = false;
                vestOk = kanGaaTil(labyrint,spillerPosisjon);
                if (vestOk){
                    //Oppdaterer posisjon til spiller
                    labyrint[spillerPosisjon[0]][spillerPosisjon[1]] = 's';
                    labyrint[spillerPosisjon[0]][spillerPosisjon[1]+1] = ' ';

                }
                else {
                    System.out.println("Veien er blokkert!");
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

    private static char[][] lesLabyrintFraTil(String filNavn){
        File fil = null;
        ArrayList<String> tegnLabyrint = new ArrayList<>();
        try {
            //Oppgitt fil hentes og leses
            fil = new File(filNavn);
            Scanner inn = new Scanner(fil);
            int labyrintBredde = inn.nextInt();
            int labyrintHoyede = inn.nextInt();
            char[][] labyrintListe = new char[labyrintBredde][labyrintHoyede];

            //leser av tegn på fil og setter inn i arraylisten
            while (inn.hasNextLine()){
                tegnLabyrint.add(inn.next());
            }

        } catch (FileNotFoundException e){
            System.err.println("FileNotFoundException: " + e.getMessage());
        }

    }
}

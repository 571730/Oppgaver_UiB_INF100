import java.util.Scanner;

/**
 * Created by mikkel on 9/23/16. Semesteroppgaave 1
 */
public class Romertall {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi ditt romertall:");
        String romerTallBokstaver = sc.nextLine();
        //Passer paa at input er i store bokstaver
        romerTallBokstaver = romerTallBokstaver.toUpperCase();
        int romertallSvar = 0;

        //for-loop som gaar gjennom alle tegn, utenom det siste
        for (int i=0; i < romerTallBokstaver.length() - 1 ; i++){

            //Om neste bokstav er en stoerre verdi, trekk fra
            if (romertallTegnVerdi(romerTallBokstaver.charAt(i)) < romertallTegnVerdi(romerTallBokstaver.charAt(i +1))){
                romertallSvar -= romertallTegnVerdi(romerTallBokstaver.charAt(i));
            }
            else {
                romertallSvar += romertallTegnVerdi(romerTallBokstaver.charAt(i));
            }
        }
        //Evaluer verdien til siste bokstav
        romertallSvar += romertallTegnVerdi(romerTallBokstaver.charAt(romerTallBokstaver.length()-1));

        System.out.println("Verdien i desimaltall er: " + romertallSvar);

    }

    //Metode som tar bokstav og returnerer riktig tall
    private static int romertallTegnVerdi(char letter) {
        switch (letter) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}


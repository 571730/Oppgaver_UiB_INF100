import java.util.Scanner;

/**
 * Created by mikkel on 9/24/16.
 */
public class FylltSirkel {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi radius (minst 1):");
        int InputRadius = sc.nextInt();

        //Sjekker om Input er mindre enn 1
        if (InputRadius < 1){
            System.out.println("Oppgitt verdi var mindre enn 1, avslutter programmet.");
        }

        //Gaar videre om input er stoerre eller lik 1
        else {
            //Siden origo er i midten av sirkelen, maa loopene begynne paa negative den siden
            for (int y=-InputRadius; y <= InputRadius; y++){
                for (int x=-InputRadius; x <= InputRadius; x++){
                    if (x*x+y*y <= ((InputRadius + 0.3) * (InputRadius + 0.3))){
                        System.out.print("**");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
                //Hopper til neste linje etter en iterasjon av x og y
                System.out.print("\n");
            }
        }
        }
    }


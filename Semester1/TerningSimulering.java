
import java.util.Scanner;

public class TerningSimulering {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Oppgi verdien som terningens verdi skal vaere hoeyere eller lik (heltall\n" +
                "fra 1 til 6):");
        int InputVerdi = sc.nextInt();

        System.out.println("Oppgi antall terningkast (positivt heltall):");
        int InputKast = sc.nextInt();

        //If-setning som skal forhindre feil input av tall
        if (1 <= InputVerdi && InputVerdi <= 6){
            int StoerreLik = 0;

            //for-loekke som kjoerer gjennom oppgitt antall ganger
            for (int i=1; i <= InputKast; i++){

                //Generer et tilfeldig tall mellom 1 og 6
                int tilfeldigTall = (int) (1+6*Math.random());
                //Om tallet er stoerre eller lik opgitt tall, blir det plusset 1
                if (tilfeldigTall >= InputVerdi){
                    StoerreLik = StoerreLik + 1;
                }
                else {
                    StoerreLik = StoerreLik + 0;
                }
            }
            System.out.println("Terningens verdi var stoerre eller lik " + InputVerdi + " " + StoerreLik + " av " + InputKast + " ganger.");

            //Gjoer variablene fra int til double for presisjon paa svar
            double DoubleInputKast = (double)InputKast;
            double DoubleStoerreLik = (double)StoerreLik;
            //Skaffer prosentverdien
            double ProsentVerdi = (DoubleStoerreLik/DoubleInputKast);

            System.out.println("p(v>=" + InputVerdi + ") = " + ProsentVerdi);
        }

        else {
            System.out.println("Den valgte verdien er ikke gyldig.");
        }
    }
}











































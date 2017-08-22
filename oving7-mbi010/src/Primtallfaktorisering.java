import java.util.Scanner;

/**
 * Created by Mikkel on 30.11.2016.
 */
public class Primtallfaktorisering {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv et heltall stoerre enn 0: ");
        int brukerVerdi = sc.nextInt();
        boolean kjoer = true;

        System.out.println("Faktorer:");

        while (kjoer){
            int minDevisor = finnMinsteDevisor(brukerVerdi);
            if (minDevisor == brukerVerdi){
                kjoer = false;
            }
            brukerVerdi = brukerVerdi/minDevisor;
            System.out.println(minDevisor);
        }

    }
    private static int finnMinsteDevisor(int innTall){
        int utDevisor = 0;

        for (int i=2; innTall >= i; i++){
            if (innTall % i == 0){
                utDevisor = i;
                break;
            }

        }
    return utDevisor;
    }
}

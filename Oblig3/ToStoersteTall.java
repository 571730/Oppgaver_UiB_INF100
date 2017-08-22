import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ToStoersteTall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> MinListe = new ArrayList<>();
        System.out.println("Hvor mange tall skal leses inn (minst 2)?:");
        int AntallVerdier = sc.nextInt();

        if (AntallVerdier >= 2) {


            for (int i = 1; i == AntallVerdier; i++) {
                System.out.println("Oppgi verdi " + i + ":");
                int TilListe = sc.nextInt();
                MinListe.add(TilListe);
            }
            //Sortere listen fra høyeste til laveste verdi
            Collections.reverse(MinListe);

            if (MinListe.get(0).equals(MinListe.get(1))){
                System.out.println("Den stoerste verdien er " + MinListe.get(0));
                System.out.println("Den nest stoerste verdien er INGEN");
            }

            else {
                System.out.println("Den stoerste verdien er " + MinListe.get(0));
                System.out.println("Den nest stoerste verdien er " + MinListe.get(1));
            }

        }

        else {
            System.out.println("Vennligst oppgi en verdi som minst er lik 2");
        }
    }
}

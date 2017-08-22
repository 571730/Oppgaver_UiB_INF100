import java.util.Scanner;

/**
 * Created by Mikkel on 13.09.2016.
 */
public class Rektangel {
    public static void main(String[] args){
        //Opretter scanner
        Scanner sc = new Scanner(System.in);

        System.out.println("Oppgi hoyde (minst 1): ");
        int Hoyde = sc.nextInt();

        System.out.println("Oppgi bredde (minst 1): ");
        int Bredde = sc.nextInt();

        //Sjekker om input er mindre enn 1
        if (Hoyde < 1){
            System.out.println("Hoyde kan ikke vaere mindre enn 1");
        }
        else if (Bredde < 1){
            System.out.println("Bredde kan ikke vaere mindre enn 1");
        }

        //Gaar videre om input er godkjent
        else {
            for (int i = 0; i < Hoyde; i++ ){
                for (int n = 0; n < Bredde; n++){
                    System.out.print("*");
                }
            System.out.println();
            }
        }
    }
}

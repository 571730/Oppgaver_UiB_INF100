import java.util.Scanner;

/**
 * Created by Mikkel on 13.09.2016.
 */
public class Fibonacci {
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Startverdier
        int FibNummer1 = 0;
        int FibNummer2 = 1;
        int FibSum = 0;
        int FibTall = 2;

        System.out.println("Oppgi hoeyeste tall som Fibonacci-tall kan vaere likt:");
        int HoyesteTall = sc.nextInt();

        if (HoyesteTall < 0){
            System.out.println("FEIL! Maks-verdi maa minst vaere lik null.");
        }

        else {
            //hardcode for aa faa ut de foerste 2 tallene
            System.out.println("Fibonacci-tall 0 = 0");
            System.out.println("Fibonacci-tall 1 = 1");

            //While-loop for aa stoppe loekken naar den naar inputverdi
            while (FibSum < HoyesteTall){
                FibSum = FibNummer1 + FibNummer2;
                FibNummer1 = FibNummer2;
                FibNummer2 = FibSum;
                System.out.println("Fibonacci-tall " + (FibTall) + " = " + FibSum);

                FibTall++;
            }
        }
    }
}

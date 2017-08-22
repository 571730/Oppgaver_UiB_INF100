//Task 3


import java.util.Scanner;

public class HoyedeMeterFot {
    public static void main(String[] args) {
        //Creating the scanner and calling it sc
        Scanner sc = new Scanner(System.in);

        //Create two variables to be used later
        Double Resultat = 0.0;
        Double Coefficient = 3.2808399;


        System.out.println("What is your name?");
        String Navn = sc.nextLine();

        //A while loop that enables the program to promp user again if invalid input is given
        while (true) {
            System.out.println("Type 1 to convert from metric to imperial units");
            System.out.println("Type 2 to convert from imperial to metric units");

            Integer Valg = sc.nextInt();

            //"IF" statements to do seperate calculations according to the user choice

            //If user choose option number one, go this route
            if (Valg == 1) {
                System.out.println("Please enter your value in meters:");
                Double VerdiMeter = sc.nextDouble();

                //Use the coefficient to calculate desired convertion
                Resultat = (VerdiMeter * Coefficient);

                System.out.println("Hello " + Navn);
                System.out.println("Your height is " + Resultat + " feet.");

                break;
            }

            //Route number two
            if (Valg == 2) {
                System.out.println("Please enter your value in feet:");
                Double VerdiFot = sc.nextDouble();

                Resultat = (VerdiFot / Coefficient);
                System.out.println("Hello " + Navn);
                System.out.println("Your height is " + Resultat + " meters.");
                break;
            }

            //If the user does not enter a valid option, a warning will be given
            else {
                System.out.println("The value registered was not valid.");

            }
        }
    }
}

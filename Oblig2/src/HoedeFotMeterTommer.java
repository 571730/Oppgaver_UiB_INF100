import java.util.Scanner;

public class HoedeFotMeterTommer {
    public static void main(String[] args){
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

                //Find integer value of result
                int IntResultat = Resultat.intValue();

                //Use double and integer values of result to find the digits after the decimal point
                Double DiffResultat = Resultat - IntResultat;

                //Use the remainder to calculate how many inches it translates to
                Double ResultatTommer = 12*DiffResultat;

                //Make the inches value an Integer
                int IntResultatTommer = ResultatTommer.intValue();


                System.out.println("Hello " + Navn);
                System.out.println("Your height is " + IntResultat + " feet and " + IntResultatTommer + " inches");

                break;
            }

            //Route number two
            if (Valg == 2) {
                System.out.println("Please enter number of feet:");
                Double VerdiFot = sc.nextDouble();

                System.out.println("Please enter number of inches:");
                Double VerdiTommer = sc.nextDouble();

                Resultat = (VerdiFot / Coefficient) + ((VerdiTommer*12) / Coefficient);
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

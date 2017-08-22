
import java.util.Scanner;

//Task 2

public class Helg {

    public static void main(String[] args) {
        //Creating the scanner and calling it sc
        Scanner sc = new Scanner(System.in);

        //Prints out question to user and records the next line of input
        System.out.println("What is your name?");
        String Name = sc.nextLine();

        System.out.println("What do you like to do on saturdays?");
        String SaturdayAnsw = sc.nextLine();

        System.out.println("What do you like to do on sundays?");
        String SundayAnsw = sc.nextLine();

        //Prints out pre-written text and adding answers given by the user
        System.out.println("Hello " + Name);
        System.out.println("On saturdays, you like to " + SaturdayAnsw);
        System.out.println("And on sundays, you like to " + SundayAnsw);

    }
}

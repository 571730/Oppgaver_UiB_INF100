import java.util.Scanner;

/**
 * Created by mikkel on 9/24/16.
 */
public class EnkelKryptering {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inn-tekst:");
        String InnTekst = sc.nextLine();
        System.out.println("Noekkel-verdi:");
        int NoekkelVerdi = sc.nextInt();
        String KryptTekst = "";
        int AlfabetPos = 0;

        for (int i=0; i < InnTekst.length(); i++){
            if (InnTekst.charAt(i) >= 'a' && InnTekst.charAt(i) <= 'z'){
                //KryptTekst += (char)((int)((char)(InnTekst.charAt(i)))+NoekkelVerdi);
                AlfabetPos = ((int)((char)(InnTekst.charAt(i)))+NoekkelVerdi)-(int)'a';
                AlfabetPos = AlfabetPos % 26;
                if (AlfabetPos < 0){
                    KryptTekst += (char)((int)'{' + AlfabetPos);
                }
                else {
                    KryptTekst += (char)((int)'a' + AlfabetPos);
                }
            }
            else {
                KryptTekst += (char)(InnTekst.charAt(i));
            }
        }
        System.out.println(KryptTekst);
    }
}

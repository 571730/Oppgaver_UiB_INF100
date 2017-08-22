/**
 * Created by Mikkel on 18.10.2016.
 */
public class YatzyOmkast {
    public static void main(String[] args) {

        int[] TabellTerning;
        TabellTerning = new int[5];
        int SumPoeng = 0;

        for (int i=1; i < 6; i++){
            //Viser hvilken runde som spilles
            System.out.println("Runde "+ i);

            for (int x=0; x < 5; x++){
                TabellTerning[x] = terningkast();

            }
            for (int x=0; x < 5; x++){
                System.out.println("Terning " + (x+1) + ": " + TabellTerning[x]);
            }
            SumPoeng = SumPoeng + poengForTerninger(TabellTerning);
            int RundePoeng = poengForTerninger(TabellTerning);
            System.out.println("Poeng: " + RundePoeng);

        }
        System.out.println("Poeng totalt: " + SumPoeng);

    }

    //Metode som genrerer et tall mellom 1 og 6, representerer et terningkast
    private static int terningkast(){
        int TerningkastVerdi = (int) (1+6*Math.random());
        return TerningkastVerdi;
    }

    private static int poengForTerninger(int[] Liste){
        int Poeng = 0;

        for (int i=1; i < 7; i++){
            int AntallTerninger = 0;
            for (int z=0; z < 5; z++){
                if (i==Liste[z]){
                    AntallTerninger = AntallTerninger + 1;
                }
            }
            int VerdiTerninger = AntallTerninger * i;
            if (VerdiTerninger > Poeng){
                Poeng = VerdiTerninger;
            }
        }
        return Poeng;
    }
}


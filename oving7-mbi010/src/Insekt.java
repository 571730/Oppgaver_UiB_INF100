/**
 * Created by Mikkel on 30.11.2016.
 */
public class Insekt {
    private int xPosisjon;
    private int yPosisjon;
    private int retning;

    public Insekt(int xPosisjon, int yPosisjon){
        this.xPosisjon = xPosisjon;
        this.yPosisjon = yPosisjon;
        retning = 0;
    }
    public void snuMotVenstre(){
        retning = retning + 1;
        if (retning == 4){
            retning = 0;
        }
    }
    public void snuMotHoyre(){
        retning = retning - 1;
        if (retning == -1){
            retning = 3;
        }
    }
    public void bevegFremover(){
        switch (retning){
            case 0:
                xPosisjon = xPosisjon + 1;
                break;

            case 1:
                yPosisjon = yPosisjon - 1;
                break;

            case 2:
                xPosisjon = xPosisjon - 1;
                break;

            case 3:
                yPosisjon = yPosisjon + 1;
                break;
        }
    }
    public int hentX(){
        return xPosisjon;
    }
    public int hentY(){
        return yPosisjon;
    }
    public String toString(){
        return "Insekt[xPosisjon="+xPosisjon+", yPosisjon="+yPosisjon+", retning="+retning+"]";
    }
}

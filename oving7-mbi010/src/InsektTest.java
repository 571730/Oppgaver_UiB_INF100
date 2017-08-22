/**
 * Created by Mikkel on 30.11.2016.
 */
public class InsektTest {
    public static void main(String[] args){
        Insekt insekt = new Insekt(10,10);
        System.out.println(insekt.toString());
        insekt.bevegFremover();
        System.out.println(insekt.toString());
        insekt.bevegFremover();
        System.out.println(insekt.toString());
        insekt.bevegFremover();
        System.out.println(insekt.toString());
        insekt.snuMotHoyre();
        insekt.bevegFremover();
        System.out.println(insekt.toString());
        insekt.snuMotHoyre();
        insekt.bevegFremover();
        System.out.println(insekt.toString());
        insekt.snuMotHoyre();
        System.out.println(insekt.toString());
        insekt.snuMotHoyre();
        System.out.println(insekt.toString());
        insekt.snuMotHoyre();
        System.out.println(insekt.toString());
    }
}

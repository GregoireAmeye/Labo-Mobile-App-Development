package be.howest.nmct.stopafstandcalculator;
import java.util.Scanner;
/**
 * Created by Gregoire on 12/02/2015.
 */
public class TestStopAfstand
{
    public static void main (String [] args)
    {
        /*
        System.out.println("Demo Oefening 1");

        Voertuig v1 = new Voertuig(Voertuig.MerkVoertuig.OPEL,2014);
        System.out.println(v1);

        //opvragen data via klasse scanner
        Scanner scanner = new Scanner(System.in);

        int getal = scanner.nextInt();
        System.out.println("Getal is: " + getal);

        System.out.println("Geef een decimaal getal op:");
        float decimaalgetal = scanner.nextFloat();
        System.out.println("Decimaal getal is: "+ decimaalgetal);
        */

        System.out.println("Demo Oefening 2");
        StopAfstandInfo res = new StopAfstandInfo(StopAfstandInfo.WegType.WEGDEK_DROOG,60,1);
        System.out.println(res);
        res = new StopAfstandInfo(StopAfstandInfo.WegType.WEGDEK_NAT,60,1);
        System.out.println(res);


        Scanner scanner = new Scanner(System.in);
        StopAfstandInfo i = new StopAfstandInfo();

        System.out.println("Geef snelheid op (in km/u):");
        i.setSnelheid(scanner.nextInt());

        System.out.println("Geef reactietijd op (in sec, bv: 1,2)");
        i.setReactietijd(scanner.nextFloat());

        System.out.println("Welk wegtype selecteer je: NAT of DROOG");
        if(scanner.next()== "NAT")
        {
            i.setWegtype(StopAfstandInfo.WegType.WEGDEK_NAT);
        }
        else i.setWegtype(StopAfstandInfo.WegType.WEGDEK_DROOG);

        i.getStopAfstand();
        System.out.println("De StopAfstand is: " +i.getStopafstand());
    }
}

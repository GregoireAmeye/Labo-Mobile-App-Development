package be.howest.nmct.stopafstandcalculator;
import java.util.Scanner;
/**
 * Created by Gregoire on 12/02/2015.
 */
public class StopAfstandInfo {

    public static enum WegType {WEGDEK_DROOG, WEGDEK_NAT}

    private float snelheid;
    private float reactietijd;
    private float stopafstand;
    private WegType wegtype;

    private int remvertraging;


    //constructor

    public StopAfstandInfo() {
    }

    public StopAfstandInfo(WegType wegtype, int snelheid, float reactietijd) {

        this.wegtype = wegtype;
        if(this.wegtype==WegType.WEGDEK_NAT)
        {
            remvertraging = 5;
        }
        else
        {
            remvertraging = 8;
        }
        this.snelheid = snelheid;
        this.reactietijd = reactietijd;
        this.stopafstand = getStopAfstand();
    }

    // getters and setters

    public float getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid)
    {

    }
    public float getReactietijd() {
        return reactietijd;
    }

    public void setReactietijd(float reactietijd)
    {
        this.reactietijd = reactietijd;
    }

    public float getStopafstand() {
        return stopafstand;
    }

    public void setStopafstand(float stopafstand) {
        this.stopafstand = stopafstand;
    }

    public WegType getWegtype() {
        return wegtype;
    }

    public void setWegtype(WegType wegtype)
    {
        this.wegtype = wegtype;
    }

    //methods
    Scanner scanner = new Scanner(System.in);

    public float getStopAfstand()
    {
        snelheid /=3.6;
        stopafstand =snelheid*reactietijd+snelheid*snelheid/(2*remvertraging);
        return stopafstand;
    }

    @Override
    public String toString() {
        return "Type weg: "+wegtype+ " met snelheid van " + Math.round(snelheid*3.6) + " km/u en een reactietijd van "+reactietijd +" sec resulteert in een stopafstand van "+stopafstand+" m.";
    }
}

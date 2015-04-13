package be.howest.nmct.stopafstandcalculator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gregoire on 12/02/2015.
 */
public class Student implements Comparable<Student> // alt+enter (ctrl+; in c#)
{
    private String emailStudent;
    // scores van de student gaan bijhouden -> collectie van objecten van de klasse ModulePunt
    private Map<String, ModulePunt> scoresStudent = new HashMap<String, ModulePunt>();

    //getters and setters

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public Map<String, ModulePunt> getScoresStudent() {
        return scoresStudent;
    }

    public void setScoresStudent(Map<String, ModulePunt> scoresStudent) {
        this.scoresStudent = scoresStudent;
    }

    public void voegScoreToe(String modulenaam, double score) {
        //maak een object van de klasse ModulePunt
        ModulePunt mp = new ModulePunt(score, modulenaam);

        //voeg deze toe aan de collectie
        //controleer eerst even of deze klasse al aanwezig is.
        if (!scoresStudent.containsKey(modulenaam)) {
            scoresStudent.put(modulenaam, mp);
        }
    }

    public void voegScoreToe(String modulenaam, double score, int aantalSp) {
        //maak een object van de klasse ModulePunt
        ModulePunt mp = new ModulePunt(modulenaam, aantalSp, score);

        //voeg deze toe aan de collectie
        //controleer eerst even of deze klasse al aanwezig is.
        if (!scoresStudent.containsKey(modulenaam)) {
            scoresStudent.put(modulenaam, mp);
        }
    }

    //berekenen van de totale score van een student
    public double getTotaleScoreStudent()
    {
        return 0;
    }

    @Override
    public int compareTo(Student another) {
        //zelf uit te werken!

        //indien zelfde totale score --> 0 teruggeven
        return 0;
        //indien kleindere totale score dan andere student --> negatief getal teruggeven
        //indien grotere totale score dan andere student --> positief getal teruggeven
    }

    //3 static methodes

}

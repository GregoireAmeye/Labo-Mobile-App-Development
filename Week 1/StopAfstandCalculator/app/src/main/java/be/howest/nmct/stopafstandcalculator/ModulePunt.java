package be.howest.nmct.stopafstandcalculator;

/**
 * Created by Gregoire on 12/02/2015.
 */
public class ModulePunt {
    private String moduleNaam;
    private int aantalStudiePunten;
    private double score;

    //constructors
    public ModulePunt(String moduleNaam, int aantalStudiePunten, double score) {
        this.moduleNaam = moduleNaam;
        this.aantalStudiePunten = aantalStudiePunten;
        this.score = score;
    }

    public ModulePunt(double score, String moduleNaam) {
        this.score = score;
        this.moduleNaam = moduleNaam;
    }

    // getters and setters
    public String getModuleNaam() {
        return moduleNaam;
    }

    public void setModuleNaam(String moduleNaam) {
        this.moduleNaam = moduleNaam;
    }

    public int getAantalStudiePunten() {
        return aantalStudiePunten;
    }

    public void setAantalStudiePunten(int aantalStudiePunten) {
        this.aantalStudiePunten = aantalStudiePunten;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    //methods

    @Override
    public String toString() {
        return "ModulePunt{" +
                "moduleNaam='" + moduleNaam + '\'' +
                ", aantalStudiePunten=" + aantalStudiePunten +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModulePunt that = (ModulePunt) o;

        if (moduleNaam != null ? !moduleNaam.equals(that.moduleNaam) : that.moduleNaam != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return moduleNaam != null ? moduleNaam.hashCode() : 0;
    }
}

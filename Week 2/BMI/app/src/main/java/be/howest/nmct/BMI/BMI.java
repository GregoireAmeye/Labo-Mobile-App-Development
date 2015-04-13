package be.howest.nmct.BMI;

/**
 * Created by Gregoire on 25/02/2015.
 */
public class BMI {

    public enum  Category{
        Groot_ondergewicht      (0,15),
        Ernstig_ondergewicht    (15,16),
        Ondergewicht            (16,(float)18.5),
        Normaal                 ((float)18.5,25),
        Overgewicht             (25,30),
        Matig_overgewicht       (30,35),
        Ernstig_overgewicht     (35,40),
        Zeer_groot_overgewicht  (40,10000)
        ;
        private float lowerBoundary;
        private  float upperBoundary;

        Category(float lowerBoundary, float upperBoundary) {
            this.lowerBoundary = lowerBoundary;
            this.upperBoundary = upperBoundary;
        }

        public float getLowerBoundary() {
            return lowerBoundary;
        }

        public float getUpperBoundary() {
            return upperBoundary;
        }

        public boolean isInBoundary(float index)
        {
            if(index > lowerBoundary && index <upperBoundary)
            {
                return true;
            }
            return false;
        }

        public static Category getCategory(float index)
        {
            for(Category c : Category.values())
            {
                if(c.isInBoundary(index))return c;
            }
            return null;
        }
    }

    private float Height;
    private int Mass;
    private float BMIIndex;

    //Constructors
    public BMI(float height, int mass) {
        Height = height;
        Mass = mass;
        BMIIndex = Recalculate();
    }
    public BMI() {
        Height=170;
        Mass =70;
        BMIIndex = Recalculate();
    }

    //getters and setters
    public float getHeight() {
        return Height;
    }
    public void setHeight(float height) {
        Height = height;
    }
    public int getMass() {
        return Mass;
    }
    public void setMass(int mass) {
        Mass = mass;
    }
    public float getBMIIndex() {
        return BMIIndex;
    }

    //methodes
    public float Recalculate()
    {
        //BMI = gewicht / (lengte * lengte)
        return Mass / (Height*Height);
    }
}

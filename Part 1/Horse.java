
/**
 * Write a description of class Horse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse
{
    //Fields of class Horse
    private String horse_name;
    private char horse_symbol;
    private int distance_travelled;
    private boolean horse_status;
    private double horse_confidence;
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.horse_symbol = horseSymbol;
        this.horse_name = horseName;
        this.horse_confidence = horseConfidence;
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        String horse_status2 = "fallen";

        if(horse_status2 == "fallen"){
            this.horse_status = true;
        } else {
            this.horse_status = false;
        }
    }
    
    public double getConfidence()
    {
        return horse_confidence;
    }
    
    public int getDistanceTravelled()
    {
        return distance_travelled;
    }
    
    public String getName()
    {
        return horse_name;
    }
    
    public char getSymbol()
    {
        return horse_symbol;
    }
    
    public void goBackToStart()
    {
        this.distance_travelled = 0;
    }
    
    public boolean hasFallen()
    {
        if (this.horse_status){
            return true;
        } else {
            return false;
        }
    }

    public void moveForward()
    {
        distance_travelled++;
    }

    public void setConfidence(double newConfidence)
    {
        if(newConfidence >= 0 && newConfidence <= 1){
            this.horse_confidence = newConfidence;
        } else{
            System.out.println("Horse confidence must be either be 0 or 1");
        }
    }
    
    public void setSymbol(char newSymbol)
    {
        this.horse_symbol = newSymbol;
    }
    
}

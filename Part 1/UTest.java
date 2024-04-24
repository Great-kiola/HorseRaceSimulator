public class UTest {
    
    public static void main(String[] args) {
        Horse myHorse = new Horse('y', "Juniper", 0.2);
        
        // System.out.println(myHorse.horse_name);
        // System.out.println(myHorse.horseConfidence);
        myHorse.setConfidence(0.4);
        System.out.println(myHorse.getConfidence());
        
    }

}

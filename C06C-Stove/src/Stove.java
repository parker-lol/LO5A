import java.util.ArrayList;

public class Stove {
    public final static int NUM_BURNERS = 4;
    private ArrayList<Burner> burners; 
    
    public Stove() {
        burners = new ArrayList<Burner>();  
        for (int i = 0; i < NUM_BURNERS; i++)
            burners.add(new Burner());
    }
    
    public void displayStove() {
        boolean hotBurnerPresent = false;
        
        for (Burner burner : burners) {
            burner.display();
            if (burner.getMyTemperature() == Burner.Temperature.BLAZING) {
                hotBurnerPresent = true;
            }
        }
        
        if (hotBurnerPresent) {
            System.out.println("RED LIGHT - HOT BURNER ALERT");
        }
    }
    
    public void turnBurnersUp() {
        burners.get(0).plusButton();
        burners.get(0).plusButton();
        burners.get(0).plusButton();
        burners.get(1).plusButton();
        burners.get(1).plusButton();
        burners.get(2).plusButton();
    }
    
    public void adjustBurners() {
        burners.get(0).plusButton();
        burners.get(1).plusButton();
        burners.get(2).minusButton();   
    }
    
    public void moreBurnerAdjustments() {
        burners.get(0).minusButton();
        burners.get(1).minusButton();
        burners.get(3).plusButton();
    }   
    
    public void timePassing(int numMinutes) {
        for (int i = 0; i < numMinutes; i++)
            for (Burner burner : burners)
                burner.updateTemperature();
    }
    
    public static void main(String[] args) {
        Stove stove = new Stove();
        
        System.out.println("Beginning stove state ");
        stove.displayStove();
        stove.turnBurnersUp();
        stove.timePassing(6);
        System.out.println("\nStove after burners turned up ");
        
        stove.displayStove();
        stove.adjustBurners();
        stove.timePassing(2);
        System.out.println("\nStove after burners adjusted ");
        
        stove.displayStove();
        stove.moreBurnerAdjustments();
        stove.timePassing(1);
        
        System.out.println("\nStove waiting for time to elapse ");
        stove.displayStove();
        stove.timePassing(1);
        System.out.println("\nStove in final state ");
        stove.displayStove();   
    }
}
import java.util.ArrayList;
import java.util.Random;

public abstract class Robot 
    /// disassemble is die and assemble is reproduce ///
{
    protected int charge;

    public boolean disassemble() {
        /// Robot dies depending on charge and chance, if it survive it goes to 0 charge ///
        Random random = new Random();
        if (this.charge < 1){
            return true;
        }
        else if (this.charge < 25){
            if (random.nextDouble() < 0.75){
                return true;
            }
            else{
                this.charge = 0;
                System.out.println("Robot survived a malfunction");
                return false;
            }
        }
        else if (this.charge < 50){
            if (random.nextDouble() < 0.5){
                return true;
            }
            else{
                this.charge = 0;
                System.out.println("Robot survived a malfunction");
                return false;
            }
        }
        else if (this.charge < 75){
            if (random.nextDouble() < 0.25){
                return true;
            }
            else{
                this.charge = 0;
                System.out.println("Robot survived a malfunction");
                return false;
            }
        }
        else{
            this.charge = 0;
            System.out.println("Robot survived a malfunction");
            return false;
        }
    }

    public abstract Robot assemble(String Name);

    public void recharge(boolean corrupted) {
        boolean canCharge = true;
        /// Fully restore charge, unless in a corrupted building ///
        if (corrupted){
            this.charge = 75;
            canCharge = false;
        }
        if (canCharge == true){
            this.charge = 100;
        }
        System.out.println(this.getClass().getSimpleName() + " recharged.");
    }
}

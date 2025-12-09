import java.util.ArrayList;
import java.util.Random;

public class Worker extends Robot {
    // I feel that workers should be much less efficient cleanrs, so they will not always clear corruption
    @Override
    public boolean disassemble() {
        return super.disassemble();
    }

    @Override
    public Robot assemble(String Name) {
        if (this.charge > 49){
            this.charge = this.charge - 50;
            return new Worker();
        }
        return null;
    }

    @Override
    public void recharge(boolean corrupt) {
        super.recharge(corrupt);
    }

    public void fix(ArrayList<Building> buildings) {
        Random random = new Random();
        if (this.charge > 24 && (random.nextInt(5) == 3)){
            for (Building b : buildings) {
                if (b.checkCorruption()) {
                    b.Clean();
                    System.out.println("Worker repaired a building.");
                    return;
                }
            }
        }
        else if (this.charge > 24){
            this.charge = this.charge - 10;
            System.out.println("Worker failed to repair a building.");
            return;
        }
    }
}

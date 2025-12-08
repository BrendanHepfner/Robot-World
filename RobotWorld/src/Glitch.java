import java.util.ArrayList;
import java.util.Random;

public class Glitch extends Robot {
    @Override
    public void disassemble() {
        super.disassemble();
    }

    @Override
    public Robot assemble(String Name) {
        if (this.charge > 49){
        return new Glitch();
        this.charge = this.charge - 50;
        }
    }

    @Override
    public void recharge() {
        super.recharge();
    }

    public void corrupt(ArrayList<Building> buildings) {
        Random rand = new Random();
        if (!buildings.isEmpty() && this.charge > 24) {
            Building b = buildings.get(rand.nextInt(buildings.size()));
            b.Corrupt();
            System.out.println("Glitch corrupted a building!");
            this.charge == this.charge - 25;
        }
    }
}



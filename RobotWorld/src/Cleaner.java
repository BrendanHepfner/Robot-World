import java.util.ArrayList;

public class Cleaner extends Robot {

    @Override
    public void disassemble() {
        super.disassemble();
    }

    @Override
    public Robot assemble(String Name) {
        // Cleaners can “spawn” a new Cleaner robot
        return new Cleaner();
    }

    @Override
    public void recharge() {
        super.recharge();
    }

    public void clean(ArrayList<Building> buildings) {
        // Repairs the first corrupted building found
        for (Building b : buildings) {
            if (b.checkCorruption()) {
                b.Clean();
                System.out.println("Cleaner repaired a building.");
                return;
            }
        }
    }
}

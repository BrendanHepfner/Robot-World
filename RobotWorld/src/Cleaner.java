import java.util.ArrayList;

public class Cleaner extends Robot {

    @Override
    public void disassemble() {
        super.disassemble();
    }

    @Override
    public Robot assemble(String Name) {
        // cleaners can “spawn” a new cleaner robot
        return new Cleaner();
    }

    @Override
    public void recharge() {
        super.recharge();
    }

    public void clean(ArrayList<Building> buildings) {
        // repairs the first corrupted building found
        for (Building b : buildings) {
            if (b.checkCorruption()) {
                b.Clean();
                System.out.println("Cleaner repaired a building.");
                return;
            }
        }
    }
}

import java.util.ArrayList;

public class Worker extends Robot {
    @Override
    public void disassemble() {
        super.disassemble();
    }

    @Override
    public Robot assemble(String Name) {
        return new Worker();
    }

    @Override
    public void recharge() {
        super.recharge();
    }

    public void fix(ArrayList<Building> buildings) {
        for (Building b : buildings) {
            if (b.checkCorruption()) {
                b.Clean();
                System.out.println("Worker repaired a building.");
                return;
            }
        }
    }
}

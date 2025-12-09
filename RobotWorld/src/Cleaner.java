import java.util.ArrayList;

public class Cleaner extends Robot {


// not sure if this is how we want to implement the cleaner class or not
// but this was my attempt, let me know if it's what you guys had in mind
// i'm just going off of the existing code that i saw...

    @Override
    public boolean disassemble() {
        return super.disassemble();
    }

    @Override
    public Cleaner assemble(String Name) {
        // cleaners can “spawn” a new cleaner robot
        if (this.charge > 49){
            this.charge = this.charge - 50;
            return new Cleaner();
        }
        return null;
    }

    @Override
    public void recharge(boolean corrupt) {
        super.recharge(corrupt);
    }

    public void clean(ArrayList<Building> buildings) {
        // repairs the first corrupted building found
        if (this.charge > 24){
            for (Building b : buildings) {
                if (b.checkCorruption()) {
                    b.Clean();
                    System.out.println("Cleaner repaired a building.");
                    this.charge = this.charge - 25;
                    return;
                }
            }
        }
    }
}

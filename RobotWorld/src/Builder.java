import java.util.ArrayList;

public class Builder extends Robot {
    @Override
    public void disassemble() {
        super.disassemble();
    }

    @Override
    public Robot assemble(String Name) {
        return new Builder();
    }

    @Override
    public void recharge() {
        super.recharge();
    }

    public void build(ArrayList<Building> buildings) {
        buildings.add(new Building());
        System.out.println("Builder created a new building!");
    }
}

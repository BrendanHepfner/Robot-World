import java.util.ArrayList;

public class Builder extends Robot {
    @Override
    public void disassemble() {
        super.disassemble();
    }

    @Override
    public Robot assemble(String Name) {
        if (this.charge > 49){
            this.charge = this.charge - 50;
            return new Builder();
        }
    }

    @Override
    public void recharge() {
        super.recharge();
    }

    public void build(ArrayList<Building> buildings) {
        if (this.charge > 24)
            this.charge = this.charge - 25;
            buildings.add(new Building());
            System.out.println("Builder created a new building!");
        }
    }
}


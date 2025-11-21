import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.awt.Robot;
public class RobotWorld {
    /// I wasn't sure how much you wanted filled out with this specific one so I did that random loop part because that was clear ///
    public static void main(String[] args) {
        RobotWorld world = new RobotWorld();
        world.robotSim();
    }

    public void robotSim(){
        int randomNum = (int)(Math.random()*4);
        ArrayList<Robot> newBots = new ArrayList<>();
        ArrayList<Robot> deadBots = new ArrayList<>();
        ArrayList<Robot> Bots = new ArrayList<>();
        boolean keepgoing = true;
        while (keepgoing == true){
            for(Robot b: Bots){
                randomNum = (int)(Math.random()*4);
                if (randomNum == 0 || randomNum == 3){
                    b.charge();
                }
                else if (randomNum == 1){
                    Robot newRobot = b.assemble(nameGen());
                    newBots.add(newRobot);
                }
                else{
                    deadBots.add(b);
                    b.disassemble();
                }
            }
            Bots.addAll(newBots);
            Bots.removeAll(deadBots);
            newBots.clear();
            deadBots.clear();
        }
    }
    public RobotWorld(){
        int days = 0;
        int buildings;
        int happiness;
    }
    public String nameGen(){
        String Name = "placeholder";
        return Name;
    }
}

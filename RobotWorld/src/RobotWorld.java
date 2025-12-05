import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.awt.Robot;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class RobotWorld {
    String[] names = new String[4945];
    File namelist = new File("names.txt");
    Scanner Scn = null;
    int i = 0;
    
    public static void main(String[] args) throws Exception {
        RobotWorld world = new RobotWorld();
        world.robotSim();
    }

    public void robotSim() throws Exception{
        Scn = new Scanner(namelist);
        nameListCreation();
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
        Random random = new Random();
        String Name = names[random.nextInt(4945)] + " " + names[random.nextInt(4945)];
        return Name;
    }
    public void nameListCreation(){
        while (Scn.hasNextLine()){
            names[i] = Scn.nextLine();
            i++;
        }
    }
}

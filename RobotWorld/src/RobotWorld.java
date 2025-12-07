import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class RobotWorld {
    /// Workers build buildings, which they can live in. They start with 5 buildings and 20 population. Buildings can hold up to 5 Robots.
    /// Robots who do not have a building are significantly less likely to charge. Builders build new buildings, Glitches Corrupt Building,
    //  and spawn from Robots charging in corrupted buildings, and cleaners repair corrupted buildings.
    /// Just use arraylists of arraylists for the buildings, ie an array list of buildings, with each building being an arraylist
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
                if (randomNum == 0){
                    b.recharge();
                }
                else if (randomNum == 1){
                    Robot newRobot = b.assemble(nameGen());
                    newBots.add(newRobot);
                }
                else if (randomNum == 2){
                    if (b instanceof Glitch){
                        b.corrupt;
                    }
                    else if (b instanceof Cleaner){
                        b.clean;
                    }
                    else if (b instanceof Builder){
                        b.build;
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
            system.out.printline()
        }
    }
    public RobotWorld(){
        int days = 0;
        int buildings = 10;
        int population;
        final int robots_per_building = 5;
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




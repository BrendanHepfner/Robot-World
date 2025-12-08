import java.util.Random;
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

    ArrayList<Building> buildings = new ArrayList<>();
    ArrayList<Robot> Bots = new ArrayList<>();
    Random rand = new Random();

    public static void main(String[] args) throws Exception {
        RobotWorld world = new RobotWorld();
        world.robotSim();
    }

    public RobotWorld() {
        int days = 0;
        int buildingsCount = 5;
        final int robots_per_building = 5;

        // Initialize buildings
        for (int b = 0; b < buildingsCount; b++) {
            buildings.add(new Building());
        }

        // Initialize robots: 20 Workers
        for (int r = 0; r < 20; r++) {
            Worker w = new Worker();
            Bots.add(w);
            assignToBuilding(w);
        }
    }

    public void robotSim() throws Exception {
        Scn = new Scanner(namelist);
        nameListCreation();

        ArrayList<Robot> newBots = new ArrayList<>();
        ArrayList<Robot> deadBots = new ArrayList<>();
        int turn = 1;

        boolean keepgoing = true;

        while (keepgoing && turn <= 20) { // run 20 turns
            System.out.println("\n--- Turn " + turn + " ---");

            for (Robot b : Bots) {
                int randomNum = rand.nextInt(4);

                boolean inBuilding = inAnyBuilding(b);
                if (!inBuilding && rand.nextBoolean()) {
                    System.out.println(b.getClass().getSimpleName() + " is homeless and skips action.");
                    continue;
                }

                if (randomNum == 0) {
                    b.recharge();
                } else if (randomNum == 1) {
                    Robot newRobot = b.assemble(nameGen());
                    if (newRobot != null) {
                        newBots.add(newRobot);
                        assignToBuilding(newRobot);
                        System.out.println("New robot assembled: " + nameGen());
                    }
                } else if (randomNum == 2) {
                    if (b instanceof Glitch) {
                        ((Glitch) b).corrupt(buildings);
                    } else if (b instanceof Worker) {
                        ((Worker) b).fix(buildings);
                    } else if (b instanceof Builder) {
                        ((Builder) b).build(buildings);
                    }
                } else {
                    deadBots.add(b);
                    removeFromBuilding(b);
                    b.disassemble();
                    System.out.println("A robot disassembled.");
                }
            }

            Bots.addAll(newBots);
            Bots.removeAll(deadBots);
            newBots.clear();
            deadBots.clear();

            // Summary
            int corrupted = 0;
            for (Building bd : buildings) {
                if (bd.checkCorruption()) corrupted++;
            }
            System.out.println("Robots: " + Bots.size() + ", Buildings: " + buildings.size() + ", Corrupted: " + corrupted);

            turn++;
        }
    }

    public boolean inAnyBuilding(Robot r) {
        for (Building b : buildings) {
            if (b.One == r || b.Two == r || b.Three == r || b.Four == r || b.Five == r)
                return true;
        }
        return false;
    }

    public void assignToBuilding(Robot r) {
        for (Building b : buildings) {
            if (!b.checkFull()) {
                b.houseRobot(r);
                return;
            }
        }
    }

    public void removeFromBuilding(Robot r) {
        for (Building b : buildings) {
            if (b.One == r || b.Two == r || b.Three == r || b.Four == r || b.Five == r) {
                b.removeRobot(r);
                return;
            }
        }
    }

    public String nameGen() {
        Random random = new Random();
        String Name = names[random.nextInt(4945)] + " " + names[random.nextInt(4945)];
        return Name;
    }

    public void nameListCreation() {
        while (Scn.hasNextLine() && i < names.length) {
            names[i] = Scn.nextLine();
            i++;
        }
    }
}

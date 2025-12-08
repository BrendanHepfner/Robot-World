public class Building {
    protected boolean isCorrupted = false;
    protected Robot[] robots = new Robot[5]; // store up to 5 robots

    public boolean houseRobot(Robot robo) {
        for (int i = 0; i < robots.length; i++) {
            if (robots[i] == null) {
                robots[i] = robo;
                return true;
            }
        }
        return false; // building is full
    }

    public void removeRobot(Robot robo) {
        for (int i = 0; i < robots.length; i++) {
            if (robots[i] == robo) {
                robots[i] = null;
                break;
            }
        }
    }

    public boolean checkCorruption() {
        return isCorrupted;
    }

    public boolean checkFull() {
        for (Robot r : robots) {
            if (r == null) return false;
        }
        return true;
    }

    public void corrupt() {
        isCorrupted = true;
    }

    public void clean() {
        isCorrupted = false;
    }
}

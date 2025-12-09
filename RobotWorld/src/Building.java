public class Building {
    protected boolean is_corrupted = false;
    protected boolean isFull = false;
    protected Robot One = null;
    protected Robot Two = null;
    protected Robot Three = null;
    protected Robot Four = null;
    protected Robot Five = null;
    
    public boolean houseRobot(Robot robo){
        if (isFull = false){
            if (this.One == null) {
                this.One = robo;
                return true;
            }
            else if (this.Two == null) {
                this.Two = robo;
                return true;
            }
            else if (this.Three == null) {
                this.Three = robo;
                return true;
            }
            else if(this.Four == null){
                this.Four = robo;
                return true;
            }
            else if(this.Five == null){
                this.Five = robo;
                return true;
            }
            else{
                isFull = true;
                return false;
            }
        }
        else{
            return false;
        }
    }
    public void removeRobot(Robot robo){
        if (this.One == robo) {
            this.One = null;
        }
        else if (this.Two == robo) {
            this.Two = null;
        }
        else if (this.Three == robo){
            this.Three = null;
        }
        else if (this.Four == robo){
            this.Four = null;
        }
        else if (this.Five == robo){
            this.Five = null;
        }
        isFull = false;
    }
    

    public boolean checkCorruption(){
        /// Checks if the building is corrupted, returns true if so ///
        return is_corrupted;
    }

    public boolean checkFull(){
        /// Checks if the building is full, returns true if so ///
        return isFull;
    }
    public void Corrupt(){
        /// Sets the building as corrupted ///
        is_corrupted = true;
    }

    public void Clean(){
        /// Sets the building to not be corrupted ///
        is_corrupted = false;
    }
}

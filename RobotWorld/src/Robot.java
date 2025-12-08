public abstract class Robot 
    /// disassemble is die and assemble is reproduce ///
{
    protected int charge;

    public void disassemble() {
        /// Robot dies ///
        charge = 0;
    }

    public abstract Robot assemble(String Name);

    public void recharge() {
        /// Fully restore charge ///
        charge = 100;
        System.out.println(this.getClass().getSimpleName() + " recharged.");
    }
}

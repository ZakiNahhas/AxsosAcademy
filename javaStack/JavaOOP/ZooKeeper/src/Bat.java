public class Bat extends ZooKeeper{
    public Bat() {
        this.setEnergyLevel(300);
    }
    public void fly() {
        int energy = this.getEnergyLevel();
        setEnergyLevel(energy -50);
        System.out.println("The bat has lost 50 energy levels and now has: " + getEnergyLevel());
    }
    public void eatHumans() {
        int energy = this.getEnergyLevel();
        setEnergyLevel(energy +25);
        System.out.println("The bat has gained 25 energy levels and now has: " + getEnergyLevel());
    }
    public void attackTown() {
        int energy = this.getEnergyLevel();
        setEnergyLevel(energy -100);
        System.out.println("The bat has lost 100 energy levels and now has: " + getEnergyLevel());
    }
}

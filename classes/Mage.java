package classes;

public abstract class Mage extends BaseHero{
    int maxMana;
    int currentMana;

    public Mage(String name) {
        super(name);
        this.currentMana = this.maxMana;
    }

    @Override
    public abstract void hello();

    @Override
    public abstract int damageDoneToMe(int damage);

    public void meditation () {
        if (this.currentMana >= (maxMana / 2)) this.currentMana = this.maxMana;
        else this.currentMana += (maxMana / 2);
        System.out.println("mana restored");
    }
}

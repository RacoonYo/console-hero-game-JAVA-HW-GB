import java.util.Random;

public class Warrior extends BaseHero{
    boolean shield = false;

    public Warrior(String name) {
        super(name);
        super.maxHP = 150;
        super.currentHP = maxHP;
        super.damage = 30;
    }

    protected void raiseShield() {
        this.shield = true;
        System.out.println("shield raised");
        }

}

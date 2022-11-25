import java.util.Random;

public class Rogue extends BaseHero{
    boolean evasion = false;
    public Rogue(String name) {
        super(name);
        super.maxHP = 100;
        super.currentHP = maxHP;
        super.damage = 20;
    }

    protected void evasion() {
        Random random = new Random();
        int flag = random.nextInt(100);
        if (flag % 3 == 0) {
            this.evasion = true;
            System.out.println("miss");
        }
    }
}

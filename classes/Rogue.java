package classes;

import interfaces.Attack;

import java.util.Random;

public class Rogue extends BaseHero implements Attack {
    public Random random = new Random();
    public Rogue(String name) {
        super(name);
        super.maxHP = 100;
        super.damage = 20;
        super.heroClass = "Rogue";
        this.currentHP = this.maxHP;
    }

    @Override
    public void hello() {
        System.out.printf("Hi!!! My name is %s. I'm %s. My maxHP is %d. But now I have %d HP. I can make attack.\n" +
                        "My damage is %d. I can dodge attacks but I don't always succeed.\n" +
                        "When I'm low on HP, I deal 30%% more damage.\n\n",
                        this.name, this.heroClass, this.maxHP, this.currentHP, this.damage);
    }

    @Override
    public int damageDoneToMe(int damage) {
        if (evasion()) return 0;
        else return damage;
    }

    private boolean evasion() {
        int flag = random.nextInt(100);
        if (flag % 3 == 0) {
            System.out.println("miss");
            return true;
        } else return false;
    }

    @Override
    public void attack(BaseHero hero) {
        if (this.currentHP < (0.2 * this.maxHP)) hero.currentHP = hero.currentHP - hero.damageDoneToMe((int)(this.damage * 1.3));
        else hero.currentHP = hero.currentHP - hero.damageDoneToMe(this.damage);
        if(hero.currentHP <= 0) System.out.println(hero.name + "is DEAD");
        else System.out.printf("%s attacks %s! %s has %d HP.\n", this.name, hero.name,
                hero.name, hero.currentHP);
    }
}

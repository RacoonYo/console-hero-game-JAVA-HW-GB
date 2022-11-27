package classes;

import interfaces.Attack;

public class Warrior extends BaseHero implements Attack {
    boolean shield = false;

    public Warrior(String name) {
        super(name);
        super.maxHP = 150;
        super.damage = 30;
        this.heroClass = "Warrior";
        this.currentHP = this.maxHP;
    }

    @Override
    public void hello() {
        System.out.printf("Hello!!! My name is Sir %s. I'm %s. My maxHP is %d. But now I have %d HP. I can make attack.\n" +
                "My damage is %d. I have a shield and I can protect myself with it.\n\n",
                this.name, this.heroClass, this.maxHP, this.currentHP, this.damage);
    }

    @Override
    public int damageDoneToMe(int damage) {
        if (shield) return damage/2;
        else return damage;
    }

    public void raiseShield() {
        this.shield = true;
        System.out.println("shield raised");
        }

    public void attack(BaseHero hero) {
        hero.currentHP = hero.currentHP - hero.damageDoneToMe(this.damage);
        if(hero.currentHP <= 0) System.out.println(hero.name + "is DEAD");
        else System.out.printf("%s attacks %s! %s has %d HP.\n", this.name, hero.name,
                hero.name, hero.currentHP);
    }

}

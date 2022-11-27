package classes;

import interfaces.Attack;

public class BattleMage extends Mage implements Attack {

    public BattleMage(String name) {
        super(name);
        super.maxHP = 120;
        super.currentHP = maxHP;
        super.damage = 35;
        super.heroClass = "Battle Mage";
        super.maxMana = 100;
        super.currentMana = maxMana;
    }

    @Override
    public void hello() {
        System.out.printf("Hello!!! My name is Master %s. I'm %s. My maxHP is %d, maxMana is %d. " +
                        "But now I have %d HP and %d Mana. I can make attack.\n" +
                        "My damage is %d. Every time I hit I spend mana. I need meditation to replenish my mana.\n\n",
                        this.name, this.heroClass, this.maxHP, this.maxMana, this.currentHP, currentMana, this.damage);
    }

    @Override
    public int damageDoneToMe(int damage) {
        return damage;
    }

    @Override
    public void attack(BaseHero hero) {
        int manaCostAttack = 30;
        if (this.currentMana < manaCostAttack) System.out.printf("I can't attack, my Mana is %d\n", this.currentMana);
        else {
            this.currentMana -= manaCostAttack;
            hero.currentHP = hero.currentHP - hero.damageDoneToMe(this.damage);
            if(hero.currentHP <= 0) System.out.println(hero.name + "is DEAD");
            else System.out.printf("%s attacks %s! %s has %d HP.\n", this.name, hero.name,
                hero.name, hero.currentHP);
        }
    }
}

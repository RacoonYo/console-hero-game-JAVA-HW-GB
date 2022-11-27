package classes;

import interfaces.Healing;

/**
 * Маг которому запрещено атаковать. Его специализация: магия поддержки. / This mage is forbidden to attack. His specialty is support magic.
 */

public class Cleric extends Mage implements Healing {
    int healHP;

    public Cleric(String name) {
        super(name);
        super.maxHP = 80;
        super.currentHP = maxHP;
        super.heroClass = "Cleric";
        super.maxMana = 200;
        super.currentMana = maxMana;
        this.healHP = 35;
    }

    @Override
    public void hello() {
        System.out.printf("Hello!!! My name is Saint %s. I'm %s. My maxHP is %d, maxMana is %d. " +
                        "But now I have %d HP and %d Mana. I can't make attack.\n" +
                        "But I can heal %d HP. Every time I heal, I spend mana.. I need meditation to replenish my mana.\n\n",
                        this.name, this.heroClass, this.maxHP, this.maxMana, this.currentHP, currentMana, this.healHP);
    }

    @Override
    public int damageDoneToMe(int damage) {
        return damage;
    }

    @Override
    public void healing(BaseHero hero) {
        int manaCostHeal = 30;
        if (this.currentMana < manaCostHeal) System.out.printf("I can't healing, my Mana is %d\n", this.currentMana);
        else {
            this.currentMana -= manaCostHeal;
            if ((hero.currentHP + this.healHP) > hero.maxHP) hero.currentHP = hero.maxHP;
            else hero.currentHP += this.healHP;
            System.out.printf("%s is healed. %s has %d HP\n", hero.name, hero.name, hero.currentHP);
        }
    }
}

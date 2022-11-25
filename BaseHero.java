public class BaseHero {
    private String name;
    protected int maxHP;
    protected int currentHP;
    protected int damage;


    public BaseHero(String name) {
        this.name = name;
    }

    protected void hello() {
        System.out.printf("Hi!!! My name is %s. My maxHP is %d. But now I have %d HP. I can make attack. " +
                "My damage is %d.\n", this.name, this.maxHP, this.currentHP, this.damage);
    }

    protected void attack (BaseHero hero) {
        hero.currentHP = hero.currentHP - this.damage;
        if(hero.currentHP <= 0) System.out.println(hero.name + "is DEAD");
        else System.out.printf("%s attacks %s! %s takes %d damage. %s has %d HP.\n", this.name, hero.name,
                hero.name, this.damage, hero.name, hero.currentHP);
    }



}

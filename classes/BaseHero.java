package classes;

import interfaces.Attack;

import java.util.Random;

public abstract class BaseHero {
    String name;
    protected int maxHP;
    protected int currentHP;
    protected int damage;
    protected String heroClass;

    public BaseHero(String name) {
        this.name = name;
    }

    public abstract void hello();

    public abstract int damageDoneToMe(int damage);

}

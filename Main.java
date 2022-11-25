public class Main {
    public static void main(String[] args) {
        Rogue rogue1 = new Rogue("Rick");
        Warrior warrior1 = new Warrior("Rob");
        rogue1.hello();
        warrior1.hello();
        rogue1.evasion();
        rogue1.evasion();
        rogue1.evasion();
        warrior1.raiseShield();
        warrior1.attack(rogue1);
    }
}
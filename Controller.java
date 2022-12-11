import classes.BattleMage;
import classes.Cleric;
import classes.Rogue;
import classes.Warrior;

public class Controller {

    public void clickButton(){
        Rogue rogue1 = new Rogue("Rick");
        Warrior warrior1 = new Warrior("Rob");
        BattleMage battleMage1 = new BattleMage("Giendalf");
        Cleric cleric1 = new Cleric("Yaneck");
        rogue1.hello();
        warrior1.hello();
        battleMage1.hello();
        cleric1.hello();
        rogue1.attack(warrior1);
        warrior1.raiseShield();
        rogue1.attack(warrior1);
        warrior1.attack(rogue1);
        warrior1.attack(rogue1);
        warrior1.attack(rogue1);
        warrior1.attack(rogue1);
        battleMage1.attack(warrior1);
        battleMage1.attack(warrior1);
        battleMage1.attack(warrior1);
        battleMage1.attack(warrior1);
        battleMage1.meditation();
        battleMage1.attack(warrior1);
        battleMage1.attack(warrior1);
        cleric1.healing(warrior1);
        cleric1.healing(cleric1);
        rogue1.attack(battleMage1);
    }
}

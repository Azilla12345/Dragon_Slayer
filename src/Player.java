/**
 * This class is the player's class
 *
 * @author Hayden Mak
 */

public class Player {
    /** The health of the player */
    int health;
    /** whether the players guard is up */

    /** the player's name */
    String name;
    /** the player's damage*/
    int damage;
    int damageBuff;

    boolean healthPotion;

    int gold;

    boolean searched;

    Sword Sword = new Sword();


    /**
     * Instantiates a player object
     */
    public Player() {
        name = "";
        health = 100;
        damageBuff = 0;
        healthPotion = false;
        gold = 0;
        searched = false;
    }



    /**
     * Sets the players name
     * @param name name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the players health
     * @return health
     */

    public int getHealth() {
        return health;
    }

    /**
     * Player's attack
     * @return attack
     */
    public int attack() {
        damage = Sword.getDamage();
        return Sword.getDamage();
    }

    public int dodge() {
        return Sword.getDodge();
    }

    public void heal() {
        if (healthPotion) {
            health += 15;
            System.out.println("Heal up 15 health points");
        } else {
            System.out.println("You don't have a potion!");
        }
    }

    public void setSearched() {
        searched = false;
    }

    public void search() {
        if (searched) {
            System.out.println("you have already searched!");
            int goldFound = (int)(Math.random()*10) + 1;
            System.out.println("Instead, you found " + goldFound + " gold!");
            gold += goldFound;
        } else {
            System.out.println("You found a health potion!");
            if (healthPotion) {
                System.out.println("But you already have one!");
            } else {
                System.out.println("You got one health potion!");
                healthPotion = true;

            }
            searched = true;
        }
    }

    public int getGold() {
        return gold;
    }

    /**
     * Set's the guardUp as a true
     */


    /**
     * Attacks if action is 1, guards if action is 2
     * @param action
     */
    public void action(int action) {
        if (action == 1) {
            attack();
            System.out.println(name + " attacks for " + damage + " damage");
        } else if (action ==2){
            heal();
        } else if (action == 3) {
            search();
        }
        else {
            System.out.println("That's not an option!  You got hurt from confusion!");
            health -= 5;
        }
    }


    public void reset() {
        name = "";
        health = 100;
        damageBuff = 0;
        healthPotion = false;
        gold = 0;
        searched = false;
    }
    public void healthBuff(int upgrade) {
        health += upgrade;
    }

    public void DamageBuff(int upgrade) {
        damageBuff += upgrade;
    }

    /**
     * If guard is up, attack gets blocked, otherwise the player loses "damage" worth of health points
     * @param damage
     */
    public void attacked(int damage) {
        if (dodge() >= (int)(Math.random() * 100) + 1 ) {
            System.out.println("Attack was dodged!");
        } else {
            health -= damage;
            System.out.println("Attacked with " + damage + " damage!");
        }
    }

    public void getLoot(int loot) {
        gold += 10;
        if (loot == 0) {
            System.out.println("You got a new sword!");
            Sword.upgrade();
        } else if (loot == 1) {
            System.out.println("You healed up a little");
            health+= 10;
        } else if (loot == 2) {
            System.out.println("You found more gold!");
            gold += 50;
        } else {
            System.out.println("You found nothing");
        }
    }

}
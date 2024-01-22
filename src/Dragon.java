public class Dragon {
    int level;
    double damage;
    boolean boss;
    int enemyHealth;
    int amount;
    int killed;

    int loot;

    public Dragon(Room room) {
        level = (int)(Math.random()* 4) +1;
    }


    public void standard() {
        enemyHealth = 100;
        damage = level * 2 + (int)(Math.random()*5)+ 1;
        loot = ((int)(Math.random()*5) + 1);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount() {
        amount = (int)(Math.random()*3) + 1;
        killed = 0;
    }
    public void boss() {
        enemyHealth = 50 + (int) (1.2 * level);
        damage = 5 + (2 * level);
    }

    public int attack() {
        return (int)(damage);
    }

    public void attacked(int damage) {
        enemyHealth = enemyHealth - damage;
        System.out.println("Dragon attacked for " + damage + " damage");
        System.out.println("Dragon health remaining: " + enemyHealth);
    }


    public boolean isDead () {
        if (enemyHealth <= 0) {
            amount-=1;
        }
        return enemyHealth <= 0;
    }

    public boolean allDead() {
        return amount == 0;
    }

    public int loot() {
        return loot;
    }
}

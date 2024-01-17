public class Dragon {
    private Floors floor;
    double damage;
    boolean boss;


    int enemyHealth;

    public Dragon(Floors floors) {
        floor = floors;
    }

    public Dragon(Floors floors, boolean boss) {
        floor = floors;
        this.boss = boss;
    }

    public void standard() {
        enemyHealth = 10 + (2 * floor.getFloor() );
        damage = 1 + (0.5 * floor.getFloor());
    }

    public void boss() {
        enemyHealth = 50 + (int) (1.2 * floor.getFloor());
        damage = 5 + (2 * floor.getFloor());
    }

    public int attack() {
        return (int)(damage);
    }



    public void attacked(int damage, int dodge) {
        if (((int)(Math.random())* 100) <= dodge) {
            enemyHealth = enemyHealth - damage;
            System.out.println("Dragon attacked for " + damage + " damage");
            System.out.println("Dragon health remaining: " + enemyHealth);
        } else {
            System.out.println("Dragon dodged!");
        }

    }
    public boolean isDead () {
        return enemyHealth <= 0;
    }
}

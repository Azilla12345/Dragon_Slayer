public class Sword {
    public int damage;
    public int dodge;

    public Sword() {
        damage = 30 + (int)(Math.random()*20) + 1;
        dodge = 10;
    }
    public void upgrade() {
        damage += 10;
        dodge += 10;
    }


    public int getDamage() {
        return  damage;
    }
    public int getDodge() {
        return dodge;
    }

}

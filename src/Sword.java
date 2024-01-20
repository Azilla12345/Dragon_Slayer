public class Sword {
    public int damage;
    public int dodge;

    public Sword() {
        damage = 30;
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

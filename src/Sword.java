public class Sword {
    public int damage;
    public int dodge;
    public String swordType;
    public Sword() {
        swordType = "rusty";
        setSwordStats();
    }

    public void setSwordStats() {
        if (swordType.equals("rusty")) {
            damage = 50;
            dodge = 20;
        } else if (swordType.equals("normal")) {
            damage = 20;
            dodge = 30;
        } else {
            damage = 100;
            dodge = 40;
        }
    }

    public void setSwordType(String swordType) {
        this.swordType = swordType;
    }

    public int getDamage() {
        return  damage;
    }
    public int getDodge() {
        return dodge;
    }

}

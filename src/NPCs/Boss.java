package NPCs;

public class Boss extends Enemy{

    private int specialDamage;

    private String[] attackCycle;

    public Boss(int health, int damage, int spDamage) {
        super(health, damage);
    }

    public int getSpecialDamage() {
        return specialDamage;
    }

    public void setSpecialDamage(int specialDamage) {
        this.specialDamage = specialDamage;
    }

    public String[] getAttackCycle() {
        return attackCycle;
    }

    public void setAttackCycle(String[] attackCycle) {
        this.attackCycle = attackCycle;
    }
}

package NPCs;

public class Boss extends Enemy{

    private int specialDamage;

    private String[] attackCycle;

    public Boss(String name, int health, int damage, int specialDamage) {
        super(name, health, damage);
        this.specialDamage = specialDamage;
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

package NPCs;

public class Boss extends Enemy{

    private int specialDamage;
    private int defence;
    private String[] attackCycle;

    public Boss(String name, int health, int damage, int defence, int specialDamage) {
        super(name, health, damage, defence);
        this.defence = defence;
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

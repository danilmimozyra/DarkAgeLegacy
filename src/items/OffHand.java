package items;

public class OffHand extends Item {

    private final int defenceBuff;
    private final int healthBuff;
    private final int damageBuff;

    public OffHand(String name, int defenceBuff, int healthBuff, int damageBuff) {
        super(name, 0, "");
        this.defenceBuff = defenceBuff;
        this.healthBuff = healthBuff;
        this.damageBuff = damageBuff;
    }

    public int getDefenceBuff() {
        return defenceBuff;
    }

    public int getHealthBuff() {
        return healthBuff;
    }

    public int getDamageBuff() {
        return damageBuff;
    }

    public String description(){
        String line = "Your off-hand is " + getName() + ". It grants you";
        if (defenceBuff != 0) {
            line += " +" + defenceBuff + " defence";
        }
        if (healthBuff != 0) {
            line += " +" + healthBuff + " health";
        }
        if (damageBuff != 0) {
            line += " +" + damageBuff + " damage";
        }
        return line + ".";
    }
}

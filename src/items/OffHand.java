package items;

public class OffHand extends Item {

    private int defenceBuff;
    private int speedBuff;
    private int damageBuff;

    public OffHand(String name, int defenceBuff, int speedBuff, int damageBuff) {
        super(name);
        this.defenceBuff = defenceBuff;
        this.speedBuff = speedBuff;
        this.damageBuff = damageBuff;
    }

    public int getDefenceBuff() {
        return defenceBuff;
    }

    public void setDefenceBuff(int defenceBuff) {
        this.defenceBuff = defenceBuff;
    }

    public int getSpeedBuff() {
        return speedBuff;
    }

    public void setSpeedBuff(int speedBuff) {
        this.speedBuff = speedBuff;
    }

    public int getDamageBuff() {
        return damageBuff;
    }

    public void setDamageBuff(int damageBuff) {
        this.damageBuff = damageBuff;
    }
}

package items;

public class Weapon extends Item {
    private final int damage;

    public Weapon(String name, int damage) {
        super(name, 0, "");
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String description(){
        return "Your weapon is " + getName() + ". Your weapon's damage is " + getDamage() + ".";
    }
}

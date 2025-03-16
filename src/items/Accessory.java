package items;

public class Accessory extends Item {
    private String ability;

    public Accessory(String name, String ability) {
        super(name);
        this.ability = ability;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
}

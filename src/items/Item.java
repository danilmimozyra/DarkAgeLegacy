package items;

public class Item {
    private final String name;
    private Ability ability;
    private final boolean isStackable;
    private int amount;

    public Item(String name, int isStackable, String a) {
        this.name = name;
        if (isStackable == 1) {
            this.isStackable = true;
        } else {
            this.isStackable = false;
        }
        this.amount = 1;
        setAbility(a);
    }

    public String getName() {
        return name;
    }

    public boolean isStackable() {
        return isStackable;
    }

    public int getAmount() {
        return amount;
    }

    public void changeAmount(int amount) {
        this.amount += amount;
    }

    public String description(){
        if (isStackable && amount != 1) {
            return name + "(" + amount + ")";
        }
        return name;
    }

    private void setAbility(String a) {
        switch (a){
            case "h":
                ability = Ability.h;
                break;
            case "k":
                ability = Ability.k;
                break;
            case "a":
                ability = Ability.a;
                break;
            case "s":
                ability = Ability.s;
                break;
            case "r":
                ability = Ability.r;
                break;
            default:
                ability = Ability.n;
        }
    }

    public Ability getAbility() {
        return ability;
    }
}

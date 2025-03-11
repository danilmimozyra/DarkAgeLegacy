package items.player;

import items.Inventory;
import items.OffHand;
import items.Weapon;

public class Player {

    private Inventory inventory;
    private Weapon weapon;
    private OffHand offHand;

    public boolean pickUpItem(){
        return false;
    }

    public boolean leaveItem(){
        return false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public OffHand getOffHand() {
        return offHand;
    }

    public void setOffHand(OffHand offHand) {
        this.offHand = offHand;
    }
}

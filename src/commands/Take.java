package commands;

import items.Item;
import items.OffHand;
import items.Weapon;
import items.player.Player;
import mapState.MapState;

public class Take extends Command {
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        Item item = mapS.getCurrentRoom().findItem(command);
        if (item != null) {
            if (item.getClass() == Weapon.class) {
                mapS.getCurrentRoom().removeItem(item);
                mapS.getCurrentRoom().addItem(player.getWeapon());
                player.setWeapon((Weapon) item);
                return "You've picked up weapon " + item.getName() + ".";
            } else if (item.getClass() == OffHand.class) {
                mapS.getCurrentRoom().removeItem(item);
                mapS.getCurrentRoom().addItem(player.getOffHand());
                player.setOffHand((OffHand) item);
                return "You've picked up off-hand " + item.getName() + ".";
            } else {
                if (player.addItem(item)) {
                    mapS.getCurrentRoom().removeItem(item);
                    return "You've picked up " + item.getName() + ".";
                } else {
                    return "You don't have enough space to pick this up!";
                }
            }
        } else {
            return "There is no such item.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }
}

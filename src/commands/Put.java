package commands;

import items.Item;
import items.player.Player;
import mapState.MapState;

public class Put extends Command {
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        Item item = player.removeItem(command);
        mapS.getCurrentRoom().addItem(item);
        if (item != null) {
            return "You have left " + item.getName() + ".";
        }
        return "You don't have this item.";
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

package commands;

import items.Accessory;
import items.Item;
import items.player.Player;
import mapState.MapState;

public class Use extends Command{
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        Item item = player.findItem(command);
        if (item.getClass() == Accessory.class) {
            return ((Accessory) item).getAbility();
        } else {
            return "You don't have that accessory.";
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

package commands;

import items.player.Player;
import mapState.MapState;

public class Invent extends Command{
    @Override
    public String execute(MapState mapS, Player player) {
        return player.inventoryDescription();
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }
}

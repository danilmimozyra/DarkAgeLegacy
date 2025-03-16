package commands;

import items.player.Player;
import mapState.MapState;

public class Tip extends Command{

    @Override
    public String execute(MapState mapS, Player player) {
        return mapS.getCurrentRoom().roomInfo() + "\n" + mapS.getCurrentRoom().itemsList() + "\n" + mapS.getCurrentRoom().NPCList();
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }
}

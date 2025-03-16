package commands;

import items.player.Player;
import mapState.MapState;

public class Leave extends Command{

    @Override
    public String execute(MapState mapS, Player player) {
        return ":(";
    }

    @Override
    public boolean exit() {
        return true;
    }

    @Override
    public void setCommand(String command) {

    }
}

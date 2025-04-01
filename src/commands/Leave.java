package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to end the game
 */
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

    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        return "";
    }
}

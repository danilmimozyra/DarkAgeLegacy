package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to display tip for the current situation
 */
public class Tip extends Command{

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        String line = mapS.getCurrentRoom().roomInfo();
        line += "\nYou have to open the Throne Room in the catacombs using the 'Throne-Room-Key'.";
        return line;
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }
    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        return "";
    }

}

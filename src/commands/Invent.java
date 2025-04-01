package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to print information about the player and his inventory
 */
public class Invent extends Command {

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
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

    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        return null;
    }
}

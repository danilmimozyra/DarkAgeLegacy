package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is a prototype for all other Command classes
 */
public abstract class Command {

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    public abstract String execute(MapState mapS, Player player);
    public abstract boolean exit();
    public abstract void setCommand(String command);

    /**
     * @param mapS is a current MapState in the Enemy is currently located
     * @param player is Player who is getting attacked
     * @param npc is an NPC. If NPC is an Enemy who will attack the player
     * @return String with information what had happened
     */
    public abstract String attackPlayer(MapState mapS, Player player, NPC npc);
}

package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to print all available commands
 */
public class Help extends Command{

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        return """
                go [direction] – relocate to another room if possible.
                help           – displaying help for available commands.
                tip            – additional advice for the current situation.
                take [item]    – picking up an item.
                put [item]     – leave an item.
                use [item]     – activates an item.
                talk [NPC]     – speaking with NPCs.
                attack [NPC]   – dealing damage to an enemy.
                craft [item]   - creating an item.
                give           - leaving an item for an NPC.
                puzzle         - activating the puzzle if the room has one.
                inventory      - displaying what you currently have in your bag.
                block          – protecting yourself from suffering bigger damage.
                leave          – ending the game.""";
    }
    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }

    /**
     * @param mapS is a current MapState in the Enemy is currently located
     * @param player is Player who is getting attacked
     * @param npc is an NPC. If NPC is an Enemy who will attack the player
     * @return String with information what had happened
     */
    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        return null;
    }
}

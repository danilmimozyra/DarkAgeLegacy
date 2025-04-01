package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to put an item from your inventory
 */
public class Put extends Command {
    private String command;

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        Item item = player.removeItem(command);
        mapS.getCurrentRoom().addItem(item);
        if (item != null) {
            return "You have left " + item.getName() + "." +
                    attackPlayer(mapS, player, mapS.getCurrentRoom().getAttackedEnemy());
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

    /**
     * @param mapS is a current MapState in the Enemy is currently located
     * @param player is Player who is getting attacked
     * @param npc is an NPC. If NPC is an Enemy who will attack the player
     * @return String with information what had happened
     */
    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        if (npc != null) {
            if (npc.getClass() == Enemy.class || npc.getClass() == Boss.class) {
                mapS.getCurrentRoom().setAttackedEnemy((Enemy) npc);
                return "=================================================================================================" +
                        "=====================================================================\n" +
                        ((Enemy) npc).attack(player);
            }
        }
        return "";
    }
}

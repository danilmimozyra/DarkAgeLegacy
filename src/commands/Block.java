package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to block enemy attacks
 */
public class Block extends Command {

    private String command;
    private boolean dead = false;
    private boolean block = false;

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        if (command.equals("check")) {
            if (block) {
                block = false;
                player.setDefence(-10);
            }
            command = "block";
            return "";
        } else {
            if (!block) {
                block = true;
                player.setDefence(10);
            }
            String line = "You are now blocking the next shot." + attackPlayer(mapS, player, mapS.getCurrentRoom().getAttackedEnemy());
            if (player.getHealth() <= 0) {
                dead = true;
                line += "\nYou had died.";
            }
            return line;
        }
    }

    @Override
    public boolean exit() {
        return dead;
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
                return "\n=================================================================================================" +
                        "=====================================================================\n"
                        + ((Enemy) npc).attack(player);
            }
        }
        return "";
    }
}

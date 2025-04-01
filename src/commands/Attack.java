package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

import java.util.ArrayList;

/**
 * This class is used to attack enemies
 */
public class Attack extends Command {

    private boolean dead = false;
    private String command;

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        String line;
        NPC n = mapS.getCurrentRoom().findNPC(command);
        if (n != null) {
            n.sufferDamage(player.getDamage());
            if (n.getHealth() <= 0) {
                ArrayList<Item> items = n.drop();
                if (items != null) {
                    for (Item item : items) {
                        mapS.getCurrentRoom().addItem(item);
                    }
                }
                mapS.getCurrentRoom().removeNPC(n);
                assert items != null;
                line = killDescription(n, items);
                mapS.getCurrentRoom().setAttackedEnemy(null);
            } else {
                line = "You've attacked " + n.getName() + ". His remaining health is " + n.getHealth() + "." + attackPlayer(mapS, player, n);
                if (player.getHealth() <= 0) {
                    dead = true;
                    line += "\nYou had died.";
                }
            }
        } else {
            line = "There is no such enemy";
        }
        return line;
    }

    /**
     * @param n is a killed NPC
     * @param items is an ArrayList which contains all the items he had dropped
     * @return String with information what he dropped
     */
    private String killDescription(NPC n, ArrayList<Item> items) {
        String line = "You've killed " + n.getName() + ".";
        if (!items.isEmpty()) {
            line += " He dropped ";
            for (int i = 0; i < items.size(); i++) {
                line += "'" + items.get(i).getName() + "'";
                if (items.get(i).getAmount() > 1) {
                    line += "(" + items.get(i).getAmount() + ")";
                }
                if (i <= items.size() - 3) {
                    line += ", ";
                } else if (i <= items.size() - 2) {
                    line += " and ";
                } else if (i == items.size() - 1) {
                    line += ".";
                }
            }
        }
        return line;
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
                        "=====================================================================" +
                        "\n" + ((Enemy) npc).attack(player);
            }
        }
        return "";
    }
}

package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;
import items.OffHand;
import items.Weapon;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to pick up an item
 */
public class Take extends Command {
    private String command;

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        Item item = mapS.getCurrentRoom().findItem(command);
        String line = "";
        if (item != null) {
            if (item.getClass() == Weapon.class) {
                mapS.getCurrentRoom().removeItem(item);
                mapS.getCurrentRoom().addItem(player.getWeapon());
                player.setWeapon((Weapon) item);
                line = "You've picked up weapon " + item.getName() + ".";
            } else if (item.getClass() == OffHand.class) {
                mapS.getCurrentRoom().removeItem(item);
                mapS.getCurrentRoom().addItem(player.getOffHand());
                player.setOffHand((OffHand) item);
                line = "You've picked up off-hand " + item.getName() + ".";
            } else {
                if (player.addItem(item)) {
                    mapS.getCurrentRoom().removeItem(item);
                    line = "You've picked up " + item.getName() + ".";
                } else {
                    line = "You don't have enough space to pick this up!";
                }
            }
        } else {
            line = "There is no such item.";
        }
        return line + attackPlayer(mapS, player, mapS.getCurrentRoom().getAttackedEnemy());
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

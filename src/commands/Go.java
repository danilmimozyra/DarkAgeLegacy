package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to move between rooms
 */
public class Go extends Command {

    private boolean dead = false;
    private String command;

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        int id;
        String line =  attackPlayer(mapS, player, mapS.getCurrentRoom().getAttackedEnemy());
        if (player.getHealth() <= 0) {
            dead = true;
            line += "\nYou had died.";
            return line;
        }
        switch (command){
            case "west":
                id  = mapS.getCurrentRoom().getWestRoom();
                break;
            case "north":
                id  = mapS.getCurrentRoom().getNorthRoom();
                break;
            case "east":
                id  = mapS.getCurrentRoom().getEastRoom();
                break;
            case "south":
                id  = mapS.getCurrentRoom().getSouthRoom();
                break;
            default:
                return "You seem confused.";
        }
        if (id != 0) {
            mapS.setCurrentRoom(mapS.getMap().get(id));
            return line + mapS.getCurrentRoom().roomDescription();
        } else {
            return "This room doesn't have an entrance there!";
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
                return "=================================================================================================" +
                        "=====================================================================\n" +
                        ((Enemy) npc).attack(player);
            }
        }
        return "";
    }
}

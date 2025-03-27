package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

public class Go extends Command {
    private String command;
    @Override
    public String execute(MapState mapS, Player player) {
        int id;
        String line =  attackPlayer(mapS, player, mapS.getCurrentRoom().getAttackedEnemy());
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
        return false;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

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

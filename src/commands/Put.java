package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

public class Put extends Command {
    private String command;

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

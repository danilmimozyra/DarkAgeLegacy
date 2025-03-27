package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

public class Block extends Command {

    private String command;
    private boolean block = false;

    @Override
    public String execute(MapState mapS, Player player) {
        if (command.equals("check")) {
            if (block) {
                block = false;
                player.setDefence(-10);
            }
            command = "block";
            return "checking def";
        } else {
            if (!block) {
                block = true;
                player.setDefence(10);
            }
            return "You are now blocking the next shot." + attackPlayer(mapS, player, mapS.getCurrentRoom().getAttackedEnemy());
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
                return "\n=================================================================================================" +
                        "=====================================================================\n"
                        + ((Enemy) npc).attack(player);
            }
        }
        return "";
    }
}

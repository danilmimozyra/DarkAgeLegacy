package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

public class Talk extends Command{
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        NPC n = mapS.getCurrentRoom().findNPC(command);
        if (n != null) {
            return n.randomPhrase();
        }
        return "This NPC doesn't exist";
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
        return "";
    }
}

package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

public abstract class Command {
    public abstract String execute(MapState mapS, Player player);
    public abstract boolean exit();
    public abstract void setCommand(String command);
    public abstract String attackPlayer(MapState mapS, Player player, NPC npc);
}

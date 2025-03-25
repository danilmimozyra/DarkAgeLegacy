package commands;

import items.player.Player;
import mapState.MapState;

public class Help extends Command{

    @Override
    public String execute(MapState mapS, Player player) {
        return """
                go [direction] – relocate to another room if possible.
                help           – displaying help for available commands.
                tip            – additional advice for the current situation.
                take [item]    – picking up an item.
                put [item]     – leave an item.
                use [item]     – activates an item.
                talk [NPC]     – speaking with NPCs.
                attack [NPC]   – dealing damage to an enemy.
                craft [item]   - creating an item.
                inventory      - displaying what you currently have in your bag.
                block          – protecting yourself from suffering bigger damage.
                leave          – ending the game.""";
    }
    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }
}

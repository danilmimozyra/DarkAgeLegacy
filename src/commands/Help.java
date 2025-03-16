package commands;

import items.player.Player;
import mapState.MapState;

public class Help extends Command{

    @Override
    public String execute(MapState mapS, Player player) {
        return "go [direction]   – relocate to another room if possible.\n" +
                "help            – displaying help for available commands.\n" +
                "tip             – additional advice for the current situation.\n" +
                "take [item]     – picking up an item.\n" +
                "put [item]      – leave an item.\n" +
                "use [accessory] – activates an item.\n" +
                "talk [NPC]      – speaking with NPCs.\n" +
                "attack [NPC]    – dealing damage to an enemy.\n" +
                "block           – protecting yourself from suffering bigger damage.\n" +
                "leave           – ending the game.";
    }
    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }
}

package commands;

import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

import java.util.Random;

/**
 * This class is used to give items to NPCs
 */
public class Give extends Command{

    private boolean WK = true;
    private String command;
    private final Random rd = new Random();

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        if (WK && mapS.getCurrentRoom().findNPC("wounded-knight") != null) {
            if (command.equalsIgnoreCase("healing-potion")) {
                if (player.hasItem("healing-potion")) {
                    player.findItem("healing-potion").changeAmount(-1);
                    if (player.findItem("healing-potion").getAmount() < 0) {
                        player.removeItem("healing-potion");
                    }
                    WK = false;
                    switch (rd.nextInt(3)) {
                        case 0:
                            mapS.getCurrentRoom().addItem(new Item("Quiver", 0, "n"));
                            return "Thank you kind adventurer, here's a 'Quiver' for you.";
                        case 1:
                            mapS.getCurrentRoom().addItem(new Item("Grindstone", 0, "n"));
                            return "Thank you kind adventurer, here's a 'Grindstone' for you.";
                        case 2:
                            mapS.getCurrentRoom().addItem(new Item("Talisman", 0, "n"));
                            return "Thank you kind adventurer, here's a 'Talisman' for you.";
                    }
                }
            }
        }
        return "There's nothing you can give.";
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
        return null;
    }
}

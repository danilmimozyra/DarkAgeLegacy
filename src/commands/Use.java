package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

public class Use extends Command {
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        Item item = player.findItem(command);
        String line = "";
        switch (item.getAbility()) {
            case h:
                if (player.getHealth() == player.getMaxHealth()) {
                    line = "Your health is full.";
                } else {
                    player.setHealth(player.getHealth() + 50);
                    if (player.getHealth() > player.getMaxHealth()) {
                        player.setHealth(player.getMaxHealth());
                    }
                    player.removeItem(command);
                    line = "Hour health is " + player.getHealth() + "/" + player.getMaxHealth() + ".";
                }
                break;
            case k:
                if (mapS.getCurrentRoom().roomName().equals("Catacombs")){
                    mapS.getCurrentRoom().setSouthRoom(10);
                    player.removeItem(command);
                    line = "The Throne Room has been opened.";
                } else {
                    line = "Seems like there's nothing to be opened.";
                }
                break;
            case s:
                mapS.setCurrentRoom(mapS.getMap().get(1));
                line = "You have teleported to " + mapS.getCurrentRoom().roomName() + ".";
                break;
            default:
                line = "This item has no abilities.";
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

    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        if (npc != null) {
            if (npc.getClass() == Enemy.class || npc.getClass() == Boss.class) {
                mapS.getCurrentRoom().setAttackedEnemy((Enemy) npc);
                return "=================================================================================================" +
                        "=====================================================================\n>> " +
                        "\n" + ((Enemy) npc).attack(player);
            }
        }
        return "";
    }
}

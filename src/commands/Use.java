package commands;

import items.Item;
import items.player.Player;
import mapState.MapState;

public class Use extends Command {
    private String command;

    @Override
    public String execute(MapState mapS, Player player) {
        Item item = player.findItem(command);
        switch (item.getAbility()) {
            case h:
                if (player.getHealth() == player.getMaxHealth()) {
                    return "Your health is full.";
                } else {
                    player.setHealth(player.getHealth() + 50);
                    if (player.getHealth() > player.getMaxHealth()) {
                        player.setHealth(player.getMaxHealth());
                    }
                    player.removeItem(command);
                    return "Hour health is " + player.getHealth() + "/" + player.getMaxHealth() + ".";
                }
            case k:
                if (mapS.getCurrentRoom().roomName().equals("Catacombs")){
                    mapS.getCurrentRoom().setSouthRoom(10);
                    player.removeItem(command);
                    return "The Throne Room has been opened.";
                } else {
                    return "Seems like there's nothing to be opened.";
                }
            case s:
                mapS.setCurrentRoom(mapS.getMap().get(1));
                return "You have teleported to " + mapS.getCurrentRoom().roomName() + ".";
            default:
                return "This item has no abilities.";
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
}

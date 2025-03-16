package commands;

import items.player.Player;
import mapState.MapState;

public class Go extends Command {
    private String command;
    @Override
    public String execute(MapState mapS, Player player) {
        int id;
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
                return "I don't know where to go.";
        }
        if (id != 0) {
            mapS.setCurrentRoom(mapS.getMap().get(id));
            return mapS.getCurrentRoom().getName();
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
}

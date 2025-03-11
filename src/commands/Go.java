package commands;

import mapState.MapState;

public class Go extends Command {
    @Override
    public String execute() {
        return null;
    }

    @Override
    public String execute(MapState mapS, String direction) {
        int id;
        switch (direction){
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
            return "You are now in " + mapS.getCurrentRoom().getName();
        } else {
            return "This room doesn't have an entrance there!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}

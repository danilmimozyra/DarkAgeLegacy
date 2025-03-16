package mapState;

import NPCs.NPC;
import items.Item;

import java.util.ArrayList;

public class Room {

    private final String name;
    private int westRoom;
    private int northRoom;
    private int eastRoom;
    private int southRoom;
    private final ArrayList<NPC> npcs;
    private final ArrayList<Item> items;

    public Room(String name, int westRoom, int northRoom, int eastRoom, int southRoom) {
        this.name = name;
        this.westRoom = westRoom;
        this.northRoom = northRoom;
        this.eastRoom = eastRoom;
        this.southRoom = southRoom;
        items = new ArrayList<>();
        npcs = new ArrayList<>();
    }

    public int getWestRoom() {
        return westRoom;
    }

    public int getNorthRoom() {
        return northRoom;
    }

    public int getEastRoom() {
        return eastRoom;
    }

    public int getSouthRoom() {
        return southRoom;
    }

    public String getName() {
        String line = "You are now in " + name + ". ";
        if (westRoom != 0) {
            line += "You can see an entrance on the west. ";
        }
        if (northRoom != 0) {
            line += "There is a path on the north. ";
        }
        if (eastRoom != 0) {
            line += "The doors on the east can be entered. ";
        }
        if (southRoom != 0) {
            line += "You can go to the room on the south. ";
        }
        return line;
    }

    public String roomInfo(){
        return getName() + "\nTo move between rooms use the command 'go'. The entry should look like this: go [direction].";
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item findItem(String name) {
        if (items != null) {
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void addNPC(NPC npc){
        npcs.add(npc);
    }

    public NPC findNPC(String name){
        for (NPC n : npcs) {
            if (n.getName().equalsIgnoreCase(name)) {
                return n;
            }
        }
        return null;
    }

    public void removeNPC(NPC n){
        npcs.remove(n);
    }

    public String itemsList(){
        String line = "You can see a ";
        for (int i = 0; i < items.size(); i++) {
            line += "'" + items.get(i).getName() + "'";
            if (i <= items.size() - 3) {
                line += ", ";
            } else if (i <= items.size() - 2) {
                line += " and ";
            } else if (i == items.size() - 1) {
                line += " laying on the floor.\nYou can pick them up using the command 'take'. The entry should look like this: take [item].";
            }
        }
        return line;
    }

    public String NPCList(){
        String line = "";
        if (npcs.size() > 1) {
            line += "There are NPCs ";
        } else {
            line += "There is NPC ";
        }
        for (int i = 0; i < npcs.size(); i++) {
            line += "'" + npcs.get(i).getName() + "'";
            if (i <= npcs.size() - 3) {
                line += ", ";
            } else if (i <= npcs.size() - 2) {
                line += " and ";
            } else if (i == npcs.size() - 1) {
                line += " in the room.\nYou can interact with them using the command 'talk'. The entry should look like this: talk [NPC].";
            }
        }
        return line;
    }
}

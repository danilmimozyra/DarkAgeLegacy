package commands;

import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

import java.util.Scanner;

/**
 * This class is used to display a puzzle if the room has one
 */
public class Puzzle extends Command {

    private boolean SOF = true;
    private boolean Lib = true;
    private boolean WK = true;
    private final Scanner sc = new Scanner(System.in);

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        String name = mapS.getCurrentRoom().roomName();
        switch (name) {
            case "Prison Cell":
                if (WK && mapS.getCurrentRoom().findNPC("wounded-knight") != null) {
                    WK = false;
                    return """
                            "Looking for puzzle, aren't you? There's no puzzles here, but if you can give me a healing-potion, I might be able to help you.
                            You can craft it using one Mushroom and one Moss"
                            - says the Wounded-Knight.""";
                }
                break;
            case "Library":
                if (Lib) {
                    System.out.print("I am a house with countless doors,\n" +
                            "Each one leads to distant shores.\n" +
                            "Silent guides in rows I keep,\n" +
                            "Where stories wake and knowledge sleeps.\n" +
                            "What am I?\n" +
                            ">> ");
                    name = sc.next();
                    if (name.equalsIgnoreCase("library")) {
                        mapS.getCurrentRoom().setWestRoom(5);
                        Lib = false;
                        return "A shelf on the west is starting to collapse. You can see some strange corridor.";
                    }
                }
                break;
            case "Sanctuary of Light":
                if (SOF) {
                    System.out.print(" I am not seen, yet clear to all,\n" +
                            "A single spark, and doubts will fall.\n" +
                            "I dwell in minds, yet light the skies,\n" +
                            "Destroying darkness with my rise.\n" +
                            "What am I?\n" +
                            ">> ");
                    name = sc.next();
                    if (name.equalsIgnoreCase("knowledge")) {
                        Item amulet = new Item("Amulet-of-Light", 0, "a");
                        mapS.getCurrentRoom().addItem(amulet);
                        SOF = false;
                        return "A bright beam of light gave you 'Amulet-of-Light'.";
                    }
                }
        }
        return "Seems like there isn't any puzzles in this room.";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }

    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        return null;
    }
}

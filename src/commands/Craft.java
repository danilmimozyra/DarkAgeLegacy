package commands;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;
import items.OffHand;
import items.Weapon;
import items.player.Player;
import mapState.MapState;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * This class is used to craft items
 */
public class Craft extends Command{

    private boolean dead = false;
    private String command;
    private final HashMap<String, String[][]> crafts;

    public Craft() {
        crafts = new HashMap<>();
        loadCrafts();
    }

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        if (command != null) {
            String name = command.toLowerCase();
            String line = "";
            if (crafts.get(name) != null) {
                for (int i = 0; i < crafts.get(name).length-1; i++) {
                    if (player.findItem(crafts.get(name)[i][0]) != null) {
                        if (player.findItem(crafts.get(name)[i][0]).getAmount() < Integer.parseInt(crafts.get(name)[i][1])) {
                            return "You don't have enough materials.";
                        }
                    } else {
                        return "You don't have enough materials.";
                    }
                }
                for (int i = 0; i < crafts.get(name).length-1; i++) {
                    player.changeAmount(crafts.get(name)[i][0], Integer.parseInt(crafts.get(name)[i][1]) * -1);
                }
                Item item = craftItem(name, crafts.get(name)[crafts.get(name).length-1]);
                mapS.getCurrentRoom().addItem(item);
                line = "You've crafted " + item.getName() + ".";
                line += attackPlayer(mapS, player, mapS.getCurrentRoom().getAttackedEnemy());
                if (player.getHealth() <= 0) {
                    dead = true;
                    line += "\nYou had died.";
                }
            } else {
                line = "There is no such crafting recipe.";
            }
            return line;
        }
        return "There is no such crafting recipe.";
    }

    @Override
    public boolean exit() {
        return dead;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }


    /**
     * This method loads all items which you will be able to craft
     */
    private void loadCrafts(){
        try (BufferedReader br = new BufferedReader(new FileReader("crafts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] craftsInfo = line.split(";");
                String[] name = new String[2];
                name[0] = craftsInfo[0];
                name[1] = craftsInfo[2];
                String[] ingredients = craftsInfo[1].split(",");
                String[][] recipe = new String[(ingredients.length/2) + 1][2];
                String[] temp;
                int j = 0;
                for (int i = 0; i < ingredients.length-1; i += 2) {
                    temp = new String[2];
                    temp[0] = ingredients[i];
                    temp[1] = ingredients[i+1];
                    recipe[j] = temp;
                    j ++;
                }
                recipe[recipe.length-1] = name[1].split(",");
                crafts.put(name[0].toLowerCase(), recipe);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @param name is the name of the crafted item
     * @param craftsInfo is an array which contains information about the crafted item
     * @return crafted Item
     */
    private Item craftItem(String name,String[] craftsInfo) {
        return switch (craftsInfo[0]) {
            case "0" -> new Item(name, Integer.parseInt(craftsInfo[1]), craftsInfo[2]);
            case "1" -> new OffHand(craftsInfo[4], Integer.parseInt(craftsInfo[5]),
                    Integer.parseInt(craftsInfo[6]), Integer.parseInt(craftsInfo[7]));
            case "2" -> new Weapon(craftsInfo[4], Integer.parseInt(craftsInfo[5]));
            default -> null;
        };
    }

    /**
     * @param mapS is a current MapState in the Enemy is currently located
     * @param player is Player who is getting attacked
     * @param npc is an NPC. If NPC is an Enemy who will attack the player
     * @return String with information what had happened
     */
    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        if (npc != null) {
            if (npc.getClass() == Enemy.class || npc.getClass() == Boss.class) {
                mapS.getCurrentRoom().setAttackedEnemy((Enemy) npc);
                return "\n=================================================================================================" +
                        "=====================================================================" +
                        "\n" + ((Enemy) npc).attack(player);
            }
        }
        return "";
    }
}

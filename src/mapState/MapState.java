package mapState;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;
import items.OffHand;
import items.Weapon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class MapState {

    private final HashMap<Integer, Room> map = new HashMap<>();
    private Room currentRoom;
    private final Random rd = new Random();

    public MapState() {
        loadMap();
        loadNPCs();
        //loadWeapons();
        //loadOffHands();
        loadItems();
        loadDrops();
        currentRoom = map.get(1);
    }

    private void loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] roomInfo = line.split(",");
                Room r = new Room(roomInfo[1],
                        Integer.parseInt(roomInfo[2]),
                        Integer.parseInt(roomInfo[3]),
                        Integer.parseInt(roomInfo[4]),
                        Integer.parseInt(roomInfo[5]));
                map.put(Integer.parseInt(roomInfo[0]), r);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadNPCs() {
        try (BufferedReader br = new BufferedReader(new FileReader("npcs.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] npcInfo = line.split(",");
                map.get(Integer.parseInt(npcInfo[0])).addNPC(createNPC(npcInfo));
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDrops() {
        try (BufferedReader br = new BufferedReader(new FileReader("drops.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dropsInfo = line.split(",");
                map.get(Integer.parseInt(dropsInfo[0])).findNPC(dropsInfo[1]).addDrop(
                        Integer.parseInt(dropsInfo[2]),
                        addDropToNPC(dropsInfo)
                );
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        map.get(rd.nextInt(map.size()) + 1).addItem(
                new OffHand("Torch", 0, 20, 0)
        );
    }

    private void loadItems() {
        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] itemsInfo = line.split(",");
                map.get(Integer.parseInt(itemsInfo[0])).addItem(createItem(itemsInfo));
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        map.get(rd.nextInt(map.size()) + 1).addItem(
                new OffHand("Torch", 0, 20, 0)
        );
    }

    private NPC createNPC(String[] npcInfo) {
        NPC n = switch (npcInfo[1]) {
            case "0" -> new NPC(npcInfo[2], Integer.parseInt(npcInfo[3]));
            case "1" -> new Enemy(npcInfo[2], Integer.parseInt(npcInfo[3]),
                    Integer.parseInt(npcInfo[4]), Integer.parseInt(npcInfo[5]));
            case "2" -> new Boss(npcInfo[2], Integer.parseInt(npcInfo[3]),
                    Integer.parseInt(npcInfo[4]), Integer.parseInt(npcInfo[5]), Integer.parseInt(npcInfo[6]));
            default -> null;
        };
        return n;
    }

    private Item addDropToNPC(String[] dropsInfo) {
        return switch (dropsInfo[3]) {
            case "0" -> new Item(dropsInfo[4], Integer.parseInt(dropsInfo[5]), dropsInfo[6]);
            case "1" -> new OffHand(dropsInfo[4], Integer.parseInt(dropsInfo[5]),
                    Integer.parseInt(dropsInfo[6]), Integer.parseInt(dropsInfo[7]));
            case "2" -> new Weapon(dropsInfo[4], Integer.parseInt(dropsInfo[5]));
            default -> null;
        };
    }

    private Item createItem(String[] craftsInfo) {
        return switch (craftsInfo[1]) {
            case "0" -> new Item(craftsInfo[2], Integer.parseInt(craftsInfo[3]), craftsInfo[4]);
            case "1" -> new OffHand(craftsInfo[2], Integer.parseInt(craftsInfo[3]),
                    Integer.parseInt(craftsInfo[4]), Integer.parseInt(craftsInfo[5]));
            case "2" -> new Weapon(craftsInfo[2], Integer.parseInt(craftsInfo[3]));
            default -> null;
        };
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room r) {
        currentRoom = r;
    }

    public HashMap<Integer, Room> getMap() {
        return map;
    }
}
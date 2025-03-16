package mapState;

import NPCs.NPC;
import items.Item;
import items.OffHand;
import items.Weapon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapState {

    private final HashMap<Integer, Room> map = new HashMap<>();
    private Room currentRoom;

    public MapState() {
        initialise("map.txt");
        currentRoom = map.get(1);
        currentRoom.addItem(new Weapon("Sword", 10));
        currentRoom.addItem(new OffHand("Torch", 0, 10, 0));
        currentRoom.addItem(new Item("a"));
        currentRoom.addItem(new Item("b"));
        currentRoom.addItem(new Item("c"));
        currentRoom.addItem(new Item("d"));
        currentRoom.addItem(new Item("f"));
        currentRoom.addItem(new Item("e"));
        NPC test = new NPC("Test", 15);
        test.addPhrase("phrase1");
        test.addPhrase("phrase2");
        test.addPhrase("phrase3");
        currentRoom.addNPC(test);
    }

    private void initialise(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null){
                String[] roomInfo = line.split(",");
                Room r = new Room(roomInfo[1],
                        Integer.parseInt(roomInfo[2]),
                        Integer.parseInt(roomInfo[3]),
                        Integer.parseInt(roomInfo[4]),
                        Integer.parseInt(roomInfo[5]));
                map.put(Integer.parseInt(roomInfo[0]), r);
            }
        } catch (FileNotFoundException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapState {

    private HashMap<Integer, Room> map = new HashMap<>();
    private Room currentRoom;

    public MapState() {
        initialise("map.txt");
        currentRoom = map.get(1);
    }

    private void initialise(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = "";
            while ((line = br.readLine()) != null){
                String[] roomInfo = line.split(",");
                Room r = new Room(Integer.parseInt(roomInfo[0]), roomInfo[1],
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

    public void setMap(HashMap<Integer, Room> map) {
        this.map = map;
    }
}
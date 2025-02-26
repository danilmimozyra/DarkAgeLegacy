public class Room {

    private String name;
    private int id;
    private int westRoom;
    private int northRoom;
    private int eastRoom;
    private int southRoom;

    public Room(int id, String name, int westRoom, int northRoom, int eastRoom, int southRoom) {
        this.name = name;
        this.id = id;
        this.westRoom = westRoom;
        this.northRoom = northRoom;
        this.eastRoom = eastRoom;
        this.southRoom = southRoom;
    }

    public int getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(int westRoom) {
        this.westRoom = westRoom;
    }

    public int getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(int northRoom) {
        this.northRoom = northRoom;
    }

    public int getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(int eastRoom) {
        this.eastRoom = eastRoom;
    }

    public int getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(int southRoom) {
        this.southRoom = southRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
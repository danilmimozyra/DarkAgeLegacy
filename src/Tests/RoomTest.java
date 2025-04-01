package Tests;

import NPCs.Boss;
import NPCs.NPC;
import items.Item;
import mapState.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room r;

    @BeforeEach
    void init(){
        r = new Room("a", 0,0,0,0);
        Item a = new Item("a", 0, "n");
        r.addItem(a);
        NPC b = new Boss("a", 10, 2,2,2);
        r.addNPC(b);

    }

    @Test
    void findItem() {
        assertNotNull(r.findItem("a"));
    }

    @Test
    void findNPC() {
        assertNotNull(r.findNPC("a"));
    }
}
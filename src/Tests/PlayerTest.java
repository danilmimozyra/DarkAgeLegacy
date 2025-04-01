package Tests;

import items.Item;
import items.player.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player p;
    Item a;

    @BeforeEach
    void init() {
        p = new Player();
        a = new Item("a", 0, "n");
        Item b = new Item("b", 0, "n");
        Item c = new Item("c", 0, "n");
        Item d = new Item("d", 0, "n");
        p.addItem(a);
        p.addItem(b);
        p.addItem(c);
        p.addItem(d);
    }

    @Test
    void getDamage() {
        assertEquals(5,p.getDamage());
    }

    @Test
    void addItem() {
        Item e = new Item("e", 0, "n");
        assertFalse(p.addItem(e));
    }

    @Test
    void findItem() {
        assertNotNull(p.findItem("a"));
    }

    @Test
    void hasItem() {
        assertTrue(p.hasItem("a"));
    }

    @Test
    void removeItem() {
        assertSame(p.removeItem("a"), a);
    }

    @Test
    void changeAmount() {
        p.changeAmount("a",10);
        assertEquals(11, p.findItem("a").getAmount());
    }
}
package Tests;

import items.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item i;

    @BeforeEach
    void init(){
        i = new Item("a",0,"h");
    }

    @Test
    void changeAmount() {
        i.changeAmount(10);
        assertEquals(11, i.getAmount());
    }
}
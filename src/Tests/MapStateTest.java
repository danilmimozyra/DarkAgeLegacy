package Tests;

import mapState.MapState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class MapStateTest {

    MapState m;

    @BeforeEach
    void init(){
        m = new MapState();
    }

    @Test
    void getCurrentRoom() {
        assertSame(m.getMap().get(1), m.getCurrentRoom());
    }
}
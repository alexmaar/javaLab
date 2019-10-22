package agh.cs.lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MapDirectionTest {

    @Test
    void testToString() {

        assertEquals(MapDirection.NORTH.toString(),("północ"));
        assertEquals(MapDirection.EAST.toString(), ("wschód"));
    }

    @Test
    void testNext(){
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);

    }

    @Test
    void testPrevious() {
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        assertNotEquals(MapDirection.NORTH.previous(), MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST);

    }

    @Test
    void testToUnitVector() {
        assertEquals(MapDirection.SOUTH.toUnitVector(),new Vector2d(0,-1));
        assertEquals(MapDirection.WEST.toUnitVector(), new Vector2d(-1,0));
        assertNotEquals(MapDirection.WEST.toUnitVector(), new Vector2d(1,0));
    }
}

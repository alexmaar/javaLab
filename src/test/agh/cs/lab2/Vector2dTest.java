package agh.cs.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d v1=new Vector2d(2,3);
        assertEquals(v1.toString(),"(2,3)");
    }

    @Test
    void precedes() {
        Vector2d v1=new Vector2d(2,3);
        Vector2d v2=new Vector2d(4,6);
        Vector2d v3= new Vector2d(4,1);
        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
        assertFalse(v1.precedes(v3));
    }

    @Test
    void follows() {
        Vector2d v1=new Vector2d(2,3);
        Vector2d v2=new Vector2d(1,0);
        Vector2d v3=new Vector2d(1,8);
        assertTrue(v1.follows(v2));
        assertFalse(v2.follows(v1));
        assertFalse(v1.follows(v3));
    }

    @Test
    void upperRight() {
        Vector2d v1=new Vector2d(2,3);
        Vector2d v2=new Vector2d(1,5);
        Vector2d v3=new Vector2d(-3,6);
        assertEquals(v1.upperRight(v2), new Vector2d(2,5));
        assertEquals(v2.upperRight(v3), new Vector2d(1,6));
    }

    @Test
    void lowerLeft() {
        Vector2d v1=new Vector2d(-2,3);
        Vector2d v2=new Vector2d(1,-8);
        Vector2d v3=new Vector2d(-11,-8);
        assertEquals(v1.lowerLeft(v2), new Vector2d(-2,-8));
        assertEquals(v2.lowerLeft(v3), new Vector2d(-11,-8));
    }

    @Test
    void add() {
        Vector2d v1= new Vector2d(2,4);
        Vector2d v2 = new Vector2d(-1,8);
        Vector2d v3= new Vector2d(0,3);
        assertEquals(v1.add(v2), new Vector2d (1,12));
        assertEquals(v2.add(v3), new Vector2d(-1,11));
    }

    @Test
    void subtract() {
        Vector2d v1= new Vector2d(2,4);
        Vector2d v2 = new Vector2d(-1,8);
        Vector2d v3= new Vector2d(0,3);
        assertEquals(v1.substract(v2), new Vector2d (3,-4));
        assertEquals(v2.substract(v3), new Vector2d(-1,5));
    }

    @Test
    void testEquals() {
        Vector2d v1=new Vector2d(2,3);
        Vector2d v2=new Vector2d(2,3);
        Vector2d v3=new Vector2d(2,6);
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
    }

    @Test
    void oppositeEquals(){
        Vector2d v1=new Vector2d(3,5);
        assertEquals(v1.opposite(), new Vector2d(-3,-5));
        assertNotEquals(v1.opposite(), new Vector2d(3,-6));
    }
}
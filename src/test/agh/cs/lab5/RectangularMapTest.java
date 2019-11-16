package agh.cs.lab5;
import agh.cs.lab3.*;
import agh.cs.lab4.*;
import agh.cs.lab2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;


public class RectangularMapTest {

    IWorldMap map;
    Animal a1;
    Animal a2;
    OptionsParser optionsParser = new OptionsParser();


    @BeforeEach
    public void setUp() {

        map = new RectangularMap(10, 5);
        Animal a1 = new Animal(this.map);
        Animal a2 = new Animal(this.map, new Vector2d(3, 4));

        map.place(a1);
        map.place(a2);
    }

        @Test
        public void objectAtTest() {
         Assert.assertEquals(map.objectAt(new Vector2d (2,2)), ((RectangularMap) map).getAnimals().get(0));
         Assert.assertEquals(map.objectAt(new Vector2d (3,4)),  ((RectangularMap) map).getAnimals().get(1));
         Assert.assertNull(map.objectAt(new Vector2d(3,5)));
         Assert.assertNull(map.objectAt(new Vector2d(1,2)));
        }


        @Test
       public void isOccupiedTest(){
        Assert.assertTrue(map.isOccupied(new Vector2d (2,2)));
        Assert.assertTrue(map.isOccupied(new Vector2d(3,4)));
        Assert.assertFalse(map.isOccupied(new Vector2d(3,5)));
        Assert.assertFalse(map.isOccupied(new Vector2d(1,2)));
        }

        @Test
       public void canMoveToTest(){
        Assert.assertTrue(map.canMoveTo(new Vector2d(1,2)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(3,5)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(3,4)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(10,10)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(2,2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(10,6)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(10,5)));
        }

        @Test
       public void placeTest(){
        Assert.assertFalse(map.canMoveTo(new Vector2d(3,6)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(10,5)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(0,0)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(3,4)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(2,2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(10,6)));

        }

        @Test
        public void IntegrationTest(){
            String [] args = {"f", "l", "f", "l", "r", "f", "f", "f", "r", "f", "f", "f", "f", "f", "f", "f"};
            MoveDirection [] directions = optionsParser.parse(args);
            Animal a1 = new Animal(this.map);
            Animal a2 = new Animal(this.map, new Vector2d(3, 4));
            map.place(a1);
            map.place(a2);
            map.run(directions);

            Assert.assertEquals(a1.getPosition(), new Vector2d (2,2));
            Assert.assertEquals(a2.getPosition(), new Vector2d (3,4));
            Assert.assertEquals(a1.getOrientation(), MapDirection.NORTH);
            Assert.assertEquals(a2.getOrientation(), MapDirection.NORTH);
        }


}




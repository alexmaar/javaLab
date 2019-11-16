package agh.cs.lab4;

import agh.cs.lab3.OptionsParser;
import agh.cs.lab3.Animal;
import agh.cs.lab2.Vector2d;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.MapDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    IWorldMap map;
    Animal a1;
    Animal a2;
    OptionsParser optionsParser = new OptionsParser();

    @BeforeEach
    public void setUp(){
        map = new RectangularMap(10, 5);
        Animal a1 = new Animal(this.map);
        Animal a2 = new Animal(this.map, new Vector2d (3,4));
        map.place(a1);
        map.place(a2);
    }

    @Test
    public void TestObjectAt(){
        Assert.assertEquals(map.objectAt(new Vector2d(2,2)), ((RectangularMap) map).getAnimals().get(0));
      Assert.assertEquals(map.objectAt(new Vector2d (3,4 )), ((RectangularMap) map).getAnimals().get(1));
      Assert.assertNull(map.objectAt(new Vector2d (1,1)));
       Assert.assertNull(map.objectAt(new Vector2d (2,3)));

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <=5; j++) {
                if ((i == 2 && j == 2) || (i == 3 && j == 4))
                    assertNotNull(map.objectAt(new Vector2d(i,j)));
                else assertNull(map.objectAt(new Vector2d(i,j)));
            }
        }

    }

    @Test
    public void TestIsOccupied(){
        Assert.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assert.assertTrue(map.isOccupied(new Vector2d (3,4)));
        Assert.assertFalse(map.isOccupied(new Vector2d (6,1)));
        Assert.assertFalse(map.isOccupied(new Vector2d (2,4)));

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 5; j++) {
                if ((i == 2 && j == 2) || (i == 3 && j == 4))
                    assertTrue(map.isOccupied(new Vector2d(i, j)));
                else assertFalse(map.isOccupied(new Vector2d(i, j)));
            }
        }
    }

    @Test
    public void TestCanMoveTo(){
        Assert.assertTrue(map.canMoveTo(new Vector2d ( 1,1)));
        Assert.assertTrue(map.canMoveTo(new Vector2d ( 0,0)));
        Assert.assertTrue(map.canMoveTo(new Vector2d ( 5,5)));
        Assert.assertTrue(map.canMoveTo(new Vector2d (3,2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d (6,7)));
        Assert.assertFalse(map.canMoveTo(new Vector2d (3,4)));
        Assert.assertFalse(map.canMoveTo(new Vector2d (2,2)));

    }

    @Test
    public void TestPlace(){
        Assert.assertTrue(map.canMoveTo(new Vector2d ( 1,1)));
        Assert.assertTrue(map.canMoveTo(new Vector2d ( 0,0)));
        Assert.assertTrue(map.canMoveTo(new Vector2d ( 5,5)));
        Assert.assertTrue(map.canMoveTo(new Vector2d (3,2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d (-6,7)));
        Assert.assertFalse(map.canMoveTo(new Vector2d (3,4)));
        Assert.assertFalse(map.canMoveTo(new Vector2d (2,2)));
    }

    @Test
    public void TestIntegration(){
        String [] args={"f","b","r","l", "f", "f", "r", "r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = optionsParser.parse(args);

        map.run(directions);

        Assert.assertEquals(((RectangularMap) map).getAnimals().get(0).getPosition(), new Vector2d (2,0));
        Assert.assertEquals(((RectangularMap) map).getAnimals().get(1).getPosition(), new Vector2d (3,5));
        Assert.assertEquals(((RectangularMap) map).getAnimals().get(0).getOrientation(), MapDirection.SOUTH);
        Assert.assertEquals(((RectangularMap) map).getAnimals().get(1).getOrientation(), MapDirection.NORTH);
    }
}

package agh.cs.lab5;
import agh.cs.lab3.*;
import org.junit.jupiter.api.BeforeEach;
import agh.cs.lab2.*;
import agh.cs.lab4.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;


public class GrassFieldTest {
    IWorldMap map;
    Animal a1;
    Animal a2;
    OptionsParser optionsParser = new OptionsParser();

    @BeforeEach
    public void SetUp(){
        map = new GrassField(10);

        a1=new Animal(this.map);
        a2=new Animal(this.map,new Vector2d(3,4));

        map.place(a1);
        map.place(a2);

    }

    @Test
    public void objectAtTest(){
        Assert.assertEquals(map.objectAt(new Vector2d(2,2)),a1);
        Assert.assertEquals(map.objectAt(new Vector2d(3,4)),a2);
        Assert.assertNull(map.objectAt(new Vector2d (2,5)));
        Assert.assertNull(map.objectAt(new Vector2d (8,15)));

        if (map.isOccupied(new Vector2d(1,1)))
            Assert.assertTrue (map.objectAt(new Vector2d(1,1)) instanceof Grass);
        else Assert.assertFalse (map.objectAt(new Vector2d(1,1)) instanceof Grass);

        if (map.isOccupied(new Vector2d(2,3)))
            Assert.assertTrue (map.objectAt(new Vector2d(2,3)) instanceof Grass);
        else Assert.assertFalse (map.objectAt(new Vector2d(2,3)) instanceof Grass);

        if (map.isOccupied(new Vector2d(5,4)))
            Assert.assertTrue (map.objectAt(new Vector2d(5,4)) instanceof Grass);
        else Assert.assertFalse (map.objectAt(new Vector2d(5,4)) instanceof Grass);
    }

    @Test
    public void isOccupiedTest(){
        Assert.assertTrue(map.isOccupied(new Vector2d (2,2)));
        Assert.assertTrue(map.isOccupied(new Vector2d (3,4)));
        Assert.assertFalse(map.isOccupied(new Vector2d (10,5)));
        Assert.assertFalse(map.isOccupied(new Vector2d (2,5)));
        Assert.assertFalse(map.isOccupied(new Vector2d (8,5)));
        Assert.assertFalse(map.isOccupied(new Vector2d (8,10)));

        if(map.objectAt(new Vector2d(8,10)) == null)
            Assert.assertFalse(map.isOccupied(new Vector2d (8,10)));
        else  Assert.assertTrue(map.isOccupied(new Vector2d(8,10)));
    }

    @Test
    public void canMoveToTest(){  // na trawe moze wejsc
        Assert.assertTrue(map.canMoveTo(new Vector2d(1,1)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(8,5)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(9,2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(2,2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(3,4)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(-1,-1)));

        for (int i =0; i<=10; i++){
            for (int j=0; j<=10; j++){
                if ((i==2 && j==2 ) || (i==3 && j==4))
                    Assert.assertFalse(map.canMoveTo(new Vector2d (i,j)));
                else
                    Assert.assertTrue(map.canMoveTo(new Vector2d (i,j)));
            }
        }

    }

    @Test
    public void placeTest(){
//        Assert.assertFalse(map.place(new Animal(map, new Vector2d(2,2))));
//        Assert.assertFalse(map.place(new Animal(map,new Vector2d(3,4))));
        Assert.assertTrue(map.place(new Animal(map,new Vector2d(9,2))));
        Assert.assertTrue(map.place(new Animal(map, new Vector2d(12,2))));
        Assert.assertTrue(map.place(new Animal(map,new Vector2d(3,34))));
        Assert.assertTrue(map.place(new Animal(map,new Vector2d(19,2))));

    }

    @Test
    public void IntegrationTest(){
        String[] args={"f", "l", "f", "l", "r", "f", "f", "f", "r", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = optionsParser.parse(args);
        map.run(directions);

        Assert.assertEquals(a1.getPosition(), new Vector2d(3,1));
        Assert.assertEquals(a2.getPosition(), new Vector2d(3,-2));
        Assert.assertEquals(a1.getOrientation(), MapDirection.SOUTH);
        Assert.assertEquals(a2.getOrientation(), MapDirection.SOUTH);




    }



}

package agh.cs.lab7;
import agh.cs.lab2.*;
import agh.cs.lab3.*;
import agh.cs.lab4.*;
import agh.cs.lab5.*;
import org.junit.Assert;
import org.junit.Test;

public class MapBoundaryGrassFieldTest {

    @Test
    public void addingTest(){
        GrassField grassMap  = new GrassField(0);
        Animal a1= new Animal(grassMap, new Vector2d (3,4));
        Animal a2= new Animal(grassMap, new Vector2d (2,5));
        Animal a3= new Animal(grassMap, new Vector2d (1,1));
        Animal a4= new Animal(grassMap, new Vector2d (2,8));
        grassMap.place(a1);
        grassMap.place(a2);
        grassMap.place(a3);
        grassMap.place(a4);
        Assert.assertEquals(new Vector2d(1,1), grassMap.getLowerLeft());
        Assert.assertEquals(new Vector2d(3,8), grassMap.getUpperRight());

        String[] args={"f", "b", "r" ,"l", "f", "f", "r", "r", "f" ,"f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        grassMap.run(directions);

        Assert.assertEquals(new Vector2d(0,-1), grassMap.getLowerLeft());
        Assert.assertEquals(new Vector2d(3,10), grassMap.getUpperRight());





    }
}

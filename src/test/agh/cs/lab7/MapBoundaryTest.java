package agh.cs.lab7;
import agh.cs.lab2.*;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class MapBoundaryTest {
    MapBoundary mapBound = new MapBoundary();

    Vector2d a = new Vector2d (2,4);
    Vector2d b = new Vector2d (1,9);
    Vector2d c = new Vector2d (1,7);
    Vector2d d = new Vector2d (-2,0);
    Vector2d e = new Vector2d (10,0);

    @Test
    void getLowerTest(){
        mapBound.addPosition(new Vector2d (2,3));
        mapBound.addPosition(new Vector2d (2,9));
        mapBound.addPosition(new Vector2d (-5,4));
        mapBound.addPosition(new Vector2d (0,3));
        Assert.assertEquals(new Vector2d(-5,3), mapBound.getLowerLeft());
        mapBound.addPosition(new Vector2d (0,0));
        Assert.assertEquals(new Vector2d(-5,0), mapBound.getLowerLeft());
        mapBound.addPosition(new Vector2d (-5,4));
        Assert.assertEquals(new Vector2d(-5,0), mapBound.getLowerLeft());
        mapBound.addPosition(new Vector2d (-10,-1));
        Assert.assertEquals(new Vector2d(-10,-1), mapBound.getLowerLeft());
        mapBound.removePosition(new Vector2d (-10,-1));
        Assert.assertEquals(new Vector2d(-5,0), mapBound.getLowerLeft());
    }

    @Test
    void getUpperTest(){
        mapBound.addPosition(new Vector2d (2,3));
        mapBound.addPosition(new Vector2d (2,9));
        mapBound.addPosition(new Vector2d (-5,4));
        mapBound.addPosition(new Vector2d (0,3));
        Assert.assertEquals(new Vector2d(2,9), mapBound.getUpperRight());
        mapBound.addPosition(new Vector2d (0,0));
        Assert.assertEquals(new Vector2d(2,9), mapBound.getUpperRight());
        mapBound.addPosition(new Vector2d (5,4));
        Assert.assertEquals(new Vector2d(5,9), mapBound.getUpperRight());
        mapBound.addPosition(new Vector2d (10,11));
        Assert.assertEquals(new Vector2d(10,11), mapBound.getUpperRight());
        mapBound.removePosition(new Vector2d (10,11));
        Assert.assertEquals(new Vector2d(5,9), mapBound.getUpperRight());
    }
}

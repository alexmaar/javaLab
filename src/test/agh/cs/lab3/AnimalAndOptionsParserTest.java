package agh.cs.lab3;
import agh.cs.lab2.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalAndOptionsParserTest {
    Animal animal = new Animal();
    OptionsParser pars = new OptionsParser();

    @Test
    void settingTest(){
        assertEquals(animal.getPosition(), new Vector2d (2,2));
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
    }

    @Test
    void turningTest() {


        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getOrientation(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d (2,2));
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getOrientation(), MapDirection.SOUTH);
        assertEquals(animal.getPosition(), new Vector2d (2,2));
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getOrientation(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d (2,2));
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (2,2));

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getOrientation(), MapDirection.WEST);
        assertEquals(animal.getPosition(), new Vector2d (2,2));
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getOrientation(), MapDirection.SOUTH);
        assertEquals(animal.getPosition(), new Vector2d (2,2));
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getOrientation(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d (2,2));
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (2,2));


    }

    @Test
    void orientTest()  {
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (2,3));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (2,4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (2,4));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (2,3));

    }

    @Test
    void moveTest(){
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (2,3));
        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getOrientation(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d (2,3));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getOrientation(), MapDirection.EAST);
        assertEquals(animal.getPosition(), new Vector2d (1,3));
        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
        assertEquals(animal.getPosition(), new Vector2d (1,3));

    }

    @Test
    void parseTest(){
        String[] args= new String[]{
                "f",
                "b",
                "lmno",
                "backward",
                "hi",
                "right",
                "left",
                "xyz",

        };
        MoveDirection [] expectedAns={MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT};
        MoveDirection [] res = pars.parse(args);

        for (int i=0; i<res.length; i++)
            assertEquals(expectedAns[i], res[i] );


    }
}
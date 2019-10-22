package agh.cs.lab3;
import agh.cs.lab2.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalAndOptionsParserTest {
    Animal animal = new Animal();
    OptionsParser pars = new OptionsParser();

    @Test
    void moveTest() {
        assertEquals(animal.toString(), ("orientacja : " + MapDirection.NORTH.toString() + " \npozycja : " + new Vector2d (2,2).toString()));
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.toString(), ("orientacja : " + MapDirection.EAST.toString() + " \npozycja : " + new Vector2d(4,2).toString()));
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
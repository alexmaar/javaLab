package agh.cs.lab3;
import agh.cs.lab2.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    Animal animal = new Animal();

    @Test
    void integrationTest(){
        String args[]={"r", "f", "k", "forward", "f", "f", "left", "b", "backward", "backward", "left", "f", "f", "f",
                "forward", "f", "f", "f", "right", "f", "f", "m", "f", "forward", "b", "f", "f", "l"};
        OptionsParser optionsParser=new OptionsParser();
        MoveDirection [] res= optionsParser.parse(args);

        for (MoveDirection direction : res){
            animal.move(direction);

            assertEquals(animal.toString(), ("orientacja : " + MapDirection.NORTH.toString() + " \npozycja : " + new Vector2d(4,4).toString()));
        }
    }
}

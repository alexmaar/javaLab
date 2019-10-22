package agh.cs.lab3;
import agh.cs.lab2.*;

public class World {
    public static void main(String[] args){
        Animal animal = new Animal();
        OptionsParser o = new OptionsParser();

        System.out.println(animal.toString());

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);

        System.out.println(animal.toString());

        MoveDirection[] moveDirections = o.parse(args);

        for(int i=0; i<moveDirections.length; i++) {
            if (moveDirections[i]!=null) {
                animal.move(moveDirections[i]);
            }
        }

        System.out.println(animal.toString());
    }
}
package agh.cs.lab4;

import agh.cs.lab2.*;
import agh.cs.lab3.*;
import agh.cs.lab5.AbstractWorldMap;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap (10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map);
    }
}

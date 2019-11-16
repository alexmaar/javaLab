package agh.cs.lab5;
import agh.cs.lab4.*;
import agh.cs.lab2.*;
import agh.cs.lab3.*;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField (10);
        System.out.println(map);
        try {
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3, 4)));
            map.place(new Animal(map, new Vector2d(2, 5)));
            map.place(new Animal(map, new Vector2d(1, 1)));
            System.out.println(map);
            map.run(directions);
        }catch(Exception e){
            System.out.println("Something went wrong!");
        }
        System.out.println(map);

    }
}
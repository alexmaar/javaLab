package agh.cs.lab5;
import agh.cs.lab4.*;
import agh.cs.lab3.*;
import agh.cs.lab2.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;


abstract public class AbstractWorldMap implements IWorldMap {
    public List<Animal> animals = new ArrayList<>();
     protected Map<Vector2d , IMapElement> elementsMap = new HashMap<>();

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();


    @Override
    public boolean isOccupied(Vector2d position) {
       return this.elementsMap.containsKey(position);
    }

    @Override
    public void run(MoveDirection[] directions)  {
        if (animals.isEmpty()) return;
        Animal animal;
        for (int i = 0; i < directions.length; i++) {
            animal=this.animals.get(i%animals.size());
            elementsMap.get(animal.getPosition());
            Vector2d tmp = animal.getPosition();
            elementsMap.remove(tmp);
            animal.move(directions[i]);
            elementsMap.put(animal.getPosition(),animal);

        }
    }



    @Override
    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }


    @Override
    public Object objectAt(Vector2d position){
        return this.elementsMap.get(position);
    }



    @Override
    public boolean place(Animal animal)  {
        if (!this.canMoveTo(animal.getPosition())) {
            throw new IllegalAccessError("Position is occupied");
        }
        this.animals.add(animal);
        this.elementsMap.put(animal.getPosition(),animal);
        return true;

    }


    @Override
    public String toString(){
        MapVisualizer mapVis = new MapVisualizer(this);
        Vector2d ll = getLowerLeft();
        Vector2d ur = getUpperRight();
        return mapVis.draw(ll, ur);

    }




}

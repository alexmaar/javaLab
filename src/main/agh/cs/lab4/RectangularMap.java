package agh.cs.lab4;
import agh.cs.lab2.Vector2d;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab3.Animal;
import agh.cs.lab5.AbstractWorldMap;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap  {
    private Vector2d lowerLeft;
    private Vector2d upperRight;


    public RectangularMap  (int width,int height) {
        lowerLeft=new Vector2d(0,0);
        upperRight=new Vector2d(width,height);
        this.animals=new ArrayList<>();
    }

    public List<Animal> getAnimals(){
        return this.animals;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
       return super.canMoveTo(position) && position.precedes(this.upperRight) && position.follows(this.lowerLeft);
    }



}

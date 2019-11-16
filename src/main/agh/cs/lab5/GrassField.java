package agh.cs.lab5;
import agh.cs.lab3.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab2.Vector2d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    protected List<Grass> grasses =new ArrayList<>();
    public Random generator = new Random();

    public GrassField (int n) {

        this.animals = new ArrayList<>();
        this.elementsMap = new HashMap<>();


        Vector2d tmp = new Vector2d(generator.nextInt((int) Math.sqrt(n * 10)), generator.nextInt((int)  Math.sqrt(n * 10)));
        this.elementsMap.put(tmp,new Grass(tmp));
        grasses.add(new Grass(tmp));
        for (int i = 1; i < n; i++) {
            while (isOccupied(tmp)) {
                tmp = new Vector2d(generator.nextInt((int) Math.sqrt(n * 10)), generator.nextInt((int)  Math.sqrt(n * 10)));
            }
            this.elementsMap.put(tmp,new Grass(tmp));
            grasses.add(new Grass(tmp));

        }
    }

    public Vector2d getUpperRight(){
        Vector2d tmp = grasses.get(0).getPosition();
        for (IMapElement element : elementsMap.values()){
            tmp=tmp.upperRight(element.getPosition());
        }
        return tmp;
    }

    public Vector2d getLowerLeft(){
        Vector2d tmp = grasses.get(0).getPosition();
        for(IMapElement element : elementsMap.values()){
            tmp=tmp.lowerLeft(element.getPosition());
        }
        return tmp;

    }

}

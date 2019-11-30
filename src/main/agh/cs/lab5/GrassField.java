package agh.cs.lab5;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab2.Vector2d;
import java.util.HashMap;


public class GrassField extends AbstractWorldMap implements IWorldMap {
    protected List<Grass> grasses =new ArrayList<>();
    public Random generator = new Random();


    public GrassField (int n) {
        this.animals = new ArrayList<>();
        this.elementsMap = new HashMap<>();


        if(n > 0) {
            Vector2d tmp = new Vector2d(generator.nextInt((int) Math.sqrt(n * 10)), generator.nextInt((int) Math.sqrt(n * 10)));
            this.elementsMap.put(tmp, new Grass(tmp));
            grasses.add(new Grass(tmp));
            for (int i = 1; i < n; i++) {
                while (isOccupied(tmp)) {
                    tmp = new Vector2d(generator.nextInt((int) Math.sqrt(n * 10)), generator.nextInt((int) Math.sqrt(n * 10)));
                }
                this.elementsMap.put(tmp, new Grass(tmp));
                grasses.add(new Grass(tmp));
                mapBoundary.addPosition(tmp);
            }
        }
    }




}

package agh.cs.lab7;
import agh.cs.lab2.*;
import java.util.TreeSet;
import java.util.Comparator;


public class MapBoundary implements IPositionChangeObserver{

    private TreeSet<Vector2d> xPos = new TreeSet<>(Comparator.comparing(v -> v.x));
    private TreeSet<Vector2d> yPos = new TreeSet<>(Comparator.comparing(v -> v.y));

    public void addPosition(Vector2d position) {
        xPos.add(position);
        yPos.add(position);
    }

    public void removePosition(Vector2d position){
        xPos.remove(position);
        yPos.remove(position);
    }

    public Vector2d getLowerLeft(){
        return xPos.first().lowerLeft(yPos.first());
    }

    public Vector2d getUpperRight(){
        return xPos.last().upperRight(yPos.last());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        if ((newPosition.x < xPos.first().x ) ||  (newPosition.x > xPos.last().x ) ||
                (newPosition.y<yPos.first().y) || (newPosition.y >yPos.last().y )){
            this.addPosition(newPosition);
            this.removePosition(oldPosition);
        }

    }
}

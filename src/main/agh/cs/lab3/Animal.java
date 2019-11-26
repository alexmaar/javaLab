package agh.cs.lab3;
import agh.cs.lab2.*;
import agh.cs.lab2.MapDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.IMapElement;
import agh.cs.lab7.*;
import java.util.LinkedList;
import java.util.List;


public class Animal implements IMapElement {
    private MapDirection orientation= MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(){
       super();
    }

    public Animal(IWorldMap map){
       this.map=map;

    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position=initialPosition;
    }



    public void move(MoveDirection direction){
        switch(direction) {
            case RIGHT:
                orientation = this.orientation.next();
                break;
            case LEFT:
                orientation = this.orientation.previous();
                break;
            case FORWARD:
            case BACKWARD:
                Vector2d tmp = this.orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD) tmp=tmp.opposite();
                Vector2d newPos = this.position.add(tmp);
                if(map.canMoveTo(newPos)) {
                    positionChanged(this.position, tmp);
                    this.position = newPos;
                }

                break;

        }

        }

    @Override
    public String toString() {
       // return String.format("orientacja : %s \npozycja : %s", orientation.toString(), position.toString());
        String sss=this.orientation.name();
        return sss.charAt(0)+"";
    }

    public MapDirection getOrientation (){
        return this.orientation;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);

    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);

    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){

        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);

        }
    }
}
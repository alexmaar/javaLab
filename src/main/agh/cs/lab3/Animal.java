package agh.cs.lab3;
import agh.cs.lab2.*;


public class Animal {
    private MapDirection orientation= MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT:
                orientation=orientation.next();
                break;
            case LEFT:
                orientation=orientation.previous();
                break;
            case FORWARD:
                switch(orientation) {
                    case NORTH:
                        position = new Vector2d(position.x, position.y + 1 <= 4 ? position.y +1 : position.y);
                        break;
                    case SOUTH:
                        position=new Vector2d(position.x, position.y -1 >= 0 ? position.y -1 : position.y);
                        break;
                    case EAST:
                        position=new Vector2d(position.x +1 <= 4 ? position.x +1 : position.x,position.y);
                        break;
                    case WEST:
                        position=new Vector2d(position.x -1 >= 0 ? position.x -1 : position.x, position.y);
                        break;
                }
                break;
            case BACKWARD:
                switch(orientation){
                    case NORTH:
                        position = new Vector2d(position.x, position.y - 1 >=0 ? position.y -1 : position.y);
                        break;
                    case SOUTH:
                        position=new Vector2d(position.x, position.y +1 <=4 ? position.y +1 : position.y);
                        break;
                    case EAST:
                        position=new Vector2d(position.x -1 >=0 ? position.x -1 : position.x,position.y);
                        break;
                    case WEST:
                        position=new Vector2d(position.x +1 <= 4 ? position.x+1 : position.x, position.y);
                        break;

                }
                break;

        }
    }


   /* public String toString(){
        return "orientacja : " + orientation.toString() + " \n pozycja : " + position.toString();
    } */

    @Override
    public String toString() {
        return String.format("orientacja : %s \npozycja : %s", orientation.toString(), position.toString());
    }
}
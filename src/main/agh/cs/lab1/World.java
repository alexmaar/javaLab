package agh.cs.lab1;

public class World {

  /*  public static Direction change (String args){

            switch(args){
                case "f":
                    return Direction.forward;
                case  "b":
                    return Direction.backward;
                case "l":
                    return Direction.left;
                case "r":
                    return Direction.right;
                default:
                    return null;

            }

    } */

    public static void run(Direction[] args){

        for(int i=0; i<args.length; i++) {
            if(args[i]!=null){
                switch(args[i]) {
                    case forward:
                        System.out.println("Moving forward");
                        break;
                    case backward:
                        System.out.println("Moving backward");
                        break;
                    case left:
                        System.out.println("Moving left");
                        break;
                    case right:
                        System.out.println("Moving right");
                        break;
                }

            }
        }


    }

    public static void main(String[] args){

        Direction direct[]= new Direction[args.length];

        System.out.println("start");

        for (int i=0; i<args.length; i++) {
            direct[i] = Direction.change(args[i]);

        }

        try {
            run(direct);
        } catch(NullPointerException e){
            System.out.println("wrong");
        }

        System.out.println("stop");
    }
}

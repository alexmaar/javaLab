package agh.cs.lab3;
import java.util.Arrays;
import java.util.Objects;
import agh.cs.lab2.*;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) {
        MoveDirection[] res = new MoveDirection[args.length] ;
        int i=0;
        for (String direct : args){
            switch (direct) {
                case "f":
                case "forward":
                    res[i++] = MoveDirection.FORWARD;
                    break;

                case "b":
                case "backward":
                    res[i++] = MoveDirection.BACKWARD;
                    break;

                case "r":
                case "right":
                    res[i++] = MoveDirection.RIGHT;
                    break;

                case "l":
                case "left":
                    res[i++] = MoveDirection.LEFT;
                    break;

            }

        }

        return Arrays.copyOfRange(res,0,i);
    }
}
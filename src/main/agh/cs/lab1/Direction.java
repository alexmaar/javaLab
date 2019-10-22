package agh.cs.lab1;

public enum Direction {
    forward,
    backward,
    right,
    left;

    public static Direction change(String arg) {

        switch (arg) {
            case "f":
                return forward;
            case "b":
                return backward;
            case "l":
                return left;
            case "r":
                return right;
        }
        return null;

    }
}

package axiom;

public class South extends Direction{

    public Direction turnLeft() {
        return new East();
    }

    public Direction turnRight(){
        return new West();
    }
}

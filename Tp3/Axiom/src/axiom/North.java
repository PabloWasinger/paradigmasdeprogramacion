package axiom;

public class North extends Direction{

    public Direction turnLeft() {
        return new West();
    }

    public Direction turnRight(){
        return new East();
    }
}

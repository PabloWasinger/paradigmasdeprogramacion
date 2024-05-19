package axiom;

public class East extends Direction{

    public Direction turnLeft() {
        return new North();
    }

    public Direction turnRight(){
        return new South();
    }
}

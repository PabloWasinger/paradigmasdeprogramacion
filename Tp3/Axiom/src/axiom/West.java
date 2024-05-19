package axiom;

public class West extends Direction {

    public Direction turnLeft() {
        return new South();
    }

    public Direction turnRight(){
        return new North();
    }

}

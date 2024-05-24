package axiom;

class East extends DirectionControler {
    public Character heading() {
        return 'E';
    }

    public DirectionControler turnLeft() {
        return new North();
    }

    public DirectionControler turnRight() {
        return new South();
    }
}

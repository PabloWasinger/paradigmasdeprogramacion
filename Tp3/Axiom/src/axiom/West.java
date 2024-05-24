package axiom;

class West extends DirectionControler {
    public Character heading() {
        return 'W';
    }

    public DirectionControler turnLeft() {
        return new South();
    }

    public DirectionControler turnRight() {
        return new North();
    }

}

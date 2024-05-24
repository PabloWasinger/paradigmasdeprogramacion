package axiom;

class South extends DirectionControler {

    public Character heading() {
        return 'S';
    }

    public DirectionControler turnLeft() {
        return new East();
    }

    public DirectionControler turnRight() {
        return new West();
    }
}

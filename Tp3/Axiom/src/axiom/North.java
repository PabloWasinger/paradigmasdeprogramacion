package axiom;

class North extends DirectionControler {

    public Character heading() {
        return 'N';
    }

    public DirectionControler turnLeft() {
        return new West();
    }

    public DirectionControler turnRight() {
        return new East();
    }
}

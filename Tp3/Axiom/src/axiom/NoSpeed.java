package axiom;

class NoSpeed extends SpeedControler {

    public NoSpeed() {
        super(0, null);
    }
    SpeedControler decreaseSpeed(Probe probe) {
        throw new RuntimeException("Can't decrease speed when the axiom is stopped");
    }

    SpeedControler increaseSpeed() {
        return new LowSpeed(speed + 10, this);
    }

    void isMoving() {
        throw new RuntimeException("Can't deploy probe when the axiom is stopped");
    }
}

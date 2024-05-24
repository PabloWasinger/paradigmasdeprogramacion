package axiom;

class HighSpeed extends SpeedControler {

    public HighSpeed(int speed, SpeedControler previousControler) {
        super(speed, previousControler);
    }

    SpeedControler decreaseSpeed(Probe probe) {
        return previousSpeed;
    }

    SpeedControler increaseSpeed() {
        return new HighSpeed(speed + 10, this);
    }

    void isMoving() {
        return;
    }
}

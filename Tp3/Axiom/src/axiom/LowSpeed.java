package axiom;

class LowSpeed extends SpeedControler {

    public LowSpeed(int speed, SpeedControler previousSpeed) {
        super(speed, previousSpeed);
    }

    SpeedControler decreaseSpeed(Probe probe) {
        probe.stop();
        return previousSpeed;
    }

    SpeedControler increaseSpeed() {
        return new HighSpeed(speed + 10, this);
    }

    void isMoving() {
        return;
    }

}

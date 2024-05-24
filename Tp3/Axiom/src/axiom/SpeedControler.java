package axiom;

abstract class SpeedControler {

    protected int speed;
    protected SpeedControler previousSpeed;
    public SpeedControler(int speed, SpeedControler previousSpeed){
        this.speed = speed;
        this.previousSpeed = previousSpeed;
    }

    abstract SpeedControler decreaseSpeed(Probe probe);
    abstract SpeedControler increaseSpeed();

    abstract void isMoving();

    public int getSpeed(){
        return this.speed;
    }
}


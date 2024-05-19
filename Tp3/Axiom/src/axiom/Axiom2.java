package axiom;

public class Axiom2 {
    private Direction direction;
    private int speed;
    private Probe probe;

    protected Axiom2 increaseSpeed() {
        speed += 10;
        return this;
    }

    protected Axiom2 decreaseSpeed() {
        return this;
    }


    protected Axiom2 deployProbe() {
        probe = new DeployedProbe();
        return this;
    }


    protected Axiom2 retractProbe() {
        probe = new RetractedProbe();
        return this;
    }


    protected Axiom2 turnRight(){
        this.direction = direction.turnRight();
        return this;
    }


    protected Axiom2 turnLeft(){
        this.direction = direction.turnLeft();
        return this;
    }

    public Direction heading(){
        return this.direction;
    }

    public String probe(){
        return probe.state();
    }

    public int speed(){
        return this.speed;
    }
}

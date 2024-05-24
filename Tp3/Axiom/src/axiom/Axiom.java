package axiom;

import java.util.Stack;

public class Axiom {
    private DirectionControler direction = new North();
    private Probe probe = new RetractedProbe();

    private SpeedControler speedControler = new NoSpeed();



    public Axiom executeCommands(String parameters){

        return Command.matchCommands(parameters, this);
    }

    protected Axiom increaseSpeed() {
        speedControler = speedControler.increaseSpeed();
        return this;
    }

    protected Axiom decreaseSpeed() {
        speedControler = speedControler.decreaseSpeed(probe);
        return this;
    }


    protected Axiom deployProbe() {
        speedControler.isMoving();
        probe.canDeployProbe();
        probe = new DeployedProbe();
        return this;
    }

    protected Axiom retractProbe() {
        probe.canRetractProbe();
        probe = new RetractedProbe();
        return this;
    }

    protected Axiom turnRight(){
        probe.turnRight();
        this.direction = direction.turnRight();
        return this;
    }

    protected Axiom turnLeft(){
        probe.turnLeft();
        this.direction = direction.turnLeft();
        return this;
    }

    public Character heading(){
        return this.direction.heading();
    }

    public String probe(){
        return probe.state();
    }

    public int speed(){return speedControler.getSpeed();}

}

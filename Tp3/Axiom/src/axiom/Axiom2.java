package axiom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Axiom2 {
    private Direction direction = new North();
    private int speed;
    private Probe probe = new RetractedProbe();
    private List<Engine> engines = new ArrayList<>(Arrays.asList(new StoppedEngine()));


    public Axiom2 process(Character chars){
        switch (chars){
            case 'i':
                checkIncreaser();
                break;
            case 's':
                checkDecreaser();
                break;
            case 'l':
                canTurnLeft();
                break;
            case 'r':
                canTurnRight();
                break;
            case 'd':
                canDeployProbe();
                break;
            case 'f':
                canRetractProbe();
                break;
        }
        return this;
    }

    protected Axiom2 increaseSpeed() {
        speed += 10;
        engines.add(new RunningEngine());
        return this;
    }
    protected Axiom2 startEngine(){
        engines.add(new StartigEngine());
        speed = 10;
        return this;
    }

    protected void checkIncreaser(){
        Engine engine = engines.getLast();
        engine.increaseSpeed(this, probe);
    }

    protected void checkDecreaser(){
        Engine engine = engines.getLast();
        engines.removeLast();
        engine.decreaseSpeed(this, probe);
    }

    protected Axiom2 decreaseSpeed() {
        speed -= 10;
        return this;
    }

    protected void canDeployProbe(){
        Engine engine = engines.getLast();
        engine.canDeployProbe(this, probe);
    }
    protected Axiom2 deployProbe() {
        probe = new DeployedProbe();
        return this;
    }

    protected void canRetractProbe(){
        probe.retractProbe(this);
    }
    protected Axiom2 retractProbe() {
        probe = new RetractedProbe();
        return this;
    }

    protected void canTurnRight(){
        probe.turnRight(this);
    }
    protected Axiom2 turnRight(){
        this.direction = direction.turnRight();
        return this;
    }

    protected void canTurnLeft(){
        probe.turnLeft(this);
    }
    protected Axiom2 turnLeft(){
        this.direction = direction.turnLeft();
        return this;
    }

    public Character heading(){
        return this.direction.heading();
    }

    public String probe(){
        return probe.state();
    }

    public int speed(){
        return this.speed;
    }
}

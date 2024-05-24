package axiom;

public abstract class Probe {
    //Probe probe = new RetractedProbe();
    String state;

    protected String state(){
        return this.state;
    }
    protected abstract void turnLeft();

    protected abstract void turnRight();

    protected abstract void canDeployProbe();

    protected abstract void canRetractProbe();

    protected abstract void stop();
}

package axiom;

public abstract class Probe {

    String state;

    protected String state(){
        return this.state;
    }
    protected abstract void turnLeft(Axiom2 axiom);

    protected abstract void turnRight(Axiom2 axiom);

    protected abstract void deployProbe(Axiom2 axiom);

    protected abstract void retractProbe(Axiom2 axiom);

    protected abstract void stop(Axiom2 axiom);
}

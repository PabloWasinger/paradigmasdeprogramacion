package axiom;

public abstract class Probe {

    String state;

    protected String state(){
        return this.state;
    }
    protected abstract void turnLeft(Axiom axiom);

    protected abstract void turnRight(Axiom axiom);

    protected abstract void deployProbe(Axiom axiom);

    protected abstract void retractProbe(Axiom axiom);

    protected abstract void stop(Axiom axiom);
}

package axiom;

public abstract class AxiomParent {

    protected int speed;
    protected Object compass;
    public AxiomParent (){

    }

    protected AxiomParent increaseSpeed() {

        speed += 10;
        return this;
    }

    protected abstract AxiomParent decreaseSpeed();

    protected abstract AxiomParent deployProbe();

    protected abstract AxiomParent retractProbe();

    protected abstract AxiomParent rotate(char command);

}

package axiom;

public class AxiomWithProbeDeployed extends AxiomParent {

    public AxiomWithProbeDeployed(int speed, Object compass) {
        this.speed = 10;
        this.compass = compass;
    }

    @Override
    protected AxiomParent decreaseSpeed() {

        if (speed == 10) {
            throw new RuntimeException("Can't stop Axiom when probe is deployed");
        }
        else{
            speed -= 10;
        }
        return this;
    }

    @Override
    protected AxiomParent deployProbe() {
        throw new RuntimeException("Can't deploy probe when probe is deployed");
    }

    @Override
    protected AxiomParent retractProbe() {
        return new AxiomWithProbeRetracted();
    }

    @Override
    protected AxiomParent rotate(char command) {
        throw new RuntimeException("Can't rotate Axiom when probe is deployed");
    }
}

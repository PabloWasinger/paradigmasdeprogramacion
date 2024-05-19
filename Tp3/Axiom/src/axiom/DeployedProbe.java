package axiom;

public class DeployedProbe extends Probe {

    protected DeployedProbe() {
        this.state = "deployed";
    }

    protected void turnLeft(Axiom2 axiom) {
        throw new RuntimeException("probe deployed");
    }

    protected void turnRight(Axiom2 axiom) {
        throw new RuntimeException("probe deployed");
    }

    protected void deployProbe(Axiom2 axiom) {
        throw new RuntimeException("Can't deploy probe when probe is deployed");
    }

    protected void retractProbe(Axiom2 axiom) {
        axiom.retractProbe();
    }

    protected void stop(Axiom2 axiom){
            throw new RuntimeException("Can't stop when probe is deployed");
    }

}

package axiom;

public class DeployedProbe extends Probe {

    protected DeployedProbe() {
        this.state = "deployed";
    }

    protected void turnLeft() {
        throw new RuntimeException("probe deployed");
    }

    protected void turnRight() {
        throw new RuntimeException("probe deployed");
    }

    protected void canDeployProbe() {
        throw new RuntimeException("Can't deploy probe when probe is deployed");
    }

    protected void canRetractProbe() {
        return;
    }

    protected void stop(){
            throw new RuntimeException("Can't stop when probe is deployed");
    }

}

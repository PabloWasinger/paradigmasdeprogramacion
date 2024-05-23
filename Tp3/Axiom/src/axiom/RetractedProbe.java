package axiom;

public class RetractedProbe extends Probe{

        protected RetractedProbe(){
            this.state = "retracted";
        }
        protected void turnLeft(Axiom axiom){
            axiom.turnLeft();
        }

        protected  void turnRight(Axiom axiom){
            axiom.turnRight();
        }

        protected  void deployProbe(Axiom axiom){
            axiom.deployProbe();

        }

        protected  void retractProbe(Axiom axiom){
            throw new RuntimeException("Can't retract probe when probe is not deployed");
        }

        protected void stop(Axiom axiom){
            axiom.decreaseSpeed();
        }




}

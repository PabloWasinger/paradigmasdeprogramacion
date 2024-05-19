package axiom;

public class RetractedProbe extends Probe{

        protected RetractedProbe(){
            this.state = "retracted";
        }
        protected void turnLeft(Axiom2 axiom){
            axiom.turnLeft();
        }

        protected  void turnRight(Axiom2 axiom){
            axiom.turnRight();
        }

        protected  void deployProbe(Axiom2 axiom){
            axiom.deployProbe();

        }

        protected  void retractProbe(Axiom2 axiom){
            throw new RuntimeException("Can't retract probe when probe is not deployed");
        }

        protected void stop(Axiom2 axiom){
            axiom.decreaseSpeed();
        }




}

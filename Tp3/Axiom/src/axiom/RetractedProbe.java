package axiom;

public class RetractedProbe extends Probe{

        protected RetractedProbe(){
            this.state = "retracted";
        }
        protected void turnLeft(){
            return;
        }

        protected  void turnRight(){
            return;
        }

        protected  void canDeployProbe(){
            return;

        }

        protected  void canRetractProbe(){
            throw new RuntimeException("Can't retract probe when probe is not deployed");
        }

        protected void stop(){
            return;
        }




}

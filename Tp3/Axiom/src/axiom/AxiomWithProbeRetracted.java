package axiom;

public class AxiomWithProbeRetracted extends AxiomParent{

        public AxiomWithProbeRetracted(int speed, Object compass) {
            this.speed = speed;
            this.compass = compass;
        }

        @Override
        protected AxiomParent decreaseSpeed() {
            if (speed == 0){
                throw new RuntimeException("Can't decrease speed when probe is retracted");
            }
            else{
                speed -= 10;
            }
            return this;
        }

        @Override
        protected AxiomParent deployProbe() {
            return new AxiomWithProbeDeployed(this.speed, this.compass);
        }

        @Override
        protected AxiomParent retractProbe() {
            throw new RuntimeException("Can't retract probe when probe is retracted");
        }

        @Override
        protected AxiomParent rotate(char command) {
            this.compass == compass.rotate(command);
            return this;
        }
}

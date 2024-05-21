package axiom;

abstract class Engine {
    abstract void decreaseSpeed(Axiom2 axiom, Probe probe);
    abstract void increaseSpeed(Axiom2 axiom, Probe probe);

    abstract void canDeployProbe(Axiom2 axiom, Probe probe);
}

    class StoppedEngine extends Engine {
        void decreaseSpeed(Axiom2 axiom, Probe probe) {
            throw new RuntimeException("Can't decrease speed when the axiom is stopped");
        }

        void increaseSpeed(Axiom2 axiom, Probe probe) {
            axiom.startEngine();
        }

        void canDeployProbe(Axiom2 axiom, Probe probe) {
            throw new RuntimeException("Can't deploy probe when the axiom is stopped");
        }
    }

    class StartigEngine extends Engine {
        void decreaseSpeed(Axiom2 axiom, Probe probe) {
            probe.stop(axiom);
        }

        void increaseSpeed(Axiom2 axiom, Probe probe) {
            axiom.increaseSpeed();
        }

        void canDeployProbe(Axiom2 axiom, Probe probe){
            probe.deployProbe(axiom);
        }

    }

    class RunningEngine extends Engine {

        void decreaseSpeed(Axiom2 axiom, Probe probe) {
            axiom.decreaseSpeed();
        }

        void increaseSpeed(Axiom2 axiom, Probe probe) {
            axiom.increaseSpeed();
        }

        void canDeployProbe(Axiom2 axiom, Probe probe){
            probe.deployProbe(axiom);
        }
    }

package axiom;

abstract class Engine {
    abstract void decreaseSpeed(Axiom2 axiom, Probe probe);
    abstract void increaseSpeed(Axiom2 axiom, Probe probe);

    abstract void canDeployProbe(Axiom2 axiom, Probe probe);
}

    class StoppedEngine extends Engine {
        void decreaseSpeed(Axiom2 axiom, Probe probe) {
            throw new RuntimeException("No se puede disminuir la velocidad cuando el motor está detenido");
        }

        void increaseSpeed(Axiom2 axiom, Probe probe) {
            axiom.startEngine();
        }

        void canDeployProbe(Axiom2 axiom, Probe probe) {
            throw new RuntimeException("No se puede soltar la sonda cuando el motor esta detenido");
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

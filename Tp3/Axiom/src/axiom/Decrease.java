package axiom;

public abstract class Decrease {
    abstract Axiom2 decreaseSpeed(Axiom2 axiom);
}

class LastDecrease extends Decrease{

    Axiom2 decreaseSpeed(Axiom2 axiom) {
        throw new RuntimeException("no puede bajar la velocidad");
    }
}

class RegularDecrease extends Decrease{

    Axiom2 decreaseSpeed(Axiom2 axiom) {
        return null;
    }
}

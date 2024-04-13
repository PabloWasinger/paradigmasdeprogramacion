package anillo;

public class EmptyNode extends Node{
    @Override
    protected Node add(Object cargo) {
        NonEmptyNode nuevo = new SingleNode(cargo);
        nuevo.setNext(nuevo);
        nuevo.setPrevious(nuevo);
        return nuevo;
    }

    @Override
    protected Node next() {
        throw new RuntimeException(Ring.emptyRingError);
    }

    @Override
    protected Node current() {
        throw new RuntimeException(Ring.emptyRingError);
    }

    @Override
    protected Node remove() {
        throw new RuntimeException(Ring.emptyRingError);
    }
}

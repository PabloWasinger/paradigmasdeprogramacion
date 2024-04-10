package anillo;

public abstract class Node {
    protected Object value;
    protected Node next;
    // Setters y Getters de next y value

    protected Node setValue(Object value) {
        this.value = value;
        return this;
    }
    protected abstract Node getNext();
    protected abstract Object getValue();
    protected abstract Node setNext(Node next);

}


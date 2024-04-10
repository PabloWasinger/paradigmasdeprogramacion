package anillo;

public abstract class Node {
    protected Object value;
    protected Node next;
    // Setters y Getters de next y value
    protected Node getNext() {
        return next;
    }

    protected Object getValue() {
        return value;
    }

    protected void setValue(Object value){
        this.value = value;

    }

    protected abstract void setNext(Node next);
}


package anillo;

public abstract class Node {
    protected Object value;
    protected Node next;
    // Setters y Getters de next y value
    protected void setNext(Node next) {
        this.next = next;
    }
    protected abstract Node getNext();
    protected abstract Object getValue();
    protected abstract Node getNode(Node optionalnode);
    protected abstract Node removeNode(Node previous_node);
}


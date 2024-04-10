package anillo;

public class NonEmptyNode extends Node {
    protected Node setNext(Node next) {
        this.next = next;
        return this;
    }

    protected Node getNext() {
        return this.next;
    }

    protected Object getValue() {
        return this.value;
    }
}

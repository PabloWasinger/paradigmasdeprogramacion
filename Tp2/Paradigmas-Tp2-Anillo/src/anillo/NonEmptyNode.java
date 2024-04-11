package anillo;

public class NonEmptyNode extends Node {


    protected NonEmptyNode(Object value) {
        this.value = value;
    }
    protected Node getNext() {
        return this.next;
    }

    protected Object getValue() {
        return this.value;
    }

    protected Node getNode(Node optionalnode) {
        return this;
    }

    protected Node removeNode(Node previousNode) {
        previousNode.setNext(this.next);
        return this.next == this ? new EmptyNode() : this.next;
    }

}

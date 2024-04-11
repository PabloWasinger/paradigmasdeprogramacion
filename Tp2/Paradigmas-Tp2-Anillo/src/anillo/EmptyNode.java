package anillo;

public class EmptyNode extends Node {
    public EmptyNode() {
        this.value = null;
        this.next = null;
    }


    protected Node getNext() {
        throw new RuntimeException("Ring Vacío");
    }

    protected Object getValue() {
        throw new RuntimeException("Ring Vacío");
    }

    protected Node getNode(Node optionalnode) {
        return optionalnode;
    }

    protected Node removeNode(Node previous_node) {
        throw new RuntimeException("Ring vacío");
    }
}

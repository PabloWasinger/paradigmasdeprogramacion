package anillo;

public class EmptyNode extends Node {
    public EmptyNode() {
        this.value = null;
        this.next = null;
    }
    
    protected Node setNext(Node next) {
        Node nonempty = new NonEmptyNode();
        nonempty.setNext(nonempty);
        return nonempty;

    }

    protected Node getNext() {
        throw new RuntimeException("Ring Vacío");
    }

    protected Object getValue() {
        throw new RuntimeException("Ring Vacío");
    }


}

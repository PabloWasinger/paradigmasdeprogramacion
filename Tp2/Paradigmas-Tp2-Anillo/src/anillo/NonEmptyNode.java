package anillo;

public class NonEmptyNode extends Node {
    protected Object cargo;
    private NonEmptyNode next;
    private NonEmptyNode previous;
//    public NonEmptyNode(Object cargo){
//        this.cargo = cargo;
//    }

    public NonEmptyNode(Object cargo, NonEmptyNode next, NonEmptyNode previous){
        this.cargo = cargo;
        this.next = next;
        this.previous = previous;
    }
    @Override
    protected Node add(Object cargo) {
        NonEmptyNode new_node = new NonEmptyNode(cargo, this, this.previous);
        //new_node.setNext(this);
        //new_node.setPrevious(this.previous);
        this.previous.setNext(new_node);
        this.previous = new_node;
        return new_node;
    }

    @Override
    protected Node next() {
        return this.next;
    }

    @Override
    protected Object current() {
        return this.cargo;
    }

    @Override
    protected Node remove() {
        this.previous.setNext(this.next);
        this.next.setPrevious(this.previous);
        return this.next(); //this.previous
    }

    protected void setNext(NonEmptyNode next) {
        this.next = next;
    }

    protected void setPrevious(NonEmptyNode previous) {
        this.previous = previous;
    }

}

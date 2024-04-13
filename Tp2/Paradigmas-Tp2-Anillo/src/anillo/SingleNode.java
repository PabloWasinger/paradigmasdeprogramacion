package anillo;

public class SingleNode extends NonEmptyNode {
    public SingleNode(Object cargo){
        super(cargo, null, null);
        this.setNext(this);
        this.setPrevious(this);
    }
    @Override
    protected Node add(Object cargo) {
        NonEmptyNode new_node = new NonEmptyNode(cargo, this, this);
        NonEmptyNode copyNode = new NonEmptyNode(this.cargo, new_node, new_node);
        new_node.setNext(copyNode);
        new_node.setPrevious(copyNode);
        return new_node;
    }
    @Override
    protected Node remove() {
        return new EmptyNode();
    }
}

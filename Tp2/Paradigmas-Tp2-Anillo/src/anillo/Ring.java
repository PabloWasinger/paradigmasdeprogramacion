package anillo;

public class Ring {
    static public String emptyRingError = "Ring Vacío";
    public Node current_node;
    public Ring(){
        current_node = new EmptyNode();
    }

    public Ring next() {
         current_node = current_node.next();
        return this;
    }


    public Object current() {
        return current_node.current();
    }

    public Ring add(Object cargo) {
        current_node = current_node.add(cargo);
        return this;
    }


    public Ring remove() {
        if (current_node == current_node.next()){
            current_node = new EmptyNode();
            return this;
        }
        current_node = current_node.remove();
        return this;
    }


}
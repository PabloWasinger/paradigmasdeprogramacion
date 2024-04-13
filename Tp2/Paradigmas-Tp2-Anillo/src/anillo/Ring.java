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
        Node new_node = new NonEmptyNode(cargo);
        current_node = current_node.getNode(new_node); // Linea esencial, Si es un empty node, devuelve el nuevo nonemprty creado, si es un nonempty, se devuelve a el mismo
        Node node_to_connect = current_node;
        iterate_node(node_to_connect);
        current_node.setNext(new_node);
        new_node.setNext(node_to_connect);
        current_node = new_node;

        return this;
    }


    public Ring remove() {
        Node node_to_remove = current_node;
        iterate_node(node_to_remove);
        current_node = node_to_remove.removeNode(current_node);
        return this;
    }


}
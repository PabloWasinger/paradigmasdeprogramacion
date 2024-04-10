package anillo;

public class Ring {
    public Node current_node;
    public Ring(){
        current_node = new EmptyNode();
    }

    public Ring next() {
        current_node = current_node.getNext();
        return this;
    }


    public Object current() {
        return current_node.getValue();
    }

    public Ring add(Object cargo) {
        Node new_node = new Node(cargo, null);

        if (current_node == null) {
            current_node = new_node;
            current_node.setNext(current_node);
            return this;
        }
        else{
            Node node_to_connect = current_node;
            iterate_node(node_to_connect);
            Node previous_node = current_node;
            current_node.setNext(new_node);
            new_node.setNext(node_to_connect);
            current_node = new_node;
        }
        return this;
    }


    public Ring remove() {
        if (current_node.getNext() == current_node) {
            current_node = null;
            return this;
        }

        Node node_to_remove = current_node;
        iterate_node(node_to_remove);
        Node next_node = node_to_remove.getNext();
        current_node.setNext(next_node);
        current_node = next_node;
        return this;
    }

    private void iterate_node(Node end_node) {
        while (current_node.getNext() != end_node) {
            this.next();
        }
    }


}
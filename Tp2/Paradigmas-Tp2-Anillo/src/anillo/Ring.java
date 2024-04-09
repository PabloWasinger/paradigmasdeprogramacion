package anillo;

public class Ring {
    public Node current_node;


    public Ring next() {
        current_node = current_node.getNext();
        return this;
    }


    public Object current() {
        return current_node.getValue();
    }

    public Ring add(Object cargo) {
        // Ver como ponerle el next al nuevo nodo
        Node new_node = new Node(cargo, null);

        if (current_node == null) {
            current_node = new_node;
            current_node.setNext(current_node);
            return this;
        }
        else{
            current_node.setNext(new_node);
        }
        return null;
    }

    public Ring remove() {
        return null;
    }


    private static class Node {
        private Object value;
        private Node next;
        private Node(Object value, Node next) {
            this.value = value;
            this.next = next;

        }

        // Setters y Getters de next y value
        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private Object getValue() {
            return value;
        }

        private void setValue(Object value) {
            this.value = value;
        }
    }

}
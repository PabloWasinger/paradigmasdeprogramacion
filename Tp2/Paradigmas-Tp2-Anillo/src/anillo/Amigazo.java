package anillo;

public class Amigazo extends Node {
    public Amigazo(Object value, Node next) {
        this.value = value;
        this.next = next;
    }
    protected void setNext(Node next) {
        this.next = next;
    }
}

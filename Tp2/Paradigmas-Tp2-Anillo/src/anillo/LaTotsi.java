package anillo;

public class LaTotsi extends Node {
    public LaTotsi() {
        this.value = null;
        this.next = null;
    }
    
    protected void setNext(Node next) {
        this.next = this;
    }
}

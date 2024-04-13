package anillo;

public abstract class Node {

    protected abstract Node add(Object cargo);
    protected abstract Node next();
    protected abstract Object current();
    protected abstract Node remove();

}

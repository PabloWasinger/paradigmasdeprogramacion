package axiom;

interface Process {
     abstract boolean canHandle(Character command);


    abstract void handle(Axiom2 axiom);

}

class SubirVelocidad implements Process {

    public boolean canHandle(Character command) {
        return command.equals('i');
    }
    public void handle(Axiom2 axiom) {
        axiom.checkIncreaser();
    }

}

class StringS implements Process {

    public boolean canHandle(Character command) {
        return command.equals('s');
    }

    public void handle(Axiom2 axiom) {
        axiom.checkDecreaser();
    }

}

class StringL implements Process {

    public boolean canHandle(Character command) {
        return command.equals('l');
    }

    public void handle(Axiom2 axiom) {
        axiom.canTurnLeft();
    }

}

class StringR implements Process {

    public boolean canHandle(Character command) {
        return command.equals('r');
    }

    public void handle(Axiom2 axiom) {
        axiom.canTurnRight();
    }

}

class StringD implements Process {

    public boolean canHandle(Character command) {
        return command.equals('d');
    }

    public void handle(Axiom2 axiom) {
        axiom.canDeployProbe();
    }

}

class StringF implements Process {

    public boolean canHandle(Character command) {
        return command.equals('f');
    }

    public void handle(Axiom2 axiom) {
        axiom.canRetractProbe();
    }

}

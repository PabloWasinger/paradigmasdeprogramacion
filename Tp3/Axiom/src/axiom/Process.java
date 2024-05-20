package axiom;

import java.util.Locale;

interface Process {
     abstract boolean canHandle(Character command);


    abstract void handle(Axiom2 axiom);

    abstract Process next();
}

class StringI implements Process {

    public boolean canHandle(Character command) {
        boolean bul = command.equals('i');
        return bul;
    }


    public void handle(Axiom2 axiom) {
        axiom.checkIncreaser();
    }
    public Process next() {
        return new StringS();
    }
}

class StringS implements Process {

    public boolean canHandle(Character command) {
        return command.equals('s');
    }

    public void handle(Axiom2 axiom) {
        axiom.checkDecreaser();
    }
    public Process next() {
        return new StringL();
    }
}

class StringL implements Process {

    public boolean canHandle(Character command) {
        return command.equals('l');
    }

    public void handle(Axiom2 axiom) {
        axiom.canTurnLeft();
    }
    public Process next() {
        return new StringR();
    }
}

class StringR implements Process {

    public boolean canHandle(Character command) {
        return command.equals('r');
    }

    public void handle(Axiom2 axiom) {
        axiom.canTurnRight();
    }
    public Process next() {
        return new StringD();
    }
}

class StringD implements Process {

    public boolean canHandle(Character command) {
        return command.equals('d');
    }

    public void handle(Axiom2 axiom) {
        axiom.canDeployProbe();
    }
    public Process next() {
        return new StringF();
    }
}

class StringF implements Process {

    public boolean canHandle(Character command) {
        return command.equals('f');
    }

    public void handle(Axiom2 axiom) {
        axiom.canRetractProbe();
    }
    public Process next() {
        return new StringI();
    }
}

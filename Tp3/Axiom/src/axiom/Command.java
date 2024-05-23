package axiom;

abstract class Command {
     abstract boolean checkCommand(Character command);


    abstract void executeCommand(Axiom axiom);

}

class CommandIncreaseSpeed extends Command {

    public boolean checkCommand(Character command) {
        return command.equals('i');
    }
    public void executeCommand(Axiom axiom) {
        axiom.canIncreaseSpeed();
    }

}

class CommandDecreaseSpeed extends Command {

    public boolean checkCommand(Character command) {
        return command.equals('s');
    }

    public void executeCommand(Axiom axiom) {
        axiom.canDecreaseSpeed();
    }

}

class CommandTurnLeft extends Command {

    public boolean checkCommand(Character command) {
        return command.equals('l');
    }

    public void executeCommand(Axiom axiom) {
        axiom.canTurnLeft();
    }

}

class CommandTurnRight extends Command {

    public boolean checkCommand(Character command) {
        return command.equals('r');
    }

    public void executeCommand(Axiom axiom) {
        axiom.canTurnRight();
    }

}

class CommandDeployProbe extends Command {

    public boolean checkCommand(Character command) {
        return command.equals('d');
    }

    public void executeCommand(Axiom axiom) {
        axiom.canDeployProbe();
    }

}

class CommandRetractProbe extends Command {

    public boolean checkCommand(Character command) {
        return command.equals('f');
    }

    public void executeCommand(Axiom axiom) {
        axiom.canRetractProbe();
    }

}

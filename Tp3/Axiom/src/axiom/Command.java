package axiom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Command {
    private static List<Command> commands = new ArrayList<>(Arrays.asList(new CommandIncreaseSpeed(), new CommandDecreaseSpeed(), new CommandTurnLeft(), new CommandTurnRight(), new CommandDeployProbe(), new CommandRetractProbe()));

    public static Axiom matchearComandos(String parameters, Axiom axiom) {
        parameters.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(ch -> Command.asociatedFunction(ch, axiom));
        return axiom;
    }
    public static void asociatedFunction(char chars, Axiom axiom){
        commands.stream()
                .filter(command -> command.checkCommand(chars))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid command"))
                .executeCommand(axiom);

    }


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

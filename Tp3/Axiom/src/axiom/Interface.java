package axiom;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.HashMap;

public class Interface {

    private HashMap<Character, Executable> commands = new HashMap<Character, Executable>();


    private void initCommands(Axiom2 axiom) {
        commands.put('s', () -> axiom.decreaseSpeed());
        commands.put('i', :increaseSpeed);
        commands.put('d', this::deployProbe);
        commands.put('f', this::retractProbe);
        commands.put('r', () -> rotate('r'));
        commands.put('l', () -> rotate('l'));
    }





    private Axiom2 process(String comando){
        comando.stream();
        return new Axiom2();
    }
}

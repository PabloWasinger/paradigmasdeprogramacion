package axiom;

import java.lang.reflect.Executable;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Axiom {
    private int speed = 0;
    private char heading = 'N';
    private String probe = "not deployed";
    private Hashtable<Character, Executable> commands =  new Hashtable<Character, Executable>();
    private List<Character> directions = List.of('N', 'E', 'S', 'W');

    public int speed() {
        return speed;
    }

    public char heading() {
        return heading;
    }

    public String probe() {
        return probe;
    }

    public Axiom process(char command) {
        if (command == 's') {
            this.decreaseSpeed();
        } else
        if (command == 'i') {
            this.increaseSpeed();
        }

        if (command == 'd') {
            this.deployProbe();
        }
        return this;
    }


    public Axiom increaseSpeed() {
        speed += 10;
        return this;
    }


    public Axiom decreaseSpeed () {

        if (speed == 0) {
            throw new RuntimeException("parado");
        }
        else {
            speed -= 10;
        }
        return this;
    }

    public Axiom deployProbe() {
        if (speed == 0){
            throw new RuntimeException("too slow");
        }

        else;
        probe = "deployed";


        return this;
    }

    public char rotate(char direction) {
        if (direction == 'l') {
            return 'E';
        }
        return 'N';
    }
}


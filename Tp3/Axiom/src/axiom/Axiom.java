package axiom;

import java.lang.reflect.Executable;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

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
        } else if (command == 'i') {
            this.increaseSpeed();
        }

        if (command == 'd') {
            this.deployProbe();
        } else if (command == 'f') {
            this.retractProbe();
        }
        if (command == 'r' || command == 'l') {
            this.rotate(command);
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
        else if (speed == 10 && Objects.equals(probe, "deployed")) {
            throw new RuntimeException("Can't stop Axiom when probe is deployed");
        }
        else {
            speed -= 10;
        }
        return this;
    }

    public Axiom deployProbe() {
        if (speed == 0 ){
            throw new RuntimeException("too slow");
        }

        else if (Objects.equals(probe, "deployed")) {
            throw new RuntimeException("Can't deploy probe when probe is deployed");
        }

        else {
            probe = "deployed";
        }

        return this;
    }

    public Axiom retractProbe() {
        if (Objects.equals(probe, "not deployed")) {
            throw new RuntimeException("Can't retract probe when probe is not deployed");
        }
        else {
            probe = "not deployed";
        }
        return this;
    }

    public char rotate(char direction) {
        if (Objects.equals(probe, "deployed")){
            throw new RuntimeException("probe deployed");
        }
        else{
            if (direction == 'l') {
                heading = directions.get((directions.indexOf(heading) + 3) % 4);
            }
            else{
                heading = directions.get((directions.indexOf(heading) + 1) % 4);
            }
        }
        return heading;
    }
}


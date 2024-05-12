package axiom;

public class Axiom {
    private int speed = 0;
    private char heading = 'N';
    private string probe = "not deployed"


    public int speed() {
        return speed;
    }

    public char heading() {
        return heading;
    }

    public string probe() {
        return probe;
    }

    public Axiom process(char command) {
        if (command == 's') {
            this.decreaseSpeed();
        } else
        if (command == 'i') {
            this.increasespeed();
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
    }

        return this;
}

public char rotate(char direction) {
    if (direction == 'l') {
        return 'E';
    }
    return 'N';
}
}

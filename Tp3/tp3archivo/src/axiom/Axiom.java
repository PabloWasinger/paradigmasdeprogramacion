package axiom;

public class Axiom {
    private int speed = 0;
    private char heading = 'N';

    public int speed() {
        return speed;
    }
    public char heading() {
        return heading;
    }

    public Axiom process(char command) {
        if (command == 's') {
            if (speed == 0){

            }
        }

        if(command == 'd'){
            if (speed == 0){
                throw new RuntimeException("too slow");
            }
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

package axiom;

import java.util.Stack;

public class Axiom {
    private Direction direction = new North();
    private int speed;
    private Probe probe = new RetractedProbe();
    private Stack<Engine> engines = new Stack<Engine>() {{ push(new StoppedEngine()); }};
//    private List<Command> commands = new ArrayList<>(Arrays.asList(new CommandIncreaseSpeed(), new CommandDecreaseSpeed(), new CommandTurnLeft(), new CommandTurnRight(), new CommandDeployProbe(), new CommandRetractProbe()));


//    public Axiom process(String parameters){
//            parameters.chars()
//                    .mapToObj(i -> (char) i)
//                    .forEach(this::asociatedFunction);
//        return this;
//    }
//
//    public void asociatedFunction(char chars){
//        commands.stream()
//                .filter(command -> command.checkCommand(chars))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Invalid command"))
//                .executeCommand(this);
//
//    }
    public Axiom process(String parameters){

        return Command.matchearComandos(parameters, this);
    }


    protected Axiom increaseSpeed() {
        speed += 10;
        engines.add(new RunningEngine());
        return this;
    }
    protected Axiom startEngine(){
        engines.add(new StartigEngine());
        speed = 10;
        return this;
    }

    protected void canIncreaseSpeed(){
        Engine engine = engines.getLast();
        engine.increaseSpeed(this, probe);
    }

    protected void canDecreaseSpeed(){
        Engine engine = engines.pop();
        engine.decreaseSpeed(this, probe);
    }

    protected Axiom decreaseSpeed() {
        speed -= 10;
        return this;
    }

    protected void canDeployProbe(){
        Engine engine = engines.getLast();
        engine.canDeployProbe(this, probe);
    }
    protected Axiom deployProbe() {
        probe = new DeployedProbe();
        return this;
    }

    protected void canRetractProbe(){
        probe.retractProbe(this);
    }
    protected Axiom retractProbe() {
        probe = new RetractedProbe();
        return this;
    }

    protected void canTurnRight(){
        probe.turnRight(this);
    }

    protected Axiom turnRight(){
        this.direction = direction.turnRight();
        return this;
    }

    protected void canTurnLeft(){
        probe.turnLeft(this);
    }
    protected Axiom turnLeft(){
        this.direction = direction.turnLeft();
        return this;
    }

    public Character heading(){
        return this.direction.heading();
    }

    public String probe(){
        return probe.state();
    }

    public int speed(){
        return this.speed;
    }

}

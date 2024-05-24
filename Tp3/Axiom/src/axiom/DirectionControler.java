package axiom;

abstract class DirectionControler {

    public abstract DirectionControler turnRight();

    public abstract Direction turnLeft();

    public abstract Character heading();
}

    class North extends Direction{

        public Character heading(){
            return 'N';
        }
        public Direction turnLeft() {
            return new West();
        }
        public Direction turnRight(){return new East(); }
    }


    class East extends Direction{
        public Character heading(){
            return 'E';
        }
        public Direction turnLeft() {
            return new North();
        }

        public  Direction turnRight(){
            return new South();
        }
    }


    class West extends Direction {
        public Character heading(){
            return 'W';
        }
        public Direction turnLeft() {
            return new South();
        }

        public  Direction turnRight(){
            return new North();
        }

    }


    class South extends Direction{

        public Character heading(){
            return 'S';
        }

        public Direction turnLeft() {
            return new East();
        }

        public  Direction turnRight(){
            return new West();
        }
    }



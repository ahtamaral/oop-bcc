public class Principal {

	public static void main(String[] args) {

        int intialC = 12;
        int intialL = 33;

        GPS gps = new GPS(intialC, intialL);
        Robot31 robot = new Robot31(1, gps);
        robot.printStudent();

        while(true)
        {
            robot.move(State.CLOCKWISE);
            System.out.println(robot.getGPS().printCoordinates());
        }
    }
}
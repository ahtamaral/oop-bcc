public class App {

	public static void main(String[] args) {

        int initialX = 37;
        int initialY = 33;

        GPS31 gps = new GPS31(initialX, initialY);
        Robot31 robot = new Robot31(31, gps);
        robot.printStudent();

        // Usar esses métodos para alterar estratégia do robô.
        // robot.stop();
        // robot.clockwise();
        // robot.counter_cw();
        // robot.alternating();

        while(true)
        {
            robot.move(robot.getState());
            System.out.println(robot.getGPS().printCoordinates());
        }
    }
}

public class App {

	public static void main(String[] args) {

        int initialX = 27;
        int initialY = 33;

        GPS31 gps = new GPS31(initialX, initialY);
        Robot31 robot = new Robot31(31, gps);
        robot.printStudent();

        // Usar esses métodos para alterar estratégia inicial do robô.
        // robot.stop();
        // robot.clockwise();
        // robot.counter_cw();
        robot.alternating();

        System.out.println("\nWorld dimensions: " + gps.getMaxX() + " x " + gps.getMaxY());
        System.out.println("Alternating point set to: (" + gps.getAlternatingX() + "," + gps.getAlternatingY() + ")");
        System.out.println("Initial robot state: " + robot.getState() + "\n");

        while(true)
        {
            robot.move(robot.getState());
            System.out.println(robot.getGPS().printCoordinates());
        }
    }
}

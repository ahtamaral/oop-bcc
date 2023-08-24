public class Principal {
	public static void main(String[] args) {
        // Move m1 = Move.UP;
        
        // if( m1 == Move.DOWN )
        //     System.out.print("Mensagem igual");
        // else            
        //     System.out.print("Mensagem diferente \n");

        // if( m1 == Move.UP )
        //     System.out.print("Mensagem igual");
        // else            
        //     System.out.print("Mensagem diferente");

        int intialC = 40;
        int intialL = 50;

        GPS gps = new GPS(intialC, intialL);
        Robot99 robot = new Robot99(1, gps);
        robot.printStudent();

    }
}
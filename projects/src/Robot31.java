import java.util.concurrent.TimeUnit;

public class Robot31 {
    
    private int id;
    private GPS gps;
    private String myName;
    private String myDRE;
    private State currentState;

    public Robot31(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
        this.myName = new String("Artur Henrique Teixeira do Amaral");
        this.myDRE = new String("122032113");
        this.currentState = State.STOP;
    }

    public void printStudent(){
        System.out.println("Autor");
        System.out.println("Nome: " + this.myName);
        System.out.println("Nome: " + this.myDRE);
    }

    public int getId() {
        return id;
    }

    public GPS getGPS() {
        return gps;
    }

    public void stop() {
        this.currentState = State.STOP;
    }

    public void clockwise() {
        this.currentState = State.CLOCKWISE;
    }

    public void counter_cw() {
        this.currentState = State.COUNTER_CW;
    }

    public void alternating() {
        this.currentState = State.ALTERNATING;
    }

    public void go_center() {
        this.currentState = State.GO_CENTER;
    }


    // Espera 0.5 segundo. Usado para dar visualização melhor no output da aplicação.
    private void waitStepTime(){
        try { Thread.sleep(500); } catch (InterruptedException ie) {Thread.currentThread().interrupt();}
    }

    // Função que implementa 1 passo do robô, dependendo do estado da sua variável Move.
    public void doStep(Move m) {
        
        if (m == Move.STOP){
            // System.out.println("a");
        } else
        if (m == Move.UP) {
            this.gps.setC(this.gps.getC()+1);
        } else
        if (m == Move.DOWN) {
            this.gps.setC(this.gps.getC()-1);
        } else
        if (m == Move.LEFT) {
            this.gps.setL(this.gps.getL()-1);
        } else
        if (m == Move.RIGHT) {
            this.gps.setL(this.gps.getL()+1);
        }
        waitStepTime();
    }

    // Função que implementa a estratégia do robô, dependendo da sua posição e do estado da sua variável State.
    public void move(State s) {

        gps = getGPS();

        if ( s == State.STOP){

                doStep(Move.STOP);

        } else {

            // Verificando se o robô está na borda; Se estiver, aplica estratégia. Senão, move-se constantemente à direita até chegar nela.
            if ( (gps.getL() == gps.getMaxL()) || (gps.getC() == gps.getMaxC()) || (gps.getL() == 0) || (gps.getC() == 0)  ) {
                System.out.println("Está na borda.");

                if (s == State.COUNTER_CW)
                {
                    if ((gps.getL() == gps.getMaxL()) && (gps.getC() > 0))
                    {
                        doStep(Move.DOWN);
                    }

                    if ((gps.getL() > 0) && (gps.getC() == 0))
                    {
                        doStep(Move.LEFT);
                    }

                    if ((gps.getL() == 0) && (gps.getC() < gps.getMaxC()))
                    {
                        doStep(Move.UP);
                    }

                    if ((gps.getL() < gps.getMaxL()) && (gps.getC() == gps.getMaxC()))
                    {
                        doStep(Move.RIGHT);
                    }
                }
                else if (s == State.CLOCKWISE)
                {
                    if ((gps.getL() == gps.getMaxL()) && (gps.getC() > 0))
                    {
                        doStep(Move.UP);
                    }

                    if ((gps.getL() > 0) && (gps.getC() == 0))
                    {
                        doStep(Move.RIGHT);
                    }

                    if ((gps.getL() == 0) && (gps.getC() < gps.getMaxC()))
                    {
                        doStep(Move.DOWN);
                    }

                    if ((gps.getL() < gps.getMaxL()) && (gps.getC() == gps.getMaxC()))
                    {
                        doStep(Move.LEFT);
                    }
                } 
                else if (s == State.ALTERNATING)
                {
                    // Se robô está na origem, ele alterna a estratégia para a oposta.
                    // A estratégia inicial é CLOCKWISE.
                    if ( (gps.getC() == 0) && (gps.getL() == 0) ){
                        if (currentState == State.CLOCKWISE){
                            currentState = State.COUNTER_CW;
                        }
                        if (currentState == State.COUNTER_CW){
                            currentState = State.CLOCKWISE;
                        }
                    }
                    else {
                        currentState = State.CLOCKWISE;
                    }

                }

            } else {

                System.out.println("Não está na borda.");
                
                doStep(Move.RIGHT);


            }
        }
    }
}
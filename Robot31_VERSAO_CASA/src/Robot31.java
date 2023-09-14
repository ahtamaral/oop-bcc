import java.util.concurrent.TimeUnit;

public class Robot31 {
    
    private int id;
    private GPS31 gps;
    private String myName;
    private String myDRE;
    private State31 currentState;

    public Robot31(int id, GPS31 gps) {
        this.id = id;
        this.gps = gps;
        this.myName = new String("Artur Henrique Teixeira do Amaral");
        this.myDRE = new String("122032113");
        this.currentState = State31.STOP; // Inicializado como robô parado.
    }

    public void printStudent(){
        System.out.println("Autor");
        System.out.println("Nome: " + this.myName);
        System.out.println("Nome: " + this.myDRE);
    }

    // Getters fundamentais.
    public int getId() { return id; }
    public GPS31 getGPS() { return gps; }
    public State31 getState() { return this.currentState; }

    // Funções para alterar estado do robô.
    public void stop() { this.currentState = State31.STOP; }
    public void clockwise() { this.currentState = State31.CLOCKWISE; }
    public void counter_cw() { this.currentState = State31.COUNTER_CW; }
    public void alternating() { this.currentState = State31.ALTERNATING; }
    public void go_center() { this.currentState = State31.GO_CENTER; }

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
            this.gps.setY(this.gps.getY()+1);
        } else
        if (m == Move.DOWN) {
            this.gps.setY(this.gps.getY()-1);
        } else
        if (m == Move.LEFT) {
            this.gps.setX(this.gps.getX()-1);
        } else
        if (m == Move.RIGHT) {
            this.gps.setX(this.gps.getX()+1);
        }
        waitStepTime();
    }

    // Função que implementa a estratégia do robô, dependendo da sua posição e do estado da sua variável State31.
    public void move(State31 s) {

        if ( s == State31.STOP) {
            doStep(Move.STOP);
        } 
        else {

            // Verificando se o robô está na borda; Se estiver, aplica estratégia. Senão, move-se constantemente à direita até chegar nela.
            if ( ( gps.getX() == 0 ) ||
                 ( gps.getY() == 0 ) ||
                 ( gps.getX() == gps.getMaxX() ) ||
                 ( gps.getY() == gps.getMaxY() ) ) 
            {
                // System.out.println("Está na borda.");

                if (s == State31.CLOCKWISE)
                {
                    // Se está na borda direita.
                    if ( ( gps.getX() == gps.getMaxX() ) && ( gps.getY() > 0 ) ) {
                        doStep(Move.DOWN);
                    }
                    // Se está na borda inferior.
                    if ( ( gps.getX() > 0)  && ( gps.getY() == 0 ) ) {
                        doStep(Move.LEFT);
                    }
                    // Se está na borda esquerda
                    if ( ( gps.getX() == 0) && (gps.getY() < gps.getMaxY() ) ) {
                        doStep(Move.UP);
                    }
                    // Se está na borda superior.
                    if ((gps.getX() < gps.getMaxX()) && (gps.getY() == gps.getMaxY())) {
                        doStep(Move.RIGHT);
                    }
                }
                else
                if (s == State31.COUNTER_CW)
                {
                    // Se está na borda direita.
                    if ( (gps.getX() == gps.getMaxX()) && (gps.getY() < gps.getMaxY()) ) {
                        doStep(Move.UP);
                    }
                    // Se está na borda superior.
                    if ( (gps.getX() > 0) && (gps.getY() == gps.getMaxY()) ) {
                        doStep(Move.LEFT);
                    }
                    // Se está na borda esquerda
                    if ( (gps.getX() == 0) && (gps.getY() > 0) ) {
                        doStep(Move.DOWN);
                    }
                    // Se está na borda inferior.
                    if ( (gps.getX() < gps.getMaxX()) && (gps.getY() == 0)) {
                        doStep(Move.RIGHT);
                    }
                }
                else 
                if (s == State31.ALTERNATING)
                {
                    // No ponto (20,MAX_Y), ele alterna a estratégia para a oposta.
                    // A estratégia inicial é CLOCKWISE.

                    if (gps.getX() == 20 && gps.getY() == gps.getMaxY())
                    {
                        System.out.println("PONTO DE TROCA.");
                        if (getState() == State31.CLOCKWISE){
                            counter_cw();
                        }
                        if (getState() == State31.COUNTER_CW){
                            clockwise();
                        }
                    }
                    else
                    {
                        currentState = State31.CLOCKWISE;
                    }
                }
            }
            else {
                // System.out.println("Não está na borda.");
                doStep(Move.RIGHT);
            }
        }
    }
}
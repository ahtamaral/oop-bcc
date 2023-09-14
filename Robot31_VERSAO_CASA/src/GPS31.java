public class GPS31 {
    private int x; // Coordenada horizontal (l do problema.)
    private int y; // Coordenada vertical (c do problema.)
    
    private int MAX_X = 40; // Considerando dimensões de 0 a MAX_X
    private int MAX_Y = 40; // Considerado dimensões de 0 a MAX_Y

    public GPS31(int x, int y) {

        if ((x > MAX_X || x < 0) || (y > MAX_X || y < 0)) {
            System.out.println("Alguma das coordenadas iniciais é inválida. Altere e tente novamente.");
            System.exit(1);
        }

        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }

    public int getMaxX() { return MAX_X; }
    public int getMaxY() { return MAX_Y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public String printCoordinates() {
        return "(x,y): (" + x + "," + y + ")";
    }
}

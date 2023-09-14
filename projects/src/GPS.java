public class GPS {
    private int l; // Coordenada horizontal (x)
    private int c; // Coordenada vertical (y)
    
    private int MAX_L = 40; // Considerado intervalo de 0 a MAX_L
    private int MAX_C = 40; // Considerado intervalo de 0 a MAX_C

    public GPS(int c, int l) {
        this.c = c;
        this.l = l;
    }
    
    public int getC() {
        return c;
    }

    public int getL() {
        return l;
    }

    public int getMaxL() {
        return MAX_L;
    }

    public int getMaxC() {
        return MAX_C;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setL(int l) {
        this.l = l;
    }

    public String printCoordinates() {
        return "(c,l): (" + c + "," + l + ")";
    }
}

public class GPS {
    private int c; // Latitude
    private int l; // Longitude

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

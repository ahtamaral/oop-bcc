public class Robot99 {
    
    private int id;
    private GPS gps;
    private String myName;
    private String myDRE;

    public Robot99(int id, GPS gps) {
        this.id = id;
        this.gps = gps;
        this.myName = new String("Artur Henrique Teixeira do Amaral");
        this.myDRE = new String("122032113");
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
}
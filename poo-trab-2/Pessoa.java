public class Pessoa {

    private String name;
    private int id;

    public Pessoa(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void show() {
        System.out.println("[" + this.id + "] " + this.name );
    }

    public String getName(){ return this.name; }
    public int getId(){ return this.id; }
}
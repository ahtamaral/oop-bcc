import java.util.ArrayList;
import java.util.List;

public class Evento { 

    private String description;
    private int id;
    private List<Pessoa> listaDePessoas = new ArrayList<>();
    private int recurrence = 0;

    public Evento(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public void show() {
        System.out.println("[" + this.id + "] " + this.description );
    }

    public String getDescription(){ return this.description; }
    public int getId(){ return this.id; }
    public void call() { 
        this.recurrence += 1; 
        System.out.println("O evento " + this.description + " ocorreu!" + " Este evento ocorreu " + this.recurrence +" vezes." );
    }

    List<Pessoa> getListaDePessoas() {
        return this.listaDePessoas;
    }
    void updateListaDePessoas(List<Pessoa> l) {
        this.listaDePessoas = l;
    }

}

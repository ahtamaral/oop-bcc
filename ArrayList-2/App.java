import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void printMenu(String[] options) {
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Escolha uma operação : ");
    }


    public static void main(String[] args) {
        System.out.println("POO 2023.2 - Trabalho 2 (Eventos)\n");

        String name;
        String description;
        int id;

        List<Pessoa> listaDePessoas = new ArrayList<>();
        List<Evento> listaDeEventos = new ArrayList<>();
        List<Evento> listaOrdenadaDeEventos = new ArrayList<>();

        String[] options = {
            "\n[-1] - Cadastrar pessoa",
            "[-2] - Cadastrar evento",
            "[-3] - Listar pessoas\n",
            "0 - SAIR\n",
        };

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (true) {

            printMenu(options);
            option = Integer.parseInt(scanner.nextLine());

            switch (option) 
            {
                case 0:
                    System.out.println("Encerrando programa.");
                    System.exit(1);
                    break;
                case -1:
                    System.out.println("Cadastro de pessoa.");

                    System.out.print("Nome: ");
                    name = scanner.nextLine();
                    System.out.print("Identificador: ");
                    id = Integer.parseInt(scanner.nextLine());

                    // Instanciando pessoa e salvando na lista de pessoas.
                    Pessoa p = new Pessoa(name, id);
                    p.show();
                    listaDePessoas.add(p);

                    break;
                case -2:
                    System.out.println("Cadastro de evento.");

                    System.out.print("Descrição: ");
                    description = scanner.nextLine();
                    System.out.print("Identificador: ");
                    id = Integer.parseInt(scanner.nextLine());


                    // Instanciando evento e salvando na lista de eventos.
                    Evento e = new Evento (description, id);
                    e.show();
                    listaDeEventos.add(e);
                    listaOrdenadaDeEventos.add(e);

                    break;
                case -3:
                    System.out.println("Lista de pessoas.");
                    
                    for (Pessoa pessoa : listaDePessoas) 
                    {
                        System.out.println("[#" + pessoa.getId() + "] " + pessoa.getName());
                    }

                    break;
                default:
                    // Caso não seja nenhuma das 4 opções anteriores, chama evento se for número positivo.
                    // Emite mensagem de erro caso seja negativo.
                    boolean eventFound = false;

                    if (option < 0){
                        System.out.println("Insira um número positivo.");
                    } else {
                        for (Evento evento : listaDeEventos) {
                            if (evento.getId() == option) {
                                evento.call();
                                eventFound =  true;
                            }
                        }
                        if (!eventFound) {
                            System.out.println("Evento de id " + option + " não existe no sistema.");
                        }
                    }

                System.out.println("Aperte qualquer tecla para continuar.");
                scanner.nextLine(); 
            }
        }
    }
}
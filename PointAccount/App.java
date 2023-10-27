import java.util.Scanner;
import java.util.ArrayList;

class App
{
    public static void main(String[] args) 
    {
        System.out.println("-----\nProgramação orientada a objetos 2023-2\nInstituto de computação - UFRJ\nProf: Mitre\nAluno: Artur Amaral | DRE: 122032113\n-----\n");
        System.out.println("");

        String options =  "---\nMENU\n\n [ 1 ] Cadastrar conta\n [ 2 ] Listar contas\n [ 3 ] Depositar\n [ 4 ] Sacar \n [ 5 ] Transferir\n\n [ 0 ] SAIR\n---\n";

        boolean execute = true;
        Scanner scanner = new Scanner(System.in);
        int operation;
        int accountId;
        int deposit;
        Bank bank = new Bank();
        ArrayList<Account> accounts;

        while(execute)
        {
            System.out.println(options);
            System.out.print("Escolha uma operação: ");
            
            operation = Integer.parseInt(scanner.nextLine());
            
            switch (operation)
            {
                case 1:
                    
                    System.out.print("Insira o id da conta: ");

                    accountId = Integer.parseInt(scanner.nextLine());

                    boolean register = true;
                    for ( Account b : bank.getAccounts() )
                    {
                        if (b.getId() == accountId)
                        {
                            System.out.println("Registro de id's repetidos não são permitidos. Tente novamente.");
                            register = false;
                        }
                    }

                    if (register)
                    {
                        Account a = new Account(accountId);
                        bank.registerAccount(a);
                    }

                    register = true;

                    break;
                case 2:
                    bank.listAccounts();
                    break;
                case 3:
                    System.out.print("Valor do depósito: ");
                    deposit = Integer.parseInt(scanner.nextLine());
                    System.out.print("Id da conta: ");
                    accountId = Integer.parseInt(scanner.nextLine());


                    boolean deposited = false;
                    for ( Account b : bank.getAccounts() )
                    {
                        if (b.getId() == accountId)
                        {
                            b.deposit(deposit);
                            deposited = true;
                        }
                    }

                    if (!deposited)
                    {
                        System.out.println("Conta não existe. Depósito falhou.");
                    }

                    deposited = false;

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    execute = false;
                    break;
            }

            // execute = false;
        }

    }
}
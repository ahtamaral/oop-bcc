class App
{
    public static void main(String []args)
    {
        // Printando no stdout.
        System.out.println("Hello world.");
        System.out.println("This is my first program in Java.");
        System.out.print("The end.");

        // Tipos primitivos

        boolean bool = false;
        byte ushort = -10;
        short a = 0;
        int b = 0;
        long c = 600000;
//        float d = 0.1;
        double e = 1.0/90;
        char firstChar = 78;
        char secondChar = 'a';

        // Apendando o valor das variáveis no print.

        System.out.println("These are my variables ");
        System.out.println("bool: " + bool);
        System.out.println("ushort: " + ushort);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
//        System.out.println("d: " + d);
        System.out.println("e: " + e);
        System.out.println("fChar: " + firstChar);
        System.out.println("sChar: " + secondChar);

        // Tipos não primitivos

        // 1. String (deve ser uma classe)
        String name = "Artur Amaral";
        String text = "My name is " + name;
        System.out.println(text);
     
        // 2. Classe (blueprint a partir do qual objetos são criados.)
        // Componentes de uma classe, em ordem:
        // 2.1 Modificadores (Access specifiers)
        // 2.2 Nome da classe 
        // 2.3 Superclass (Opcional - Classe pai)
        // 2.4 Interfaces (Opcional - Lista separada por vírgulas de interfaces implementadas pela classe)
        // 2.5 Corpo {}

        // 3. Objeto
        // 3.1 Estado - Variáveis membro
        // 3.2 Comportamento - Métodos que implementa
        // 3.3 Identidade - Nome único do objeto
       
        // 4. Interface
        // O que uma classe deve fazer, não como.
        // Toda classe que implementa certa interface, deve implementar os métodos associados à ela.
        // 

        // 5. Array
        //* Conjunto de variáveis de tipo parecido
        //* Todos os arrays são alocados dinamicamente (Garbage Collection)
        //* É uma classe, existe uma variável membro com seu tamanho (length)        
        //* Superclasse de um Array é Object

        String[] cars = {"Fiat", "Toyota", "Honda", "Hyundai"};
        int[] n = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("n[4]: " + n[4]);
        System.out.println("length: " + n.length);
    }
};

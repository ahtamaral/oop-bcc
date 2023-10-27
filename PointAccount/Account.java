class Account
{
    private int MIN_BALANCE = 0;
    private int MAX_BALANCE = 1000;
    private int balance = 0;
    private int id;

    public Account(int id)
    {
        this.id = id;
    }
    
    public int getId() { return this.id; }
    public int getBalance() { return this.balance; }

    public boolean deposit(int value)
    {
        int nextBalance = this.balance + value;

        if (nextBalance > MAX_BALANCE)
        {
            System.out.println("EXCEEDED.");
            // EMITE EXCEÇÃO.
            return false;
        }

        this.balance = nextBalance;
        return true;
    }

    public boolean remove(int value)
    {
        int nextBalance = this.balance - value;

        if (nextBalance < MIN_BALANCE)
        {
            System.out.println("EXCEEDED.");
            // EMITE EXCEÇÃO.
            return false;
        }

        this.balance = nextBalance;
        return true;
    }

    public boolean transfer(int id, int value)
    {
        return true;
    }

    public boolean show()
    {
        System.out.println("[#" + getId() + "] Balance: " + getBalance());
        return true;
    }

}
import java.util.ArrayList;

class Bank
{
    private ArrayList<Account> accounts;

    public Bank() 
    {
        this.accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }

    public boolean listAccounts()
    {
        for (Account account : accounts)
        {
            account.show();
        }
        return true;
    }

    public boolean registerAccount(Account account)
    {
        this.accounts.add(account);
        return true;
    }

}
package ioc1;

public class AccountServiceImpl1 implements AccountService  {

    private AccountDao accountDao;
    public AccountServiceImpl1(AccountDao accountDao){
        this.accountDao=accountDao;
    }

    @Override
    public void doSomething() {


    }
}

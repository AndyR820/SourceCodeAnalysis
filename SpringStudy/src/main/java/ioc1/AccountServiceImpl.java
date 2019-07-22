package ioc1;

public class AccountServiceImpl implements AccountService {
    /**
     * 需要注入的对象
     */
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public void doSomething() {
        System.out.println("AccountServiceImpl#doSomething......");
        accountDao.addAccount();

    }
}

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

interface IAccountService {
    double getAccountAmount(int accountId) throws InterruptedException;
    void creditAmount(double amount, int accountId) throws InterruptedException;
    void debitAmount(double amount, int accountId) throws InterruptedException;
}

class AccountServiceManager implements IAccountService {
    private double amount = 0;

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    Lock readLock = reentrantReadWriteLock.readLock();
    Lock writeLock = reentrantReadWriteLock.writeLock();

    @Override
    public double getAccountAmount(int accountId) throws InterruptedException {

        System.out.println("getAmount " + Thread.currentThread().getName());
        readLock.lock();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Double> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return this.amount;
        };
        Future<Double> future = executor.submit(callableTask);
        Double result = null;
        try {
            result = future.get(2000, TimeUnit.MILLISECONDS);
            System.out.println("result=>" + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }
        System.out.println("End of getAmount");
        readLock.unlock();
        return result;
    }

    public void debitAmount(double amount, int accountId) throws InterruptedException {
        writeLock.lock();
        getAccountAmount(accountId);
        this.amount = this.amount + amount;
        writeLock.unlock();
    }

    public void creditAmount(double amount, int accountId) throws InterruptedException {
        writeLock.lock();
        getAccountAmount(accountId);
        this.amount = this.amount - amount;
        writeLock.unlock();
    }

    public void setOpeningAmount(double amount) {
        this.amount = amount;
    }
}

class AccountInfo {
    private int _accountId;
    private IAccountService _accountService;

    public AccountInfo(int _accountId, IAccountService _accountService) {
        this._accountId = _accountId;
        this._accountService = _accountService;
    }

    private double amount;

    public void RefreshAmount() throws InterruptedException {
        amount = _accountService.getAccountAmount(_accountId);
    }

    public IAccountService getAccountService() {
        return _accountService;
    }

    public int getAccountId() {
        return _accountId;
    }

    public void setAccountId(int _accountId) {
        this._accountId = _accountId;
    }
}

class DebitAccount extends Thread {
    private AccountInfo accountInfo;
    private double debitAmount;

    public DebitAccount(AccountInfo accountInfo, double debitAmount) {
        this.accountInfo = accountInfo;
        this.debitAmount = debitAmount;
    }

    @Override
    public void run() {
        System.out.println("Thread name => " + Thread.currentThread().getName());
        try {
            accountInfo.getAccountService().debitAmount(getDebitAmount(), accountInfo.getAccountId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }
}

class CreditAccount extends Thread {
    private AccountInfo accountInfo;
    private double creditAmount;

    public CreditAccount(AccountInfo accountInfo, double creditAmount) {
        this.accountInfo = accountInfo;
        this.creditAmount = creditAmount;
    }

    @Override
    public void run() {
        System.out.println("Thread name => " + Thread.currentThread().getName());
        try {
            accountInfo.getAccountService().creditAmount(getCreditAmount(), accountInfo.getAccountId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }
}


public class Bank {
    public static void main(String args[]) throws InterruptedException {
        AccountServiceManager accountServiceManager = new AccountServiceManager();
        accountServiceManager.setOpeningAmount(100);
        AccountInfo accountInfo = new AccountInfo(101, accountServiceManager);

        CreditAccount creditAccount = new CreditAccount(accountInfo, 5);
        DebitAccount debitAccount = new DebitAccount(accountInfo, 10);

        creditAccount.start();
        debitAccount.start();

        creditAccount.join();
        debitAccount.join();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("we currently have " + accountInfo.getAccountService().getAccountAmount(101));
    }
}

package proccessAndThread.sync;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-14
 * 풀이방법
 **/


public class WithdrawTask implements Runnable {

    private BankAccount account;
    private int amount;


    public WithdrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);

    }
}
